package com.example.mymobileproject.model;

import java.util.List;

public class Type {

    int id, section;
    String img, title;
    List<Product> productList;

    public Type(int id, String img, String title, List<Product> productList, int section) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.productList = productList;
        this.section = section;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }
}
