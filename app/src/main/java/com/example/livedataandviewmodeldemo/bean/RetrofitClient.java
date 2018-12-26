package com.example.livedataandviewmodeldemo.bean;

import retrofit2.Retrofit;

public class RetrofitClient {
    Retrofit retrofit;

    public RetrofitClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
