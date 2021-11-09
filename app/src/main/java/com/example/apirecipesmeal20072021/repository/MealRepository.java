package com.example.apirecipesmeal20072021.repository;

import com.example.apirecipesmeal20072021.api.ApiRequest;
import com.example.apirecipesmeal20072021.api.RetrofitClient;
import com.example.apirecipesmeal20072021.model.ApiListResponse;
import com.example.apirecipesmeal20072021.model.ApiResponse;
import com.example.apirecipesmeal20072021.model.Meal;

import retrofit2.Call;

public class MealRepository {
    private ApiRequest apiRequest;

    public MealRepository(){
        apiRequest = RetrofitClient.getInstance().getApiRequest();
    }

    public Call<ApiResponse<Meal>> getDetailMeal(String id){
        return apiRequest.getDetailMeal(id);
    }

    public Call<ApiListResponse<Meal>> getMeals() {return apiRequest.getMeals();}
}
