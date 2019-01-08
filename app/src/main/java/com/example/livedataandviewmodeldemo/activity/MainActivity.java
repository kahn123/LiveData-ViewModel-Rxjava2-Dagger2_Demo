package com.example.livedataandviewmodeldemo.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.livedataandviewmodeldemo.R;
import com.example.livedataandviewmodeldemo.base.BaseActivity;
import com.example.livedataandviewmodeldemo.fragment.FragmentOne;
import com.example.livedataandviewmodeldemo.fragment.FragmentTwo;
import com.example.livedataandviewmodeldemo.viewmodel.StudentViewModel;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity<StudentViewModel> {

    Button bt1;
    LiveData<Location> myLocationListener = new MutableLiveData<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = findViewById(R.id.bt1);
        getSupportFragmentManager().beginTransaction().replace(R.id.fm1, new FragmentOne()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fm2, new FragmentTwo()).commit();


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getData();
//                finish();
                viewModel.getData();
//                startActivity(new Intent(MainActivity.this,SecondActivity.class));
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
