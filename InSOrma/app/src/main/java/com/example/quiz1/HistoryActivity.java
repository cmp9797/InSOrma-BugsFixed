package com.example.quiz1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.quiz1.adapter.TransactionAdapter;
import com.example.quiz1.data.TransactionData;
import com.example.quiz1.data.UserData;
import com.example.quiz1.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class HistoryActivity extends AppCompatActivity {

    TransactionData transactionData;
    RecyclerView rvTransaction;
    TextView tvIdTransaction, tvNameTransaction, tvDateTransaction, tvQuantityTransaction, TvTotalTransaction;
    TransactionAdapter transactionAdapter;
    UserData userData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        transactionAdapter = new TransactionAdapter(transactionData.getVectTransaction());

        if(transactionAdapter.getItemCount() > 0){
            setContentView(R.layout.activity_history);

            transactionData = new TransactionData();
            rvTransaction = findViewById(R.id.rvTransaction);
            rvTransaction.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rvTransaction.setAdapter(transactionAdapter);
        } else {
            setContentView(R.layout.activity_no_list);
        }

        setTitle("Transaction History");

        Intent intent = getIntent();
        int userId = intent.getIntExtra("userId", 0);
        Log.wtf("intent", String.valueOf(userId));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.home :
                startActivity(new Intent(HistoryActivity.this, HomeActivity.class));
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
                Log.wtf("test", "Masuk History");
                break;
            case R.id.about :
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



    private Object getActivity() {
        return 3;
    }

}