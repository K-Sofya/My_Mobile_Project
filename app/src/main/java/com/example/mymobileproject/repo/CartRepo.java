package com.example.mymobileproject.repo;

import com.example.mymobileproject.model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartRepo {

    List<Cart> cartList = new ArrayList<>();

    public CartRepo() {

    }

    public List<Cart> getCartList() {
        return cartList;
    }

}
