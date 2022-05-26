package com.example.mymobileproject.model;

import java.util.List;

public class Section {

    int id, category;
    String title;
    List<Type> typeList;

    public Section(int id, String title, List<Type> typeList, int category) {
        this.id = id;
        this.title = title;
        this.typeList = typeList;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public int getCategory() {return category;}

    public void setCategory(int category) {this.category = category;}
}
