package com.aswanti.aplikasikatalogkucing;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class PetCareFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pet_care, container, false);

        // Inisialisasi tombol setelah layout diinflasi
        Button btnNext = view.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buat Intent untuk membuka ListCatsActivity
                Intent listpetscare = new Intent(getActivity(), ListPetsCare.class);
                startActivity(listpetscare);
            }
        });

        return view;
    }
}
