package com.example.mymobileproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileproject.R;
import com.example.mymobileproject.database.AppDatabase;
import com.example.mymobileproject.database.enteties.Favourites;
import com.example.mymobileproject.model.Cart;
import com.example.mymobileproject.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final Context context;
    private final List<Product> products;
    private final String title;

    private final AppDatabase appDatabase;

    public ProductAdapter(Context context, List<Product> products, String title) {
        this.context = context;
        this.products = products;
        this.title = title;
        appDatabase = AppDatabase.getInstance(context);
    }

    @NonNull

    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductViewHolder(productItems);
    }


    public void onBindViewHolder(@NonNull ProductViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Product product = products.get(position);

        int imageId = context.getResources().getIdentifier(products.get(position).getImg(), "drawable", context.getPackageName());
        holder.productImage.setImageResource(imageId);
        holder.productPrice.setText(products.get(position).getPriceText());

        holder.addFavsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProductToFavourites(product);
                showToast("Товар добавлен в избранное", Toast.LENGTH_SHORT);
            }
        });

        holder.addCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProductToCart(product);
                showToast("Товар добавлен в корзину", Toast.LENGTH_SHORT);
            }
        });

    }

    public int getItemCount() {
        return products.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productPrice;
        ImageButton addFavsButton, addCartButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productPrice = itemView.findViewById(R.id.productPrice);
            addFavsButton = itemView.findViewById(R.id.addfavs_button);
            addCartButton = itemView.findViewById(R.id.addcart_button);
        }
    }

    private void saveProductToFavourites(Product product) {
        new Thread() {
            @Override
            public void run() {
                Favourites favourites = new Favourites(
                        product.getId(),
                        product.getImg(),
                        title
                );

                appDatabase.favouritesDao().insertFavourites(favourites);
            }
        }.start();
    }

    private void saveProductToCart(Product product) {
        new Thread(){
            @Override
            public void run() {
                Cart cart = new Cart(
                        product.getId(),
                        1,
                        product.getPrice(),
                        title,
                        product.getImg()

                );
                appDatabase.cartDao().insertCartItem(cart);
            }
        }.start();
    }

    private void showToast(String text, int length){
        Toast.makeText(context, text, length).show();
    }
}
