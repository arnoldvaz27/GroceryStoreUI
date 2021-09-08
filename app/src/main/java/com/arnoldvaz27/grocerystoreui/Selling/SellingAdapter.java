package com.arnoldvaz27.grocerystoreui.Selling;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arnoldvaz27.grocerystoreui.R;

import java.util.ArrayList;

public class SellingAdapter extends RecyclerView.Adapter<SellingAdapter.SellingViewHolder> {

    ArrayList<SellingHelper> sellingHelpers;
    final SellingListener sellingListener;

    public SellingAdapter(ArrayList<SellingHelper> sellingHelpers, SellingListener sellingListener) {
        this.sellingHelpers = sellingHelpers;
        this.sellingListener = sellingListener;
    }

    @NonNull

    @Override
    public SellingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selling_layout, parent, false);
        return new SellingViewHolder(view, sellingListener);

    }

    @Override
    public void onBindViewHolder(@NonNull SellingViewHolder holder, @SuppressLint("RecyclerView") int position) {

        SellingHelper offerHelper = sellingHelpers.get(position);
        holder.image.setImageResource(offerHelper.getImage());
        holder.name.setText(offerHelper.getName());
        holder.price.setText(offerHelper.getPrice());
    }

    @Override
    public int getItemCount() {
        return sellingHelpers.size();

    }
    public interface SellingListener {
    }
    public static class SellingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        SellingListener listener;
        public ImageView image,add,remove;
        public TextView name,price,counter;
        public SellingViewHolder(@NonNull View itemView, SellingListener listener) {
            super(itemView);          //hooks

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            remove = itemView.findViewById(R.id.remove);
            add = itemView.findViewById(R.id.add);
            counter = itemView.findViewById(R.id.counter);
            this.listener = listener;

            add.setOnClickListener(this);
            remove.setOnClickListener(this);

        }
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.add){
                int Counter = Integer.parseInt(counter.getText().toString());
                Counter = Counter + 1;
                counter.setText(String.valueOf(Counter));
                remove.setVisibility(View.VISIBLE);
                counter.setVisibility(View.VISIBLE);
            }else if(view.getId() == R.id.remove){
                int Counter = Integer.parseInt(counter.getText().toString());
                Counter = Counter - 1;
                counter.setText(String.valueOf(Counter));
                if(Counter == 0){
                    remove.setVisibility(View.GONE);
                    counter.setVisibility(View.GONE);
                }
            }
        }

    }

}
