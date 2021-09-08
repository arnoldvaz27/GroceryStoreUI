package com.arnoldvaz27.grocerystoreui.Grocery;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arnoldvaz27.grocerystoreui.R;

import java.util.ArrayList;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {

    ArrayList<GroceryHelper> groceryHelpers;
    final GroceryListeners groceryListeners;
    public GroceryAdapter(ArrayList<GroceryHelper> groceryHelpers, GroceryListeners groceryListeners) {
        this.groceryHelpers = groceryHelpers;
        this.groceryListeners = groceryListeners;
    }

    @NonNull

    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_list_layout, parent, false);
        return new GroceryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, @SuppressLint("RecyclerView") int position) {

        GroceryHelper storeHelper = groceryHelpers.get(position);
        holder.image.setImageResource(storeHelper.getImage());
        holder.name.setText(storeHelper.getName());
        holder.linearLayout.setBackgroundTintList(storeHelper.getColor());
        holder.linearLayout.setOnClickListener(v -> groceryListeners.onMedicinesClicked(groceryHelpers.get(position), position));
    }

    @Override
    public int getItemCount() {
        return groceryHelpers.size();

    }

    public static class GroceryViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        LinearLayout linearLayout;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);          //hooks

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }
    }
}
