package com.aswanti.aplikasikatalogkucing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsername, etEmail, etPassword, etConfirmPassword;
    private Button btnRegister;

    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi UI
        etUsername = findViewById(R.id.et_username);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btnRegister = findViewById(R.id.btn_register);

        // Inisialisasi Realtime Database Reference
        database = FirebaseDatabase.getInstance().getReference();

        // Listener tombol Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ambil data dari input
                String username = etUsername.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmPassword = etConfirmPassword.getText().toString().trim();

                // Validasi input
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ada data yang masih kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password dan Konfirmasi Password tidak sama!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Simpan data ke Firebase
                saveUserToFirebase(username, email, password);
            }
        });
    }

    // Method untuk menyimpan data ke Firebase
    private void saveUserToFirebase(String username, String email, String password) {
        // Membuat objek data user
        User user = new User(username, email, password);

        // Menyimpan data user di dalam child "users"
        database.child("users").child(username).setValue(user)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Register berhasil!", Toast.LENGTH_SHORT).show();
                        // Pindah ke halaman login
                        Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(loginIntent);
                        finish(); // Menutup activity register
                    } else {
                        Toast.makeText(getApplicationContext(), "Gagal menyimpan data: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    // Kelas model untuk User
    public static class User {
        public String username, email, password;

        public User() {
            // Default constructor diperlukan untuk Firebase
        }

        public User(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }
    }
}
