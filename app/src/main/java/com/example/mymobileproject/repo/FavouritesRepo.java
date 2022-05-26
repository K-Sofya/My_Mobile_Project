package com.example.mymobileproject.repo;

import com.example.mymobileproject.database.enteties.Favourites;

import java.util.ArrayList;
import java.util.List;

public class FavouritesRepo {

    List<Favourites> favouritesList = new ArrayList<>();
    List<Favourites> fullFavouritesList = new ArrayList<>();

    public FavouritesRepo() {
        favouritesList.add(new Favourites(1,"canon_eos_r_body3", "CANON EOS R BODY"));
        favouritesList.add(new Favourites(2,"fujifilm_gfx_50s_body3", "FUJIFILM GFX 50S BODY"));

        fullFavouritesList.addAll(favouritesList);
    }

    public List<Favourites> getFavouritesList() {
        return favouritesList;
    }

    public List<Favourites> addFavourites(int id){

        List<Favourites> filterFavourites = new ArrayList<>();

        for (Favourites s: favouritesList) {
            if(s.getId() == id) {
                filterFavourites.add(s);
            }
        }
        return filterFavourites;
    }



}
