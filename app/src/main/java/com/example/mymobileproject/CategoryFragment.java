package com.example.mymobileproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mymobileproject.adapter.CategoryAdapter;
import com.example.mymobileproject.model.Category;
import com.example.mymobileproject.viewmodel.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    RecyclerView categoryRecycler;
    CategoryAdapter categoryAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        CategoryViewModel mViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        final Observer<List<Category>> nameObserver = new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoryAdapter = new CategoryAdapter(requireContext(), categories);
                categoryRecycler.setAdapter(categoryAdapter);
            }
        };

        categoryRecycler = view.findViewById(R.id.categoryRecycler);
        mViewModel.getCategoryList().observe(getViewLifecycleOwner(), nameObserver);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        categoryRecycler.setLayoutManager(manager);

        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        setClickListeners(view);

    }

    private void setClickListeners(View view) {
        view.findViewById(R.id.iconcart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFragment(new CartFragment());
            }
        });

        view.findViewById(R.id.favourites_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchFragment(new FavouritesFragment());
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