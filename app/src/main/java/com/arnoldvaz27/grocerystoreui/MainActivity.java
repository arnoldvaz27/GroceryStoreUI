package com.arnoldvaz27.grocerystoreui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.arnoldvaz27.grocerystoreui.Grocery.GroceryAdapter;
import com.arnoldvaz27.grocerystoreui.Grocery.GroceryHelper;
import com.arnoldvaz27.grocerystoreui.Grocery.GroceryListeners;
import com.arnoldvaz27.grocerystoreui.Offer.OfferAdapter;
import com.arnoldvaz27.grocerystoreui.Offer.OfferHelper;
import com.arnoldvaz27.grocerystoreui.Selling.SellingAdapter;
import com.arnoldvaz27.grocerystoreui.Selling.SellingHelper;
import com.arnoldvaz27.grocerystoreui.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GroceryListeners, SellingAdapter.SellingListener, OfferAdapter.OfferListener {

    ActivityMainBinding binding;
    RecyclerView phoneRecycler, phoneRecycler2, phoneRecycler3;
    RecyclerView.Adapter adapter, adapter2, adapter3;
    ImageView imageView;
    GroceryHelper groceryHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        imageView = binding.image1;
        int[] imageArray = {R.drawable.fresh_vegetables, R.drawable.exclusive_offer,
                R.drawable.best_selling};

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                imageView.setImageResource(imageArray[i]);
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 4000);
            }
        };
        handler.postDelayed(runnable, 2000);
        phoneRecycler = binding.exclusiveOffer;
        phoneRecycler2 = binding.bestSelling;
        phoneRecycler3 = binding.groceries;
        phoneRecycler();
    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    private void phoneRecycler() {


        phoneRecycler.setHasFixedSize(true);
        phoneRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        phoneRecycler2.setHasFixedSize(true);
        phoneRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        phoneRecycler3.setHasFixedSize(true);
        phoneRecycler3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<OfferHelper> offerHelperArrayList = new ArrayList<>();
        offerHelperArrayList.add(new OfferHelper(R.drawable.banana, "Organic Banana", "$4.99", "7 pcs,Price"));
        offerHelperArrayList.add(new OfferHelper(R.drawable.apple, "Red Apple", "$4.99", "1 kg,Price"));
        offerHelperArrayList.add(new OfferHelper(R.drawable.orange, "Seville Oranges", "$9.99", "1.5 kg,Price"));

        ArrayList<SellingHelper> sellingHelperArrayList = new ArrayList<>();
        sellingHelperArrayList.add(new SellingHelper(R.drawable.capsicum, "Bell Pepper Red", "$4.99"));
        sellingHelperArrayList.add(new SellingHelper(R.drawable.ginger, "Ginger", "$4.99"));
        sellingHelperArrayList.add(new SellingHelper(R.drawable.carrot, "Carotene Carrots", "$5.99"));

        ArrayList<GroceryHelper> groceryHelperArrayList = new ArrayList<>();
        groceryHelperArrayList.add(new GroceryHelper(R.drawable.pulses, getResources().getColorStateList(R.color.pulses_background), "Pulses"));
        groceryHelperArrayList.add(new GroceryHelper(R.drawable.rice, getResources().getColorStateList(R.color.rice_background), "Rice"));


        adapter = new OfferAdapter(offerHelperArrayList,this);
        adapter3 = new SellingAdapter(sellingHelperArrayList,this);
        adapter2 = new GroceryAdapter(groceryHelperArrayList, this);
        phoneRecycler.setAdapter(adapter);
        phoneRecycler2.setAdapter(adapter3);
        phoneRecycler3.setAdapter(adapter2);

    }

    @Override
    public void onMedicinesClicked(GroceryHelper note, int position) {
        groceryHelper = note;
        Intent mIntent;
        switch (position) {
            case 0:
                mIntent  = new Intent(MainActivity.this, ProductDetails.class);
                mIntent.putExtra("Grocery","Pulses");
                startActivity(mIntent);
                break;
            case 1:
                mIntent  = new Intent(MainActivity.this, ProductDetails.class);
                mIntent.putExtra("Grocery","Rice");
                startActivity(mIntent);
                break;
        }
    }

}