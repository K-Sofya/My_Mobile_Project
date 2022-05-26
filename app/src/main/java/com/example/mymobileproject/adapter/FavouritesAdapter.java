package com.example.mymobileproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileproject.R;
import com.example.mymobileproject.database.AppDatabase;
import com.example.mymobileproject.database.enteties.Favourites;

import java.util.ArrayList;
import java.util.List;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.FavouritesViewHolder> {

    private final Context context;
    private List<Favourites> favouritesList = new ArrayList<>();
    private final AppDatabase appDatabase;

    public FavouritesAdapter(Context context) {
        this.context = context;
        appDatabase = AppDatabase.getInstance(context);
    }

    public void setFavouritesList(List<Favourites> favouritesList) {
        this.favouritesList = favouritesList;
        notifyDataSetChanged();
    }


    @NonNull
    public FavouritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View typeItems = LayoutInflater.from(context).inflate(R.layout.favourites_item, parent, false);
        return new FavouritesViewHolder(typeItems);
    }

    public void onBindViewHolder(@NonNull FavouritesViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Favourites favourites = favouritesList.get(position);
        int imageId = context.getResources().getIdentifier(favouritesList.get(position).getImg(), "drawable", context.getPackageName());
        holder.favouritesImage.setImageResource(imageId);
        holder.favouritesTitle.setText(favouritesList.get(position).getTitle());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteFavourites(favourites);
            }
        });
    }

    public int getItemCount() {
        return favouritesList.size();
    }

    public static final class FavouritesViewHolder extends RecyclerView.ViewHolder {

        ImageView favouritesImage;
        TextView favouritesTitle;
        ImageButton deleteButton;

        public FavouritesViewHolder(@NonNull View itemView) {
            super(itemView);
            favouritesImage = itemView.findViewById(R.id.favouritesImage);
            favouritesTitle = itemView.findViewById(R.id.favouritesTitle);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }

    private void deleteFavourites(Favourites favourites) {
        new Thread() {
            @Override
            public void run() {
                appDatabase.favouritesDao().deleteFavourites(favourites);
            }
        }.start();

    }
}