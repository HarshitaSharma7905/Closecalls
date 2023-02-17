package com.example.closecalls;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIUpcoming {
    @GET("upcomingMatches/3c23ed5356d24d4884c2782f8ad45a9f")
    Call<HomeModel> getUpcomingData();
}
