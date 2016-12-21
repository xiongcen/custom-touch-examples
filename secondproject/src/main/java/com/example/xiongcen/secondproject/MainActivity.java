package com.example.xiongcen.secondproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.example.xiongcen.firstproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button2 = (Button) findViewById(R.id.button2);
        final TextView text2 = (TextView) findViewById(R.id.text2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Context context1 = MainActivity.this.createPackageContext("com.example.xiongcen.firstproject", Context.CONTEXT_IGNORE_SECURITY);
                    SharedPreferences sharedPreferences = context1.getSharedPreferences("xiongcen", Context.MODE_MULTI_PROCESS);
                    String data = sharedPreferences.getString("test_share_data", "test_share_data");
                    text2.setText(data);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    text2.setText("出错了！");
                }
            }
        });

    }
}
