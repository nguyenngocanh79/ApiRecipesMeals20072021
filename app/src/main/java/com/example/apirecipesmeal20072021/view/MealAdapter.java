package com.example.apirecipesmeal20072021.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.example.apirecipesmeal20072021.R;
import com.example.apirecipesmeal20072021.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends RecyclerView.Adapter<ViewHolder>{

    private final int TYPE_ITEM = 0;
    private final int TYPE_LOADING = 1;
    private boolean isLoading = false;
    private Context context;


    List<Meal> listMeal;

    MealAdapter(List<Meal> listMeal, Context context){
        this.listMeal = listMeal;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == listMeal.size()-1 && isLoading){
            return TYPE_LOADING;
        }
        return TYPE_ITEM;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Khai báo lớp đối tượng để convert kiểu int sang kiểu view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (TYPE_ITEM == viewType){
            View view = layoutInflater.inflate(R.layout.item_meal,parent,false);
            return new MealViewHolder(view);
        }else{
            View view = layoutInflater.inflate(R.layout.item_loading,parent,false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM){
            ((MealViewHolder)holder).onBindView(listMeal.get(position) , position);
        }
    }

    @Override
    public int getItemCount() {
        return listMeal.size();
    }

    class MealViewHolder extends ViewHolder{

        ImageView img;
        TextView tvName,tvSummary, tvCalo;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.circleImage);
            tvName = itemView.findViewById(R.id.textViewName);
            tvSummary = itemView.findViewById(R.id.textViewSummary);
            tvCalo = itemView.findViewById(R.id.textviewCalo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,MainActivity2.class);
                    intent.putExtra("meal", listMeal.get(getAdapterPosition()));

                    Pair[] pairs = new Pair[4];
                    pairs[0] = new Pair<View, String>(img,"imageTransition");
                    pairs[1] = new Pair<View, String>(tvName,"nameTransition");
                    pairs[2] = new Pair<View, String>(tvName,"caloTransition");
                    pairs[3] = new Pair<View, String>(tvName,"instructionTransition");

                    // create the transition animation - the images in the layouts
                    // of both activities are defined with android:transitionName="xxx"
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity)context,pairs);
                    // start the new activity
//                    startActivity(intent, options.toBundle());
                    context.startActivity(intent, options.toBundle());
                }
            });
        }

        public void onBindView(Meal meal , int position){
            String url = "https://mealrecipes.000webhostapp.com/" + meal.getImage().replace("\\","/");
            Glide.with(context)
                    .load(url)
                    .into(img);
            tvName.setText(meal.getName());
            tvSummary.setText(meal.getInstruction());
            tvCalo.setText(meal.getCalo() +" Kcal");

        }
    }

    class LoadingViewHolder extends ViewHolder{

        ProgressBar progressBarLoading;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBarLoading = itemView.findViewById(R.id.progressbarLoading);
        }
    }


    public void addFooterLoading(){
        isLoading = true;
        listMeal.add(null);
    }

    public void removeLoading(){
        isLoading = false;
        int position = listMeal.size() - 1;
        listMeal.remove(position);
        notifyItemRemoved(position);
    }

}