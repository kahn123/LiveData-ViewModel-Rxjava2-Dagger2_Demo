package com.example.livedataandviewmodeldemo.bean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET("meituApi")
    Observable<String> obtainNews(@QueryMap Map<String,String> map);
}
