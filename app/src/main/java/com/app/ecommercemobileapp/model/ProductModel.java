package com.app.ecommercemobileapp.model;

public class ProductModel {
    String productName;
    String regularPrice;
    String totalPrice;
    String discount;
    String imageUrl;
    String productDesc;

    public ProductModel() {
    }

    public ProductModel(String productName, String regularPrice, String totalPrice, String discount, String imageUrl, String productDesc) {
        this.productName = productName;
        this.regularPrice = regularPrice;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.imageUrl = imageUrl;
        this.productDesc = productDesc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
