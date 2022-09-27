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
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.quiz1.data.TransactionData;
import com.example.quiz1.data.UserData;
import com.example.quiz1.models.SmsModel;
import com.example.quiz1.models.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FurnitureDetailActivity extends AppCompatActivity {

    EditText edtDetailQuantity;
    TextView tvDetailName, tvDetailDescription, tvDetailPrice;
    ImageView imageView;
    RatingBar rbDetail;
    Button btnDetailBuy;
    TransactionData transactionData = new TransactionData();
    UserData userData;

    public static ArrayList<SmsModel> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_detail);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS }, 123);
        }

        Intent intent = getIntent();
        int prodId = intent.getIntExtra("prodId", 0);
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("desc");
        String image = intent.getStringExtra("img");
        int price = intent.getIntExtra("prc", 0);
        float rating = intent.getFloatExtra("rating", 0);
        String strPrice = String.valueOf(price);

        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailName.setText(name);

        imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load(image)
                .into(imageView);

        tvDetailPrice = findViewById(R.id.tvDetailPrice);
        tvDetailPrice.setText(strPrice);

        rbDetail = findViewById(R.id.rbDetail);
        rbDetail.setRating(rating);

        tvDetailDescription = findViewById(R.id.tvDetailDescription);
        tvDetailDescription.setText(description);

        edtDetailQuantity = findViewById(R.id.edtDetailQuantity);
        btnDetailBuy = findViewById(R.id.btnDetailBuy);

        btnDetailBuy.setOnClickListener( v -> {

            int buyQuantity;
            buyQuantity = Integer.parseInt(edtDetailQuantity.getText().toString());
            Log.wtf("deleted", String.valueOf(buyQuantity));
            Log.wtf("product id", String.valueOf(prodId));

            String phone = "5554";
            String message = "Pembelian produk furniture" + name +" sejumlah "+ buyQuantity + " telah berhasil dilakukan.";

            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

            if (buyQuantity < 1)
                Toast.makeText(this, "Transaction faild! Minimal 1 item", Toast.LENGTH_LONG).show();
            else {
                //intent item selected
//                vectNewTransaction.add();
//                transactionData.setVectTransaction(vectNewTransaction);
//
//                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED){
//                    ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.SEND_SMS }, 123);
//                }
//
//                SmsManager manager = SmsManager.getDefault();
//                manager.sendTextMessage(phone, null, message, null, null);
//                int size = transactionData.getVectTransaction().size();

                String lastTrId = transactionData.getLastTransactionId(this);
                int userId = userData.getLoggedIn().getId();
                Log.wtf("userId plss", String.valueOf(userId));

                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String formattedDate = df.format(c);
//                String formattedDate = " ";
                Log.wtf("deleted - date", formattedDate);

                int totPrice = buyQuantity*price;

                String transId;
                if(lastTrId == null)
                    transId = "TR001";
                else {

                    int temp = Integer.parseInt(lastTrId.substring(2))+1;
                    if(temp < 10){
                        transId = "TR00" + temp;
                    } else if (temp < 100){
                        transId = "TR0" + temp;
                    } else {
                        transId = "TR" + temp;
                    }
                }
                //update to database
                transactionData.insertNewTransaction(
                    this, new Transaction(transId, userId, prodId, price, totPrice,
                            formattedDate, buyQuantity)
                );
                Toast.makeText(this, "Transaction is Completed!", Toast.LENGTH_LONG).show();
                super.onBackPressed();
//                Intent intent2 = new Intent(FurnitureDetailActivity.this, HomeActivity.class);
//                startActivity(intent2);
            }
        });
    }
}