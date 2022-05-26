package com.example.mymobileproject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymobileproject.model.Section;

import java.util.List;

public class SectionViewModel extends ViewModel {

    private MutableLiveData<String> mSectionTitle = new MutableLiveData<>();
    private MutableLiveData<List<Section>> mSectionList = new MutableLiveData<>();

    public void initData(String title, List<Section> sections) {
        mSectionTitle.setValue(title);
        mSectionList.setValue(sections);
    }

    public LiveData<List<Section>> getSectionList() {
        return mSectionList;
    }

    public MutableLiveData<String> getSectionTitle() {
        return mSectionTitle;
    }
}
