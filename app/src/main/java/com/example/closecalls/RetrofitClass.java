package com.example.closecalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    public static Retrofit retrofit;
    public static Retrofit getRetrofitInterface(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl("http://apicricketchampion.in/webservices/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
