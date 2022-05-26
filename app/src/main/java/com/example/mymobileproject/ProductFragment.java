package com.example.mymobileproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.mymobileproject.adapter.ProductAdapter;
import com.example.mymobileproject.model.Product;
import com.example.mymobileproject.viewmodel.ProductViewModel;

import java.util.List;

public class ProductFragment extends Fragment {

    String title;
    List<Product> productList;

    public ProductFragment(String title, List<Product> productList) {
        this.title = title;
        this.productList = productList;
    }

    RecyclerView productRecycler;
    ProductAdapter productAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ProductViewModel mViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        mViewModel.initData(title, productList);

        final Observer<List<Product>> nameObserver = new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productAdapter = new ProductAdapter(requireContext(), products, title);
                productRecycler.setAdapter(productAdapter);
            }
        };

        TextView titleText = view.findViewById(R.id.productName);
        mViewModel.getProductTitle().observe(getViewLifecycleOwner(), titleText::setText);

        productRecycler = view.findViewById(R.id.productRecycler);
        mViewModel.getProductList().observe(getViewLifecycleOwner(), nameObserver);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        productRecycler.setLayoutManager(manager);

        return view;

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton profile_button = (ImageButton) view.findViewById(R.id.iconprofile);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new ProfileFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        ImageButton backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        ImageButton cartButton = view.findViewById(R.id.iconcart);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new CartFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });


    }


}