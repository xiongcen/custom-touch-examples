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

public class FragmentTwo extends Fragment implements View.OnClickListener{

    private Button mBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, null);
        mBtn = (Button) view.findViewById(R.id.button_two);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentThree three = new FragmentThree();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.hide(this);
        ft.add(R.id.id_content, three, "Three");
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("FragmentTwo.onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("FragmentTwo.onDestroy");
    }
}
