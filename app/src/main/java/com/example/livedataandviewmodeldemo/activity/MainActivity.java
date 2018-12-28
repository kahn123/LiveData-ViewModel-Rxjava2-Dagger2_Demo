package com.example.livedataandviewmodeldemo.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.livedataandviewmodeldemo.R;
import com.example.livedataandviewmodeldemo.base.BaseActivity;
import com.example.livedataandviewmodeldemo.fragment.FragmentOne;
import com.example.livedataandviewmodeldemo.fragment.FragmentTwo;
import com.example.livedataandviewmodeldemo.viewmodel.StudentViewModel;

public class MainActivity extends BaseActivity<StudentViewModel> {
//    StudentViewModel studentViewModel;
    Button bt1;
    LiveData<Location> myLocationListener = new MutableLiveData<>();

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);
        getSupportFragmentManager().beginTransaction().replace(R.id.fm1, new FragmentOne()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fm2, new FragmentTwo()).commit();
//        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewModel.getData();
                finish();
            }
        });


        viewModel.gettMutableLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                bt1.setText(String.valueOf(System.currentTimeMillis()) + s);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
