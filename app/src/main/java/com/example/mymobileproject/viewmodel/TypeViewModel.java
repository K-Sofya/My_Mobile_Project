package com.example.mymobileproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymobileproject.model.Type;

import java.util.List;

public class TypeViewModel extends ViewModel {

    private MutableLiveData<String> mTypeTitle = new MutableLiveData<>();
    private MutableLiveData<List<Type>> mTypeList = new MutableLiveData<>();

    public void initData(String title, List<Type> types) {
        mTypeTitle.setValue(title);
        mTypeList.setValue(types);
    }

    public LiveData<List<Type>> getTypeList() {
        return mTypeList;
    }

    public MutableLiveData<String> getTypeTitle() {
        return mTypeTitle;
    }
}
