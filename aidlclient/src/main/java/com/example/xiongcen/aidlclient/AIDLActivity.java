package com.example.xiongcen.aidlclient;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.xiongcen.aidlservice.forActivity;
import com.example.xiongcen.aidlservice.forService;

/**
 * Created by xiongcen on 17/2/20.
 */

public class AIDLActivity extends Activity {

    private static final String TAG = "AIDLActivity";
    private Button btnOk;
    private Button btnCancel;
    private Button btnCallBack;

    private void Log(String str) {
        Log.d(TAG, "------ " + str + "------");
    }

    private forActivity mCallback = new forActivity.Stub() {
        public void performAction() throws RemoteException
        {
            Toast.makeText(AIDLActivity.this, "this toast is called from service", Toast.LENGTH_LONG).show();
        }
    };

    forService mService;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            mService = forService.Stub.asInterface(service);
            try {
                mService.registerTestCall(mCallback);}
            catch (RemoteException e) {

            }
        }
        public void onServiceDisconnected(ComponentName className) {
            Log("disconnect service");
            mService = null;
        }
    };
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        btnOk = (Button)findViewById(R.id.btn_ok);
        btnCancel = (Button)findViewById(R.id.btn_cancel);
        btnCallBack = (Button)findViewById(R.id.btn_callback);
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle args = new Bundle();
                Intent intent = new Intent(AIDLActivity.this, AIDLService.class);
                intent.putExtras(args);
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
                startService(intent);
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                unbindService(mConnection);
                //stopService(intent);
            }
        });
        btnCallBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                try
                {
                    mService.invokCallBack();
                } catch (RemoteException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}
