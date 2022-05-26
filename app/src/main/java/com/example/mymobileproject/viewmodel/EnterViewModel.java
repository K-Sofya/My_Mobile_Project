package com.example.mymobileproject.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymobileproject.EnterFragment;
import com.example.mymobileproject.model.Enter;
import com.example.mymobileproject.repo.EnterRepo;


public class EnterViewModel extends ViewModel {

    private final MutableLiveData<Boolean> _shouldCloseScreen = new MutableLiveData<>();
    private final MutableLiveData<String> errorMessage = new MutableLiveData<>();

    private final EnterRepo repo = new EnterRepo();

    public void validateEnter(Enter enter) {
        for (Enter savedEnter: repo.getEnterList()){
            if (savedEnter.equals(enter)){
                _shouldCloseScreen.setValue(true);
                return;
            }
        }
        errorMessage.setValue("Неверные данные для входа");
    }

    public LiveData<Boolean> shouldCloseScreen(){
        return _shouldCloseScreen;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }
}

