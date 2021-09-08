package com.arnoldvaz27.grocerystoreui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arnoldvaz27.grocerystoreui.databinding.ProductDetailsBinding;

public class ProductDetails extends AppCompatActivity {

    ProductDetailsBinding binding;
    ImageView groceryImage;
    Button addBasket;
    TextView groceryName,groceryPiece;
    ImageView favouriteFilled,favouriteBlank,back;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        binding = DataBindingUtil.setContentView(this, R.layout.product_details);

        groceryImage = binding.groceryImage;
        addBasket = binding.addToBasket;
        groceryName = binding.groceryName;
        groceryPiece = binding.groceryPiece;
        favouriteBlank = binding.blank;
        favouriteFilled = binding.filled;
        back = binding.back;
        String type = getIntent().getStringExtra("Grocery");
        if(type.equals("Pulses")){
            groceryImage.setImageResource(R.drawable.pulses);
            int[] imageArray = {R.drawable.pulses, R.drawable.pulses_1,
                    R.drawable.pulses_2};
            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                int i = 0;

                public void run() {
                    groceryImage.setImageResource(imageArray[i]);
                    i++;
                    if (i > imageArray.length - 1) {
                        i = 0;
                    }
                    handler.postDelayed(this, 4000);
                }
            };
            handler.postDelayed(runnable, 2000);
            groceryName.setText(type);
            groceryPiece.setText("1 kg,Price");
        }
        else if(type.equals("Rice")){
            groceryImage.setImageResource(R.drawable.rice);
            int[] imageArray = {R.drawable.rice, R.drawable.rice_1,
                    R.drawable.rice_2};
            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                int i = 0;

                public void run() {
                    groceryImage.setImageResource(imageArray[i]);
                    i++;
                    if (i > imageArray.length - 1) {
                        i = 0;
                    }
                    handler.postDelayed(this, 4000);
                }
            };
            handler.postDelayed(runnable, 2000);
            groceryName.setText(type);
            groceryPiece.setText("2 kg,Price");

        }

        addBasket.setOnClickListener(v -> Toast.makeText(getApplicationContext(), type + " Added to Basket", Toast.LENGTH_SHORT).show());

        favouriteBlank.setOnClickListener(v -> {
            favouriteBlank.setVisibility(View.GONE);
            favouriteFilled.setVisibility(View.VISIBLE);
        });
        favouriteFilled.setOnClickListener(v -> {
            favouriteFilled.setVisibility(View.GONE);
            favouriteBlank.setVisibility(View.VISIBLE);
        });
        back.setOnClickListener(v -> finish());
    }
}