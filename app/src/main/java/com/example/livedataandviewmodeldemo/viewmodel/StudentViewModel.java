package com.example.livedataandviewmodeldemo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.livedataandviewmodeldemo.base.BaseViewModel;
import com.example.livedataandviewmodeldemo.bean.ApiService;
import com.example.livedataandviewmodeldemo.di.component.AppComponent;
import com.example.livedataandviewmodeldemo.di.component.DaggerAppComponent;
import com.example.livedataandviewmodeldemo.di.component.DaggerViewModelComponent;
import com.example.livedataandviewmodeldemo.di.component.ViewModelComponent;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class StudentViewModel extends BaseViewModel<String> {
    MutableLiveData<String> stringMutableLiveData = new MutableLiveData<>();
    @Inject
    ApiService apiService;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        AppComponent appComponent = DaggerAppComponent.builder().build();
        ViewModelComponent daggerViewModelComponent = DaggerViewModelComponent.builder().appComponent(appComponent).build();
        daggerViewModelComponent.inject(this);

    }


    public MutableLiveData<String> gettMutableLiveData() {
        return stringMutableLiveData;
    }

    public void getData() {
        Map<String, String> map = new HashMap<>();
        map.put("page", "1");
        apiService.obtainNews(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                            addSubscribe(d);
                    }

                    @Override
                    public void onNext(String s) {
                        stringMutableLiveData.setValue(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        stringMutableLiveData.setValue("123456");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
