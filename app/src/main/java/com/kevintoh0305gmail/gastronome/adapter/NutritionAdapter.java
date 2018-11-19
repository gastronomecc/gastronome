package com.kevintoh0305gmail.gastronome.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevintoh0305gmail.gastronome.R;
import com.kevintoh0305gmail.gastronome.viewHolder.NutritionViewHolder;

import java.util.ArrayList;

public class NutritionAdapter extends RecyclerView.Adapter<NutritionViewHolder> {
    Context context;
    ArrayList<String> nutritions;

    public NutritionAdapter(Context c, ArrayList<String> l)
    {
        context = c;
        nutritions = l;
    }

    public NutritionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.nutritionviewholder,parent,false);
        return new NutritionViewHolder(item, context);
    }

    @Override
    public void onBindViewHolder(@NonNull NutritionViewHolder nutritionViewHolder, int i) {
        nutritionViewHolder.txtNutritions.setText(nutritions.get(i));
    }

    @Override
    public int getItemCount() {
        return nutritions.size();
    }
}
