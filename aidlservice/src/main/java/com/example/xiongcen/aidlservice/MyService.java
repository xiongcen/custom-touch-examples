package com.example.xiongcen.aidlservice;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {

    private final static String TAG = "MyService";
    private static final String PACKAGE_SAYHI = "com.example.xiongcen.aidlclient";

    private NotificationManager mNotificationManager;
    private boolean mCanRun = true;
    private List<Student> mStudents = new ArrayList<Student>();

    //这里实现了aidl中的抽象函数
    private final IMyService.Stub mBinder = new IMyService.Stub() {

        @Override
        public List<Student> getStudent() throws RemoteException {
            // 使用synchronized关键字的原因：由于服务端的Binder方法运行在Binder的线程池中，
            // 所以Binder方法不管是否耗时都应该采用同步的方法去实现，因为它已经运行在一个线程中了。
            System.out.println("xc " + "MyService.getStudent "+(Thread.currentThread().getId()== Looper.getMainLooper().getThread().getId()));
            synchronized (mStudents) {
                Log.d(TAG, "MyService mBinder getStudent()");
                return mStudents;
            }
        }

        @Override
        public void addStudent(Student student) throws RemoteException {
            synchronized (mStudents) {
                if (!mStudents.contains(student)) {
                    mStudents.add(student);
                }
            }
        }

        // 在这里可以做权限认证，return false意味着客户端的调用就会失败，比如下面，
        // 只允许包名为com.example.xiongcen.aidlclient的客户端通过，其他apk将无法完成调用过程
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
                throws RemoteException {
            String packageName = null;
            String[] packages = MyService.this.getPackageManager().
                    getPackagesForUid(getCallingUid());
            if (packages != null && packages.length > 0) {
                packageName = packages[0];
            }
            Log.d(TAG, "onTransact: " + packageName);
            if (!PACKAGE_SAYHI.equals(packageName)) {
                return false;
            }

            return super.onTransact(code, data, reply, flags);
        }

    };

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate..."+ android.os.Process.myPid());
        Thread thr = new Thread(null, new ServiceWorker(), "BackgroundService");
        thr.start();

        synchronized (mStudents) {
            for (int i = 1; i < 6; i++) {
                Student student = new Student();
                student.name = "student#" + i;
                student.age = i * 5;
                mStudents.add(student);
            }
        }

        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, String.format("on bind,intent = %s", intent.toString()));
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mCanRun = false;
        super.onDestroy();
    }

    class ServiceWorker implements Runnable {
        long counter = 0;

        @Override
        public void run() {
            // do background processing here.....
            while (mCanRun) {
                Log.d(TAG, "" + counter);
                counter++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
