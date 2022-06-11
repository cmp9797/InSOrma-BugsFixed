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

import java.util.List;
import java.util.Vector;

public class HistoryActivity extends AppCompatActivity {

    TransactionData transactionData;
    RecyclerView rvTransaction;
    TextView tvIdTransaction, tvNameTransaction, tvDateTransaction, tvQuantityTransaction, TvTotalTransaction;
    TransactionAdapter transactionAdapter;
    UserData userData;
    Vector<Transaction> vectPersonal = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("Hi " + userData.getLoggedIn().getUsername() + "!");

        Intent intent = getIntent();
        int userId = intent.getIntExtra("userId", 0);
        List listTransaction = intent.getParcelableArrayListExtra("listTransaction");



        transactionData = new TransactionData();

        rvTransaction = findViewById(R.id.rvTransaction);
//        for (int i = 0 ; i < transactionData.getListPersonTransaction(userId).size() ; i++) {
//            vectPersonal.add(transactionData.getListPersonTransaction(userId).get(i));
//            transactionData.getListPersonTransaction(userId).get(i).getId();
//        }
        transactionAdapter = new TransactionAdapter(listTransaction);
        rvTransaction.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvTransaction.setAdapter(transactionAdapter);
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
                startActivity(new Intent(HistoryActivity.this, HomeActivity.class));
                Log.wtf("test", "Masuk Home");
                break;
            case R.id.profile :
                startActivity(new Intent(HistoryActivity.this, ProfileActivity.class));
                Log.wtf("test", "Masuk Profile");
                break;
            case R.id.history :
                Log.wtf("test", "Masuk History");
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    private Object getActivity() {
        return 3;
    }

}