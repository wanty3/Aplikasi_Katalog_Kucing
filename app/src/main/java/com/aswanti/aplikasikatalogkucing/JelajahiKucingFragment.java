package com.aswanti.aplikasikatalogkucing;

import android.content.Intent;
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jelajahi_kucing, container, false);

        Button btnJelajahi = view.findViewById(R.id.btnExplore);
        btnJelajahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buat Intent untuk membuka ListCatsActivity
                Intent intent = new Intent(getActivity(), ListCats.class);
                startActivity(intent);
            }
        });

        return view;
    }
}