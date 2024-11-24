package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class AboutUsFragment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about_us);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}