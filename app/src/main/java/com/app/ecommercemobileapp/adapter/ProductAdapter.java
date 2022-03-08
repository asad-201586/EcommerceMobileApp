package com.app.ecommercemobileapp.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.ecommercemobileapp.R;
import com.app.ecommercemobileapp.model.ProductModel;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private final ArrayList<ProductModel> list;
    private final Context context;
    private OnItemClickListener listener;

    public ProductAdapter(ArrayList<ProductModel> list, Context context, OnItemClickListener listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductModel model = list.get(position);

        holder.nameTV.setText(model.getProductName());

        String regularPrice = context.getString(R.string.taka_sign) + model.getRegularPrice();
        String totalPrice = context.getString(R.string.taka_sign) + model.getTotalPrice();

        holder.regularPriceTV.setText(regularPrice);
        holder.totalPriceTV.setText(totalPrice);
        holder.discountTV.setText("-%"+model.getDiscount());

        holder.regularPriceTV.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        holder.itemView.setOnClickListener(view -> {
            listener.itemClicked(model);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTV,regularPriceTV,totalPriceTV,discountTV;
        public AppCompatImageView productImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.text_product_name);
            regularPriceTV = itemView.findViewById(R.id.regular_price);
            totalPriceTV = itemView.findViewById(R.id.total_price);
            discountTV = itemView.findViewById(R.id.text_discount);
            productImage = itemView.findViewById(R.id.image_product);
        }
    }

    public interface OnItemClickListener {
        void itemClicked(ProductModel item);
    }
}
