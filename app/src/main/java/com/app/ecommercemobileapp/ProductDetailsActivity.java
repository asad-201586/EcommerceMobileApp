package com.app.ecommercemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.app.ecommercemobileapp.databinding.ActivityProductDetailsBinding;
import com.app.ecommercemobileapp.model.ProductModel;
import com.google.gson.Gson;

public class ProductDetailsActivity extends AppCompatActivity {

    private ActivityProductDetailsBinding binding;
    private ProductModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setInitValues();
        getValue();
        setValue();
        clickEvent();

    }

    private void clickEvent() {
        binding.textPlus.setOnClickListener(view -> {
            String currentValue = binding.textCart.getText().toString();
            binding.textCart.setText(String.valueOf(Integer.parseInt(currentValue)+1));
        });
        binding.textMinus.setOnClickListener(view -> {
            String currentValue = binding.textCart.getText().toString();
            if (Integer.parseInt(currentValue) != 0) {
                binding.textCart.setText(String.valueOf(Integer.parseInt(currentValue)-1));
            }
        });
    }

    private void setValue() {
        binding.productName.setText(item.getProductName());
        binding.regularPrice.setText(getString(R.string.taka_sign)+item.getRegularPrice());
        binding.totalPrice.setText(getString(R.string.taka_sign)+item.getTotalPrice());
        binding.regularPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void getValue() {
        String itemStr = getIntent().getStringExtra("item");
        item = new Gson().fromJson(itemStr,ProductModel.class);
    }

    private void setInitValues() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Product Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
}