package com.example.mymobileproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mymobileproject.adapter.SectionAdapter;
import com.example.mymobileproject.model.Section;
import com.example.mymobileproject.viewmodel.SectionViewModel;

import java.util.List;

public class SectionFragment extends Fragment {

    String title;
    List<Section> sectionList;

    public SectionFragment(String title, List<Section> sectionList) {
        this.title = title;
        this.sectionList = sectionList;
    }

    RecyclerView sectionRecycler;
    SectionAdapter sectionAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_section, container, false);
        SectionViewModel mViewModel = new ViewModelProvider(this).get(SectionViewModel.class);
        mViewModel.initData(title, sectionList);

        final Observer<List<Section>> nameObserver = new Observer<List<Section>>() {
            @Override
            public void onChanged(List<Section> sections) {
                sectionAdapter = new SectionAdapter(requireContext(), sections);
                sectionRecycler.setAdapter(sectionAdapter);
            }
        };

        TextView titleText = view.findViewById(R.id.sectionName);
        mViewModel.getSectionTitle().observe(getViewLifecycleOwner(), titleText::setText);

        sectionRecycler=view.findViewById(R.id.sectionRecycler);
        mViewModel.getSectionList().observe(getViewLifecycleOwner(), nameObserver);
        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        sectionRecycler.setLayoutManager(manager);

        return view;
    }


    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
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
                        .replace(R.id.frame, new ProfileFragment()).commit();
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
