package com.example.mymobileproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymobileproject.model.Category;
import com.example.mymobileproject.repo.CategoryRepo;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    private MutableLiveData<List<Category>> mCategoryList = new MutableLiveData<>();

    public LiveData<List<Category>> getCategoryList() {
        mCategoryList.setValue(new CategoryRepo().getCategoryList());
        return mCategoryList;
    }
}
