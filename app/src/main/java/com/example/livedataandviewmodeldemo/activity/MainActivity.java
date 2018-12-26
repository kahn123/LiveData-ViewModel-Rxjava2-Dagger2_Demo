package com.example.livedataandviewmodeldemo.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.livedataandviewmodeldemo.R;
import com.example.livedataandviewmodeldemo.base.BaseActivity;
import com.example.livedataandviewmodeldemo.fragment.FragmentOne;
import com.example.livedataandviewmodeldemo.fragment.FragmentTwo;
import com.example.livedataandviewmodeldemo.viewmodel.StudentViewModel;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class MainActivity extends BaseActivity {
    StudentViewModel studentViewModel;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);
        getSupportFragmentManager().beginTransaction().replace(R.id.fm1, new FragmentOne()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fm2, new FragmentTwo()).commit();
        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             studentViewModel.getData();
            }
        });
        studentViewModel.gettMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                bt1.setText(s);
            }
        });
    }

    @Override
    protected void onDestroy() {
        studentViewModel.gettMutableLiveData().removeObservers(this);
        super.onDestroy();

    }
}
