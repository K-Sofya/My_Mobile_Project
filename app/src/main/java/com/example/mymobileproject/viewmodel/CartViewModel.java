package com.example.mymobileproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymobileproject.database.AppDatabase;
import com.example.mymobileproject.model.Cart;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private AppDatabase appDatabase;

    public CartViewModel(@NonNull Application application) {
        super(application);
        appDatabase = AppDatabase.getInstance(getApplication());
    }

    public LiveData<List<Cart>> getCartList() {
        return appDatabase.cartDao().getAllCartItems();
    }

    public void deleteCartList(){
        new Thread(){
            @Override
            public void run() {
                appDatabase.cartDao().deleteCartList();
            }
        }.start();
    }

}
