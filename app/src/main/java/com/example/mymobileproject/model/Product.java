package com.example.mymobileproject.model;

public class Product {

    private int id, type;
    private String img, priceText;
    private int price;

    public Product(int id, String img, String priceText, int price, int type) {
        this.id = id;
        this.img = img;
        this.priceText = priceText;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPriceText() {
        return priceText;
    }

    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }

    public int getType() { return type; }

    public void setType(int type) { this.type = type; }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
