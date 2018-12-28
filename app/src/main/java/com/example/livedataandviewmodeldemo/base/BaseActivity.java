package com.example.livedataandviewmodeldemo.base;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;


import com.example.livedataandviewmodeldemo.bean.ApiService;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.annotations.NonNull;

public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity {
    @Inject
    public ApiService apiService;
    protected T viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setBaseViewModel(getTClass());

    }

    private void setBaseViewModel(@NonNull Class<T> modelClass) {
        viewModel = ViewModelProviders.of(this).get(modelClass);
        getLifecycle().addObserver(viewModel);
    }
    private Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @Override
    protected void onDestroy() {
        viewModel.onCleared();
        viewModel = null;
        super.onDestroy();
    }
}
