package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentJelajahiKucing extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_jelajahi_kucing);

        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
    }
}