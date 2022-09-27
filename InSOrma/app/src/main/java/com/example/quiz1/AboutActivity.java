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

import com.example.quiz1.data.UserData;

public class AboutActivity extends AppCompatActivity {

    Button btnMaps;
    Intent intent;
    UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnMaps = findViewById(R.id.buttonMaps);

        btnMaps.setOnClickListener(v -> {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);

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
                startActivity(new Intent(AboutActivity.this, HomeActivity.class));
                Log.wtf("test", "Masuk Home");
                break;
            case R.id.profile :
                intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("username", userData.getLoggedIn().getUsername());
                intent.putExtra("email", userData.getLoggedIn().getEmailAddress());
                intent.putExtra("phone", userData.getLoggedIn().getPhoneNum());
                startActivity(intent);
                Log.wtf("test", "Masuk Profile");
                break;
            case R.id.history :
                intent = new Intent(this, HistoryActivity.class);
                int userId = userData.getLoggedIn().getId();
                intent.putExtra("userId", userData.getLoggedIn().getId());
                userId = intent.getIntExtra("userId", 0);
                startActivity(intent);
                Log.wtf("test", "Masuk History");
                break;
            case R.id.about :
                Log.wtf("test", "Masuk About");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}