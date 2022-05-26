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

import com.example.mymobileproject.adapter.TypeAdapter;
import com.example.mymobileproject.model.Type;
import com.example.mymobileproject.viewmodel.TypeViewModel;

import java.util.List;

public class TypeFragment extends Fragment {

    String title;
    List<Type> typeList;

    public TypeFragment(String title, List<Type> typeList) {
        this.title = title;
        this.typeList = typeList;
    }

    RecyclerView typeRecycler;
    TypeAdapter typeAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_type, container, false);
        TypeViewModel mViewModel = new ViewModelProvider(this).get(TypeViewModel.class);
        mViewModel.initData(title, typeList);

        final Observer<List<Type>> nameObserver = new Observer<List<Type>>() {
            @Override
            public void onChanged(List<Type> types) {
                typeAdapter = new TypeAdapter(requireContext(), types);
                typeRecycler.setAdapter(typeAdapter);
            }
        };

        TextView titleText = view.findViewById(R.id.typeName);
        mViewModel.getTypeTitle().observe(getViewLifecycleOwner(), titleText::setText);

        typeRecycler = view.findViewById(R.id.typeRecycler);
        mViewModel.getTypeList().observe(getViewLifecycleOwner(), nameObserver);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        typeRecycler.setLayoutManager(manager);

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton back_button = (ImageButton) view.findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        ImageButton profile_button = (ImageButton) view.findViewById(R.id.iconprofile);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.frame, new ProfileFragment())
                        .commit();
            }
        });

        ImageButton cart_button = (ImageButton) view.findViewById(R.id.iconcart);
        cart_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new CartFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
