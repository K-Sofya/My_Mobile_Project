package com.example.mymobileproject.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mymobileproject.database.enteties.Favourites;

import java.util.List;

@Dao
public interface FavouritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavourites(Favourites favourites);

    @Query("SELECT * FROM favourites")
    LiveData<List<Favourites>> getAllFavourites();

    @Delete
    void deleteFavourites(Favourites favourites);
}
