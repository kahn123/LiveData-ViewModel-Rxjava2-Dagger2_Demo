package com.example.livedataandviewmodeldemo.di.module;

import com.example.livedataandviewmodeldemo.activity.MainActivity;
import com.example.livedataandviewmodeldemo.di.component.BaseActivityComponent;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseActivityComponent.class)
public abstract class AllActivityModule {

    @ContributesAndroidInjector(modules = MainActivityModel.class)
    abstract MainActivity contributeMain();
}
