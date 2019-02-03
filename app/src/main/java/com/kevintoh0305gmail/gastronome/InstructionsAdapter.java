package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class InstructionsAdapter extends RecyclerView.Adapter<InstructionsViewHolder>{
    Context context;
    ArrayList<String> instructions;

    public InstructionsAdapter(Context c, ArrayList<String> l)
    {
        context = c;
        instructions = l;
    }

    public InstructionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.instructionsviewholder,parent,false);
        return new InstructionsViewHolder(item, context);
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsViewHolder instructionsViewHolder, int i) {
        instructionsViewHolder.txtInstructions.setText(instructions.get(i));
    }

    @Override
    public int getItemCount() {
        return instructions.size();
    }
}
