package com.example.closecalls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIContact {
    @FormUrlEncoded
    @POST(" ")
    Call<ContactModel> querySubmit(@Field("name") String name,@Field("email") String email,@Field("mobile") String mobile,@Field("message") String message);
}
