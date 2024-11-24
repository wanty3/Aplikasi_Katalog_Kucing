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
    private Fragment currentFragment;  // Menyimpan fragment yang sedang aktif

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNav);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectFragment = null;
                int itemId = item.getItemId();

                // Menambahkan pengecekan untuk memastikan tombol Home tidak mengganti fragment
                if (itemId == R.id.nav_home) {
                    // Jangan melakukan apa-apa saat tombol Home ditekan
                    return true;  // Tidak ada perpindahan fragment
                } else if (itemId == R.id.nav_food) {
                    selectFragment = new FragmentJelajahiKucing();
                } else if (itemId == R.id.nav_account) {
                    selectFragment = new AboutUsFragment();
                }

                if (selectFragment != null) {
                    switchFragment(selectFragment);
                    return true;
                }
                return false;
            }

            private void switchFragment(Fragment fragment) {
                if (currentFragment == null || !currentFragment.getClass().equals(fragment.getClass())) {
                    currentFragment = fragment;
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
                            .commit();
                }
            }
        });
    }
}
