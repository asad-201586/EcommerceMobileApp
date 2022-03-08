package com.app.ecommercemobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.app.ecommercemobileapp.adapter.ProductAdapter;
import com.app.ecommercemobileapp.databinding.ActivityMainBinding;
import com.app.ecommercemobileapp.model.ProductModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ProductAdapter.OnItemClickListener {

    private ActivityMainBinding binding;
    private ProductAdapter adapter;
    private ArrayList<ProductModel> dataList;
    private DatabaseReference rootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initValue();



    }

    private void initValue() {
        rootRef = FirebaseDatabase.getInstance().getReference();

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("E-Commerce");

        setDataList();

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        binding.recyclerview.setLayoutManager(layoutManager);
        binding.recyclerview.setHasFixedSize(true);

        adapter = new ProductAdapter(dataList,this,this);
        binding.recyclerview.setAdapter(adapter);

        binding.progressbar.setVisibility(View.GONE);
    }

    private void setDataList() {
        dataList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ProductModel model = new ProductModel("Nike shoe","700","750","5","","");
            dataList.add(model);
        }
    }

    @Override
    public void itemClicked(ProductModel item) {
        Intent intent = new Intent(this,ProductDetailsActivity.class);
        intent.putExtra("item",new Gson().toJson(item));
        startActivity(intent);

    }
}