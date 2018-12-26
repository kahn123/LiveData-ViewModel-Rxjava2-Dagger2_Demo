package com.example.livedataandviewmodeldemo.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.livedataandviewmodeldemo.bean.ApiService;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class BaseFragment extends Fragment {
    @Inject
    public ApiService apiService;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
