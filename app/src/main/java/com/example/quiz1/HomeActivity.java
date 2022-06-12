package com.example.quiz1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.example.quiz1.adapter.FurnitureAdapter;
import com.example.quiz1.data.FurnitureData;
import com.example.quiz1.data.TransactionData;
import com.example.quiz1.data.UserData;

public class HomeActivity extends AppCompatActivity {

    FurnitureData furnitureData;
    UserData userData;
    TransactionData transactionData;
    RecyclerView rvFurniture;
    FurnitureAdapter furnitureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Hi " + userData.getLoggedIn().getUsername() + "!");

        furnitureData = new FurnitureData();

        rvFurniture = findViewById(R.id.rvFurniture);
        furnitureAdapter = new FurnitureAdapter(FurnitureData.getVectFurniture());

        rvFurniture.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvFurniture.setAdapter(furnitureAdapter);


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
                Log.wtf("test", "Masuk Home");
                break;
            case R.id.profile :
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("username", userData.getLoggedIn().getUsername());
                intent.putExtra("email", userData.getLoggedIn().getEmailAddress());
                intent.putExtra("phone", userData.getLoggedIn().getPhoneNum());
                startActivity(intent);
                Log.wtf("test", "Masuk Profile");
                break;
            case R.id.history :
                Intent intent2 = new Intent(this, HistoryActivity.class);
                int userId = userData.getLoggedIn().getId();
                intent2.putExtra("userId", userData.getLoggedIn().getId());
                startActivity(intent2);
                Log.wtf("test", "Masuk History");
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    private Object getActivity() {
        return 3;
    }
}