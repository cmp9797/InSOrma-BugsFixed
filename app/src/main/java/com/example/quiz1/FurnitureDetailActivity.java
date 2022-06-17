package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.quiz1.data.TransactionData;
import com.example.quiz1.models.Transaction;

import java.util.Vector;

public class FurnitureDetailActivity extends AppCompatActivity {

    EditText edtDetailQuantity;
    TextView tvDetailName, tvDetailPrice;
    RatingBar rbDetail;
    Button btnDetailBuy;
    Vector<Transaction> vectNewTransaction = new Vector<>();
    TransactionData transactionData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailName.setText(name);

        tvDetailPrice = findViewById(R.id.tvDetailPrice);
        rbDetail = findViewById(R.id.rbDetail);
        edtDetailQuantity = findViewById(R.id.edtDetailQuantity);
        btnDetailBuy = findViewById(R.id.btnDetailBuy);

        btnDetailBuy.setOnClickListener( v -> {
            String buyQuantity = edtDetailQuantity.getText().toString();
            Log.wtf("deleted", buyQuantity);

            if (Integer.parseInt(buyQuantity) > 0) {
                //intent item selected
//                vectNewTransaction.add();
//                transactionData.setVectTransaction(vectNewTransaction);

//                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED){
//                    ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS }, 123);
//                }

//                SmsManager manager = SmsManager.getDefault();
//                manager.sendTextMessage(phone, null, message, null, null);
            }
        });
    }
}