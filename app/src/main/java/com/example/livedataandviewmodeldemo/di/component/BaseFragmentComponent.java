package com.example.livedataandviewmodeldemo.di.component;

import com.example.livedataandviewmodeldemo.base.BaseFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Subcomponent(modules = AndroidSupportInjectionModule.class)
public interface BaseFragmentComponent extends AndroidInjector<BaseFragment> {


    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseFragment> {

    }
}
