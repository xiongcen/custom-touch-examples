package com.example.xiongcen.myapplication.stack;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xiongcen.myapplication.R;

/**
 * Created by xiongcen on 17/4/26.
 */

public class FragmentOne extends Fragment implements View.OnClickListener {

    private Button mBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, null);
        mBtn = (Button) view.findViewById(R.id.button_one);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentTwo fTwo = new FragmentTwo();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        // replace如果不加addToBackStack会销毁当前fragment
        ft.replace(R.id.id_content, fTwo, "Two");
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("FragmentOne.onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("FragmentOne.onDestroy");
    }
}
