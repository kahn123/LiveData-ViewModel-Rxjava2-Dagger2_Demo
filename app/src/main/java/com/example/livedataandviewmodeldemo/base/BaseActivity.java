package com.example.livedataandviewmodeldemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.livedataandviewmodeldemo.bean.ApiService;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class BaseActivity extends AppCompatActivity {
    @Inject
    public ApiService apiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

    }
}
