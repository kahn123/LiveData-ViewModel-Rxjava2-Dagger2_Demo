package com.example.livedataandviewmodeldemo.di.component;

import com.example.livedataandviewmodeldemo.base.BaseViewModel;
import com.example.livedataandviewmodeldemo.di.module.ViewModelModule;
import com.example.livedataandviewmodeldemo.viewmodel.StudentViewModel;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = ViewModelModule.class)
public interface ViewModelComponent {

    void inject(BaseViewModel studentViewModel);
}
