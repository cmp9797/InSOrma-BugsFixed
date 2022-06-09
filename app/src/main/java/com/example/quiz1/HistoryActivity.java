package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quiz1.data.TransactionData;

public class HistoryActivity extends AppCompatActivity {

    TransactionData transactionData;
    RecyclerView rvTransaction;
    TransactionAdapter transactionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        transactionData = new TransactionData();

        rvTransaction = findViewById(R.id.rvTransaction);
        transactionAdapter = new TransactionAdapter(transactionData.getVectTransaction());

        rvTransaction.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvTransaction.setAdapter(transactionAdapter);
    }

}