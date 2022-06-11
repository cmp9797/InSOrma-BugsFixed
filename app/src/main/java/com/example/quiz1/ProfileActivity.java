package com.example.quiz1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quiz1.data.UserData;

public class ProfileActivity extends AppCompatActivity {

    EditText edtNewUsername;
    TextView tvUsernameProfile, tvEmailProfile, tvPhoneProfile;
    Button btnEdit, btnDelete, btnLogout;
    UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Hi " + userData.getLoggedIn().getUsername() + "!");

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");

        tvUsernameProfile = findViewById(R.id.tvUsernameProfile);
        tvUsernameProfile.setText(username);
        tvEmailProfile = findViewById(R.id.tvEmailProfile);
        tvEmailProfile.setText(email);
        tvPhoneProfile = findViewById(R.id.tvPhoneProfile);
        tvPhoneProfile.setText(phone);
        edtNewUsername= findViewById(R.id.Profile);
        btnEdit = findViewById(R.id.btnEditProfile);
        btnDelete = findViewById(R.id.btnDeleteProfile);
        btnLogout = findViewById(R.id.btnLogoutProfile);

        btnDelete.setOnClickListener( v -> {

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home :
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                Log.wtf("test", "Masuk Home");
                break;
            case R.id.profile :
                Log.wtf("test", "Masuk Profile");
                break;
            case R.id.history :
                startActivity(new Intent(ProfileActivity.this, HistoryActivity.class));
                Log.wtf("test", "Masuk History");
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    private Object getActivity() {
        return 3;
    }
}