package com.example.mymobileproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mymobileproject.adapter.FavouritesAdapter;
import com.example.mymobileproject.database.enteties.Favourites;
import com.example.mymobileproject.viewmodel.FavouritesViewModel;

import java.util.List;

public class FavouritesFragment extends Fragment {

    private RecyclerView favouritesRecycler;
    private FavouritesAdapter favouritesAdapter;
    private FavouritesViewModel mViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);
        mViewModel = new ViewModelProvider(this).get(FavouritesViewModel.class);


        favouritesRecycler = view.findViewById(R.id.favouritesRecycler);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        favouritesRecycler.setLayoutManager(manager);
        favouritesAdapter = new FavouritesAdapter(requireContext());
        favouritesRecycler.setAdapter(favouritesAdapter);

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setClickListeners(view);
        observeViewModel();
    }

    private void observeViewModel() {
        mViewModel.getFavourites().observe(getViewLifecycleOwner(), new Observer<List<Favourites>>() {
            @Override
            public void onChanged(List<Favourites> favourites) {
                favouritesAdapter.setFavouritesList(favourites);
            }
        });
    }

    private void setClickListeners(View view){
        ImageButton back_button = (ImageButton) view.findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        view.findViewById(R.id.iconcart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFragment(new CartFragment());
            }
        });

        view.findViewById(R.id.iconprofile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFragment(new ProfileFragment());
            }
        });
    }

    private void launchFragment(Fragment fragment){
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}