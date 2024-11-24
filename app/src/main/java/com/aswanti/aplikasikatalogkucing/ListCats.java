package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ListCats extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText searchEdit;
    private CatAdapter adapter;
    private List<Cat> catList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cats);

        recyclerView = findViewById(R.id.recyclerView); // Ganti ListView dengan RecyclerView di layout
        searchEdit = findViewById(R.id.searchEdit);

        initializeCatList();
        setupRecyclerView();
        setupSearch();
    }

    private void initializeCatList() {
        catList = new ArrayList<>();
        catList.add(new Cat("Kucing Burmilla",
                "Burmilla adalah salah satu ras kucing yang terbentuk dari persilangan antara kucing burma dengan chinchilla. Sebenarnya ada 2 jenis burmilla, yaitu kucing bulu panjang burmilla dan kucing bulu pendek Burmilla.",
                R.drawable.kucing_burmila));
        catList.add(new Cat("Kucing Birman",
                "Kucing birma adalah salah satu ras kucing alami yang berasal dari Prancis.",
                R.drawable.kucing_birman));
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CatAdapter(catList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(cat -> {
            // Handle item click
            // Misalnya buka DetailActivity
        });
    }

    private void setupSearch() {
        searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}