package com.example.mymobileproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymobileproject.model.Product;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<String> mProductTitle = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mProductList = new MutableLiveData<>();

    public void initData(String title, List<Product> products) {
        mProductTitle.setValue(title);
        mProductList.setValue(products);
    }

    public LiveData<List<Product>> getProductList() {
        return mProductList;
    }

    public MutableLiveData<String> getProductTitle() {
        return mProductTitle;
    }

}
