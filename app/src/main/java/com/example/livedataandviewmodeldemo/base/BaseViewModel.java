package com.example.livedataandviewmodeldemo.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class BaseViewModel<T> extends AndroidViewModel {
     MutableLiveData<T> tMutableLiveData = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<T> gettMutableLiveData() {
        return tMutableLiveData;

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
