package com.example.livedataandviewmodeldemo.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.livedataandviewmodeldemo.bean.ApiService;
import com.example.livedataandviewmodeldemo.di.component.AppComponent;
import com.example.livedataandviewmodeldemo.di.component.DaggerAppComponent;
import com.example.livedataandviewmodeldemo.di.component.DaggerViewModelComponent;
import com.example.livedataandviewmodeldemo.di.component.ViewModelComponent;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends AndroidViewModel implements LifecycleObserver {
    String TAG = this.getClass().getSimpleName();
    CompositeDisposable compositeDisposable;

    @Inject
    public ApiService apiService;

    public void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public void unSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }

    }

    public BaseViewModel(@NonNull Application application) {
        super(application);
        AppComponent appComponent = DaggerAppComponent.builder().build();
        ViewModelComponent daggerViewModelComponent = DaggerViewModelComponent.builder().appComponent(appComponent).build();
        daggerViewModelComponent.inject(this);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        unSubscribe();
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Log.i(TAG, "onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Log.i(TAG, "onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.i(TAG, "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Log.i(TAG, "onPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Log.i(TAG, "onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        //onCleared();
    }

}
