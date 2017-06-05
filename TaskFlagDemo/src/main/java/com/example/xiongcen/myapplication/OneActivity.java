package com.example.xiongcen.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xiongcen on 17/5/27.
 */

public class OneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        System.out.println("xc " + "OneActivity#onCreate() taskid:" + getTaskId() + ";" + this);

        getFlag();

        TextView text = (TextView) findViewById(R.id.text);
        text.setText("OneActivity Activity");
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this, TwoActivity.class);
                OneActivity.this.startActivity(intent);
            }
        });

        button.performClick();
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("xc " + "OneActivity#onNewIntent() " + getTaskId());
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("xc " + "OneActivity#onStart() ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("xc " + "OneActivity#onRestart() ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("xc " + "OneActivity#onResume() ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("xc " + "OneActivity#onPause() ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("xc " + "OneActivity#onStop() ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("xc " + "OneActivity#onDestroy() ");
    }

    private void getFlag() {
        Intent intent = getIntent();
        int flags = intent.getFlags();
        System.out.println("xc " + "OneActivity#getFlag() flags:" + flags);
    }
}
