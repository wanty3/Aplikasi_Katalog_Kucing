package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class FragmentJelajahiKucing extends Fragment {

    public FragmentJelajahiKucing() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jelajahi_kucing, container, false);

        view.findViewById(R.id.btnBack).setOnClickListener(v -> getActivity().finish());

        return view;
    }
}