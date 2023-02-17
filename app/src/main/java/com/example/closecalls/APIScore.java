package com.example.closecalls;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIScore {
    @FormUrlEncoded
    @POST("scorecardByMatchId/3c23ed5356d24d4884c2782f8ad45a9f")
    Call<ScoreModel> getMatchScore(@Field("match_id") String match_id);
}
