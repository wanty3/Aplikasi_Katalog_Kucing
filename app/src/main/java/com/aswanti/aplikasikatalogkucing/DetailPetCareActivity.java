package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailPetCareActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pet_care);

        TextView catName = findViewById(R.id.catName);
        TextView catDescription = findViewById(R.id.catDescription);
        ImageView catImage = findViewById(R.id.catImage);
        ImageButton backButton = findViewById(R.id.backButton);

        // Set back button click listener
        backButton.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        // Get data from Intent
        String name = getIntent().getStringExtra("cat_name");
        String description = getIntent().getStringExtra("cat_description");
        int imageResourceId = getIntent().getIntExtra("cat_image", -1);

        // Set data to views
        catName.setText(name);
        catDescription.setText(description);
        catImage.setImageResource(imageResourceId);
    }
}