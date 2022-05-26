package com.example.mymobileproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mymobileproject.database.enteties.Favourites;
import com.example.mymobileproject.model.Cart;

@Database(entities = {Favourites.class, Cart.class},
        exportSchema = false,
        version = 3)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "main.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract FavouritesDao favouritesDao();
    public abstract CartDao cartDao();
}