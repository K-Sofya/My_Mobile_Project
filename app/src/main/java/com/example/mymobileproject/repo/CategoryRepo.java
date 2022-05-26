package com.example.mymobileproject.repo;

import com.example.mymobileproject.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepo {

    List<Category> categoryList = new ArrayList<>();

    public CategoryRepo() {
        categoryList.add(new Category(1, "cameras", "КАМЕРЫ", new SectionRepo().getSectionsByCategory(1)));
        categoryList.add(new Category(2, "optic", "ОПТИКА", new SectionRepo().getSectionsByCategory(2)));
        categoryList.add(new Category(3, "accessories", "АКСЕССУАРЫ", new SectionRepo().getSectionsByCategory(3)));
        categoryList.add(new Category(4, "light", "СВЕТ", new SectionRepo().getSectionsByCategory(4)));
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }


}
