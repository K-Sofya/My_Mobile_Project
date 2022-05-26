package com.example.mymobileproject.model;

import java.util.List;

public class Category {

    int id;
    String img, title;
    List<Section> sectionList;

    public Category(int id, String img, String title, List<Section> sectionList) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.sectionList = sectionList;
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

    public List<Section> getSectionList() { return sectionList; }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
