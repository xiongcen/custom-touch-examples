package com.example.xiongcen.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int mId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        System.out.println("xc " + "MainActivity.onCreate taskid:" + getTaskId() + ";" + this);

        TextView text = (TextView) findViewById(R.id.text);
        text.setText("Main Activity");
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OneActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Button create = (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
    }

    private void createNotification() {

        Context context = getApplicationContext();
        int requestCode = (int) (System.currentTimeMillis() % Integer.MAX_VALUE);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");
        Intent resultIntent = new Intent(this, PushReceiver.class);


        final PendingIntent pIntent = PendingIntent.getBroadcast(context, requestCode, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId++, mBuilder.build());
    }

    public static class PushReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Intent intent1 = new Intent(context, OneActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    }
}
