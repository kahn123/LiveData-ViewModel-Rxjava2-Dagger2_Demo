package com.example.livedataandviewmodeldemo.di.component;

import com.example.livedataandviewmodeldemo.App;
import com.example.livedataandviewmodeldemo.bean.ApiService;
import com.example.livedataandviewmodeldemo.di.module.AllActivityModule;
import com.example.livedataandviewmodeldemo.di.module.AllFragmentModule;
import com.example.livedataandviewmodeldemo.di.module.AppModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AppModule.class, AllActivityModule.class, AllFragmentModule.class,AndroidInjectionModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent {
    void inject(App app);
    ApiService getApiService();
}
