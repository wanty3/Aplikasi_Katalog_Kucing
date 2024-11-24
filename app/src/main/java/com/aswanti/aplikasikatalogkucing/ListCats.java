package com.aswanti.aplikasikatalogkucing;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
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
    private View btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cats);

        recyclerView = findViewById(R.id.recyclerView);
        searchEdit = findViewById(R.id.searchEdit);
        btnBack = findViewById(R.id.btnBack);

        // Setup tombol back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
        catList.add(new Cat("Kucing Britania",
                "Kucing bulu pendek britania adalah salah satu ras kucing tertua yang nenek moyang.",
                R.drawable.kucing_bulu_pendek_britania));
        catList.add(new Cat("Kucing Maineecoon",
                "Maine coon adalah salah satu ras kucing tertua dan alami yang berasal dari Maine.",
                R.drawable.kucing_maine_coon));
        catList.add(new Cat("Kucing Munchkin",
                "Kucing munchkin adalah salah satu ras kucing berkaki pendek yang terbentuk karena mutasi genetik alami.",
                R.drawable.kucing_munchkin));
        catList.add(new Cat("Kucing Anggora",
                "Anggora turki adalah salah satu ras kucing domestik alami tertua.",
                R.drawable.kucin_anggora));
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

    public View getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(View btnBack) {
        this.btnBack = btnBack;
    }
}