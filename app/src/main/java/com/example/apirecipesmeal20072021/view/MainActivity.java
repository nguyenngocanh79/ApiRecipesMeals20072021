package com.example.apirecipesmeal20072021.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.apirecipesmeal20072021.R;
import com.example.apirecipesmeal20072021.api.ApiRequest;
import com.example.apirecipesmeal20072021.api.RetrofitClient;
import com.example.apirecipesmeal20072021.model.ApiListResponse;
import com.example.apirecipesmeal20072021.model.Meal;
import com.example.apirecipesmeal20072021.repository.MealRepository;
import com.example.apirecipesmeal20072021.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRcvMeal;
    List<Meal> mListMeal;
    MealAdapter mMealAdapter;
    MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRcvMeal = findViewById(R.id.recyclerView1);
        mListMeal = new ArrayList<>();
        mMealAdapter = new MealAdapter(mListMeal, this);

        LinearLayoutManager layoutManager1
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRcvMeal.setLayoutManager(layoutManager1);
        mRcvMeal.setHasFixedSize(true);
        mRcvMeal.setAdapter(mMealAdapter);

        //Khởi tạo ViewModel
        mMainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                if (modelClass == MainViewModel.class){
                    return (T) new MainViewModel(new MealRepository());
                }
                return null;
            }
        }).get(MainViewModel.class);

        mMainViewModel.getDataMeals().observe(this, new Observer<List<Meal>>() {
            @Override
            public void onChanged(List<Meal> meals) {
                mListMeal.clear();
                mListMeal.addAll(meals);
                mMealAdapter.notifyDataSetChanged();

            }
        });
        mMainViewModel.getMeals();
    }

}