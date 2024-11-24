package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailCatActivity extends Fragment {
    private static final String ARG_CAT_NAME = "cat_name";
    private static final String ARG_CAT_DESC = "cat_desc";
    private static final String ARG_CAT_IMAGE = "cat_image";

    public static DetailCatActivity newInstance(Cat cat) {
        DetailCatActivity fragment = new DetailCatActivity();
        Bundle args = new Bundle();
        args.putString(ARG_CAT_NAME, cat.getName());
        args.putString(ARG_CAT_DESC, cat.getDescription());
        args.putInt(ARG_CAT_IMAGE, cat.getImageResourceId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_item_cats, container, false);

        // Initialize views
        TextView catName = view.findViewById(R.id.catName);
        TextView catDescription = view.findViewById(R.id.catDescription);
        ImageView catImage = view.findViewById(R.id.catImage);
        ImageButton backButton = view.findViewById(R.id.backButton);

        // Get arguments
        if (getArguments() != null) {
            catName.setText(getArguments().getString(ARG_CAT_NAME));
            catDescription.setText(getArguments().getString(ARG_CAT_DESC));
            catImage.setImageResource(getArguments().getInt(ARG_CAT_IMAGE));
        }

        // Set back button click listener
        backButton.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}