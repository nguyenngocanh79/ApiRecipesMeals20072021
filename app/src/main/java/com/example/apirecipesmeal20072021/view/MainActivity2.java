package com.example.apirecipesmeal20072021.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apirecipesmeal20072021.R;
import com.example.apirecipesmeal20072021.model.Meal;
import com.example.apirecipesmeal20072021.repository.MealRepository;
import com.example.apirecipesmeal20072021.viewmodel.MainViewModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {

    MainViewModel mMainViewModel;
    TextView mTvName, mTvCalo, mTvCarbo, mTvProtein, mTvIngredient, mTvInstruction;
    CircleImageView mCircleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTvName = findViewById(R.id.textViewNameMeal);
        mTvCalo = findViewById(R.id.textViewKCalCalories);
        mTvCarbo = findViewById(R.id.textViewGamCarBo);
        mTvProtein= findViewById(R.id.textViewGamProtein);
        mTvIngredient = findViewById(R.id.textViewContentIngredients);
        mTvInstruction = findViewById(R.id.textViewContentRecipePreparation);
        mCircleImage = findViewById(R.id.circleImage);

        Intent intent = getIntent();
        if(intent != null){
            Meal meal = intent.getExtras().getParcelable("meal");
            mTvName.setText(meal.getName());
            mTvCalo.setText(meal.getCalo());
            mTvCarbo.setText(meal.getCarbo());
            mTvProtein.setText(meal.getProtein());
            mTvIngredient.setText(meal.getIngredient().replace("\\r\\n","\r\n"));
            mTvInstruction.setText(meal.getInstruction().replace("\\\\r\\\\n","\r\n"));
            String url = "https://mealrecipes.000webhostapp.com/" + meal.getImage().replace("\\","/");
            Glide.with(MainActivity2.this)
                    .load(url)
                    .into(mCircleImage);
        }


    }
}