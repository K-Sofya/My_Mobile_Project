package com.example.mymobileproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.mymobileproject.model.Enter;
import com.example.mymobileproject.viewmodel.EnterViewModel;
import com.google.android.material.snackbar.Snackbar;

public class EnterFragment extends Fragment {


    private EnterViewModel enterViewModel;
    private EditText etPhone, etPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        enterViewModel = new ViewModelProvider(this).get(EnterViewModel.class);

        View view = inflater.inflate(R.layout.fragment_enter, container, false);
        etPhone = view.findViewById(R.id.editphone);
        etPass = view.findViewById(R.id.editpass);

        return view;
    }

    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setClickListeners(view);
        observeViewModel();
    }

    private void observeViewModel() {
        enterViewModel.shouldCloseScreen().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean shouldClose) {
                if (shouldClose){
                    launchFragment(new CategoryFragment());
                }
            }
        });

        enterViewModel.getErrorMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String message) {
                Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void setClickListeners(View view) {
        ImageButton enter_button = (ImageButton) view.findViewById(R.id.enter_button);
        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = etPhone.getText().toString();
                String pass = etPass.getText().toString();
                enterViewModel.validateEnter(new Enter(phone, pass));
            }
        });
    }

    private void launchFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    }

}
