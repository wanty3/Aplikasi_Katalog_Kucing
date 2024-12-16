package com.aswanti.aplikasikatalogkucing;

import android.content.Intent;
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

public class ListPetsCare extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText searchEdit;
    private CatAdapter adapter;
    private List<Cat> catList;
    private View btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pet_care);

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
        catList.add(new Cat("Memandikan Kucing",
                "Proses mandi yang tepat akan membersihkan kotoran, kuman, dan minyak berlebih yang ada di bulu dan kulit kucing. Mandi juga dapat membantu menjaga kebersihan kulit[...]",
                R.drawable.mandikan_kucing));
        catList.add(new Cat("Potong kuku",
                "Menjaga kuku kucing tetap pendek tidak hanya penting untuk mencegah kerusakan furnitur atau permukaan lainnya....",
                R.drawable.potong_kuku));
        catList.add(new Cat("Pembersihan Telinga ",
                " Pembersihan telinga secara teratur sangat penting untuk mencegah infeksi telinga pada kucing, terutama bagi ras yang rentan.....",
                R.drawable.pembersihan_telinga));
        catList.add(new Cat("Potong dan Rapikan Bulu",
                "  Kucing dapat mengalami masalah mata seperti kotoran atau air mata yang mengering di....",
                R.drawable.potong_dan_rapikan));
        catList.add(new Cat("Pembersih gigi",
                " Kesehatan gigi sangat penting untuk kucing, karena masalah gigi dan gusi dapat menyebabkan nyeri atau bahkan penyakit sistemik..",
                R.drawable.pembersihan_gigi));
        catList.add(new Cat("Pemeriksaan Kutu dan Parasit",
                "   Kutu dan parasit lainnya, seperti caplak atau cacing, dapat menyebabkan ketidaknyamanan bagi kucing dan dapat membawa penyakit.....",
                R.drawable.pemeriksaan_kutu));
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CatAdapter(catList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(cat -> {
            Intent intent = new Intent(ListPetsCare.this, DetailPetCareActivity.class);
            intent.putExtra("cat_name", cat.getName());
            intent.putExtra("cat_description", cat.getDescription());
            intent.putExtra("cat_image", cat.getImageResourceId());
            startActivity(intent);
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