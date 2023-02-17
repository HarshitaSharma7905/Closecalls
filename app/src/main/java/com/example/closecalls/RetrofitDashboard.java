package com.example.closecalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDashboard {
    public static Retrofit retrofit;
    public static Retrofit getRetrofitInstanceData(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }return retrofit;
    }
}
