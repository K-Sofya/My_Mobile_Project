package com.example.mymobileproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileproject.R;
import com.example.mymobileproject.database.AppDatabase;
import com.example.mymobileproject.database.CartDao;
import com.example.mymobileproject.model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final Context context;
    private List<Cart> items = new ArrayList<>();
    private final AppDatabase appDatabase;

    public CartAdapter(Context context) {
        this.context = context;
        appDatabase = AppDatabase.getInstance(context);
    }

    public void setItems(List<Cart> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewCart) {
        View cartItems = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(cartItems);
    }


    public void onBindViewHolder(@NonNull CartViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cart cartItem = items.get(position);
        int imageId = context.getResources().getIdentifier(items.get(position).getImg(), "drawable", context.getPackageName());
        holder.cartImage.setImageResource(imageId);
        holder.cartTitle.setText(items.get(position).getTitle());
        holder.sum.setText(String.format(context.getString(R.string.sum_template), cartItem.getPrice() * cartItem.getQuantity()));

        holder.quantitySpinner.setSelection(cartItem.getQuantity() - 1);

        holder.quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                cartItem.setQuantity(position + 1);
                updateCartItem(cartItem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteCartItem(cartItem);
            }
        });


    }

    public int getItemCount() {
        return items.size();
    }

    public static final class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView cartImage;
        TextView cartTitle;
        TextView quantity;
        Spinner quantitySpinner;
        TextView sum;
        ImageButton deleteButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartImage = itemView.findViewById(R.id.cartImage);
            cartTitle = itemView.findViewById(R.id.cartTitle);
            quantity = itemView.findViewById(R.id.quantity);
            quantitySpinner = itemView.findViewById(R.id.quantity_spinner);
            sum = itemView.findViewById(R.id.sum);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }

    private void updateCartItem(Cart cart){
        new Thread(){
            @Override
            public void run() {
                appDatabase.cartDao().updateCartItem(cart);
            }
        }.start();
    }

    private void deleteCartItem(Cart cart){
        new Thread(){
            @Override
            public void run() {
                appDatabase.cartDao().deleteCartItem(cart);
            }
        }.start();
    }
}
