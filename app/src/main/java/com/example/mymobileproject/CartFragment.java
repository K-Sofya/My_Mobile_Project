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

import com.example.mymobileproject.adapter.CartAdapter;
import com.example.mymobileproject.model.Cart;
import com.example.mymobileproject.viewmodel.CartViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class CartFragment extends Fragment {

    private RecyclerView cartRecycler;
    private CartAdapter cartAdapter;
    private CartViewModel viewModel;
    private TextView finalSum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        finalSum = view.findViewById(R.id.block3);

        viewModel = new ViewModelProvider(this).get(CartViewModel.class);

        cartRecycler = view.findViewById(R.id.cartRecycler);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        cartRecycler.setLayoutManager(manager);
        cartAdapter = new CartAdapter(requireContext());
        cartRecycler.setAdapter(cartAdapter);

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setClickListeners(view);
        observeViewModel();
    }

    private void observeViewModel() {
        viewModel.getCartList().observe(getViewLifecycleOwner(), new Observer<List<Cart>>() {
            @Override
            public void onChanged(List<Cart> carts) {
                cartAdapter.setItems(carts);

                int countedSum = 0;
                for (Cart cart : carts) {
                    countedSum += cart.getPrice() * cart.getQuantity();
                }

                String countedSumText = String.format(
                        requireContext().getString(R.string.ruble_template),
                        countedSum
                );

                finalSum.setText(countedSumText);
            }
        });
    }

    private void setClickListeners(View view) {
        ImageButton back_button = (ImageButton) view.findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        view.findViewById(R.id.payment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Вы оплатили", Snackbar.LENGTH_LONG).show();
                viewModel.deleteCartList();
            }
        });
    }

}