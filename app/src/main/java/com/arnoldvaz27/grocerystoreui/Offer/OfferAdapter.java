package com.arnoldvaz27.grocerystoreui.Offer;

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

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    ArrayList<OfferHelper> offerHelpers;
    final OfferListener offerListener;

    public OfferAdapter(ArrayList<OfferHelper> offerHelpers,OfferListener offerListener) {
        this.offerHelpers = offerHelpers;
        this.offerListener = offerListener;
    }

    @NonNull

    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_layout, parent, false);
        return new OfferViewHolder(view, offerListener);

    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {

        OfferHelper offerHelper = offerHelpers.get(position);
        holder.image.setImageResource(offerHelper.getImage());
        holder.name.setText(offerHelper.getName());
        holder.piece.setText(offerHelper.getPiece());
        holder.price.setText(offerHelper.getPrice());
    }

    @Override
    public int getItemCount() {
        return offerHelpers.size();

    }
    public interface OfferListener {
    }


    public static class OfferViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        OfferListener offerListener;
        ImageView image;
        TextView name,piece,price;
        ImageView add,remove;
        TextView counter;


        public OfferViewHolder(@NonNull View itemView, OfferListener offerListener) {
            super(itemView);          //hooks

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            piece = itemView.findViewById(R.id.pieces);
            price = itemView.findViewById(R.id.price);
            remove = itemView.findViewById(R.id.remove);
            add = itemView.findViewById(R.id.add);
            counter = itemView.findViewById(R.id.counter);

            this.offerListener = offerListener;

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
