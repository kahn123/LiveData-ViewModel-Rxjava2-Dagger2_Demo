package com.example.livedataandviewmodeldemo.di.module;

import com.example.livedataandviewmodeldemo.di.component.BaseFragmentComponent;
import com.example.livedataandviewmodeldemo.fragment.FragmentOne;
import com.example.livedataandviewmodeldemo.fragment.FragmentTwo;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(subcomponents = BaseFragmentComponent.class)
public abstract class AllFragmentModule {

    @ContributesAndroidInjector(modules = FragmentOneModule.class)
    abstract FragmentOne contributeFragOne();

    @ContributesAndroidInjector(modules = FragmentTwoModule.class)
    abstract FragmentTwo contributeFragTwo();
}
