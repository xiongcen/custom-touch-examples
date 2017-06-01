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

public class TwoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        System.out.println("xc " + "TwoActivity.onCreate taskid:" + getTaskId() + ";" + this);

        TextView text = (TextView) findViewById(R.id.text);
        text.setText("TwoActivity Activity");
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("xc " + "TwoActivity.onClick ");
                Intent intent = new Intent(TwoActivity.this, TwoActivity.class);
                TwoActivity.this.startActivity(intent);
            }
        });
        getFlag();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("xc " + "TwoActivity.onStart " + this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("xc " + "TwoActivity.onRestart " + this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("xc " + "TwoActivity.onNewIntent " + getTaskId());
        getFlag();
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("xc " + "TwoActivity.onResume " + this);
        getFlag();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("xc " + "TwoActivity.onPause " + this);
        getFlag();
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("xc " + "TwoActivity.onStop " + this);
        getFlag();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("xc " + "TwoActivity.onDestroy " + this);
        getFlag();
    }

    private void getFlag() {
        Intent intent = getIntent();
        int flags = intent.getFlags();
        System.out.println("xc " + "TwoActivity.getFlag flags:" + flags);
    }
}