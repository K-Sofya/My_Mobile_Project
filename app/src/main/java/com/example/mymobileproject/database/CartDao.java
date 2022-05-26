package com.example.mymobileproject.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mymobileproject.database.enteties.Favourites;
import com.example.mymobileproject.model.Cart;

import java.util.List;

@Dao
public interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCartItem(Cart cart);

    @Query("SELECT * FROM cart")
    LiveData<List<Cart>> getAllCartItems();

    @Delete
    void deleteCartItem(Cart cart);

    @Update
    void updateCartItem(Cart cart);

    @Query("DELETE FROM cart")
    void deleteCartList();
}
