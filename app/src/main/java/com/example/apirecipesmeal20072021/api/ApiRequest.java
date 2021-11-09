package com.example.apirecipesmeal20072021.api;

import com.example.apirecipesmeal20072021.model.ApiListResponse;
import com.example.apirecipesmeal20072021.model.ApiResponse;
import com.example.apirecipesmeal20072021.model.Meal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("apimeal/detail.php")
    Call<ApiResponse<Meal>> getDetailMeal(@Query("id") String id);

    @GET("apimeal/meals.php")
    Call<ApiListResponse<Meal>> getMeals();
}
