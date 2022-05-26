package com.example.mymobileproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mymobileproject.database.AppDatabase;
import com.example.mymobileproject.database.enteties.Favourites;

import java.util.List;

public class FavouritesViewModel extends AndroidViewModel {

    private AppDatabase appDatabase = AppDatabase.getInstance(getApplication());

    public FavouritesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Favourites>> getFavourites() {
        return appDatabase.favouritesDao().getAllFavourites();
    }
}
