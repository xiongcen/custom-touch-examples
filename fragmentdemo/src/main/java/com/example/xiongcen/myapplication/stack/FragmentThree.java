package com.example.xiongcen.myapplication.stack;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.xiongcen.myapplication.R;

/**
 * Created by xiongcen on 17/4/26.
 */

public class FragmentThree extends Fragment implements View.OnClickListener{

    private Button mBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, null);
        mBtn = (Button) view.findViewById(R.id.button_three);
        mBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(), " i am a btn in Fragment three",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("FragmentThree.onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("FragmentThree.onDestroy");
    }
}
