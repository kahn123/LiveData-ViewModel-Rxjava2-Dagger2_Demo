package com.example.livedataandviewmodeldemo.di.component;

import com.example.livedataandviewmodeldemo.base.BaseActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = AndroidInjectionModule.class)
public interface BaseActivityComponent extends AndroidInjector<BaseActivity> {


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity> {

    }
}
