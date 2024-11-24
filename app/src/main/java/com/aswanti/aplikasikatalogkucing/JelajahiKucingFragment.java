package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class JelajahiKucingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jelajahi_kucing, container, false);

        // Handle the explore button click
        Button btnExplore = view.findViewById(R.id.btnExplore);
        btnExplore.setOnClickListener(v -> {
            // Add your navigation or action code here
        });

        return view;
    }
}