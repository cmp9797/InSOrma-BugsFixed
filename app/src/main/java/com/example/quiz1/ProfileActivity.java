package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    EditText edtNewUsername;
    Button btnEdit, btnDelete, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        edtNewUsername= findViewById(R.id.Profile);
        btnEdit = findViewById(R.id.btnEditProfile);
        btnDelete = findViewById(R.id.btnDeleteProfile);
        btnLogout = findViewById(R.id.btnLogoutProfile);

        btnDelete.setOnClickListener( v -> {

        });

    }
}