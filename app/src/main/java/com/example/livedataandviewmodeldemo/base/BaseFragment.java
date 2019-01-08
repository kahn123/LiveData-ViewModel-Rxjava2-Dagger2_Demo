package com.example.livedataandviewmodeldemo.base;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.livedataandviewmodeldemo.bean.ApiService;

import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends BaseViewModel> extends Fragment {
    @Inject
    public ApiService apiService;
    protected T viewModel;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setBaseViewModel(getTClass());
        getLifecycle().addObserver(viewModel);
    }

    private void setBaseViewModel(@NonNull Class<T> modelClass) {
        if (getActivity() != null) {
            viewModel = ViewModelProviders.of(this).get(modelClass);

        }
    }

    private Class<T> getTClass() {
        Class<T> clazz;
        ParameterizedType pt = (ParameterizedType)getClass().getGenericSuperclass();
        clazz = (Class<T>)pt.getActualTypeArguments()[0];
        return clazz;
    }

    @Override
    public void onDestroy() {
        viewModel.onCleared();
        getLifecycle().removeObserver(viewModel);
        viewModel = null;
        super.onDestroy();
    }
}
