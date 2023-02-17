package com.example.closecalls;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIMatchDetails {
    @FormUrlEncoded
    @POST("liveMatch/3c23ed5356d24d4884c2782f8ad45a9f")
    Call<MatchDetailsModel> getMatchDetails(@Field("match_id") String match_id);
}
