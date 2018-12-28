package com.example.livedataandviewmodeldemo.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel<T> extends AndroidViewModel implements LifecycleObserver {
    String TAG= this.getClass().getSimpleName();
    CompositeDisposable compositeDisposable;

    MutableLiveData<T> tMutableLiveData = new MutableLiveData<>();



    public void addSubscribe(Disposable disposable){
        if(compositeDisposable==null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public void unSubscribe(){
        if(compositeDisposable!=null){
            compositeDisposable.clear();
        }

    }
    public BaseViewModel(@NonNull Application application) {
        super(application);

    }

//    public MutableLiveData<T> gettMutableLiveData() {
//        return tMutableLiveData;
//
//    }

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
//        onCleared();
    }
}
