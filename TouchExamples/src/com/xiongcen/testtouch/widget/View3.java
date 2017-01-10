package com.xiongcen.testtouch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by xiongcen on 17/1/8.
 */

public class View3 extends TextView {

    private static final String TAG = View3.class.getSimpleName();

    public View3(Context context) {
        super(context);
    }

    public View3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i(TAG, "dispatchTouchEvent---" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "onTouchEvent---" + event.getAction());
        return super.onTouchEvent(event);
    }
}
