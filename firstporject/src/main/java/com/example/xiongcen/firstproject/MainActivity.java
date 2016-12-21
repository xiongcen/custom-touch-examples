package com.example.xiongcen.firstproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue("xiongcen", "test_share_data", "测试数据共享");
            }
        });
    }

    private SharedPreferences getSharedPreference(String group) {

        SharedPreferences sp = null;
        if (TextUtils.isEmpty(group)) {
            sp = PreferenceManager.getDefaultSharedPreferences(this);
        } else {
            sp = this.getSharedPreferences(group,
                    Context.MODE_MULTI_PROCESS);
        }

        return sp;
    }

    public void setValue(String group, String key, String defaultValue) {
        SharedPreferences sp = getSharedPreference(group);
        SharedPreferences.Editor editor = sp.edit().putString(key, defaultValue);
        editor.apply();
    }
}
