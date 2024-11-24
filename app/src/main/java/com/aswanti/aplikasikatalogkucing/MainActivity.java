package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectfragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home) {
                    selectfragment = new Fragment();
                } else if (itemId == R.id.nav_jelajahi_kucing) {
                    selectfragment = new JelajahiKucingFragment();
                } else if (itemId == R.id.nav_about) {
                    selectfragment = new AboutUsFragment();
                }

                if (selectfragment != null) {
                    switchFragment(selectfragment);
                    return true;
                }
                return false;
            }

            private void switchFragment(Fragment fragment) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
                        .commit();
            }
        });

        // Set default selection
        bottomNavigation.setSelectedItemId(R.id.nav_home);
    }
}