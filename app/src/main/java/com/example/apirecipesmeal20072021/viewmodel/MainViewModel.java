package com.example.apirecipesmeal20072021.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apirecipesmeal20072021.model.ApiListResponse;
import com.example.apirecipesmeal20072021.model.ApiResponse;
import com.example.apirecipesmeal20072021.model.Meal;
import com.example.apirecipesmeal20072021.repository.MealRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private MealRepository mealRepository;
    private MutableLiveData<Meal> dataDetailMeal;
    private MutableLiveData<List<Meal>> dataMeals;

    public MainViewModel(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
        dataDetailMeal = new MutableLiveData<>();
        dataMeals = new MutableLiveData<>();
    }

    public LiveData<Meal> getdataDetailMeal() {
        return dataDetailMeal;
    }
    public LiveData<List<Meal>> getDataMeals() {
        return dataMeals;
    }

    public void getMeals() {
        mealRepository
                .getMeals()
                .enqueue(new Callback<ApiListResponse<Meal>>() {
                    @Override
                    public void onResponse(Call<ApiListResponse<Meal>> call, Response<ApiListResponse<Meal>> response) {
                        ApiListResponse<Meal> result = response.body();
                        dataMeals.setValue(result.data);
                    }

                    @Override
                    public void onFailure(Call<ApiListResponse<Meal>> call, Throwable t) {
                        Log.d("BBB", t.getMessage());
                    }
                });
    }

    public void getDetailMeal(String id) {
        mealRepository
                .getDetailMeal(id)
                .enqueue(new Callback<ApiResponse<Meal>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<Meal>> call, Response<ApiResponse<Meal>> response) {
                        ApiResponse<Meal> result = response.body();
                        if (result.data != null) {
                            dataDetailMeal.setValue(result.data);
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<Meal>> call, Throwable t) {
                        Log.d("BBB", t.getMessage());
                    }
                });
    }

}
