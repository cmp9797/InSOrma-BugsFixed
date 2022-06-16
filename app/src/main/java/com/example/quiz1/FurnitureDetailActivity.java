package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1.data.TransactionData;
import com.example.quiz1.data.UserData;
import com.example.quiz1.models.Transaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

public class FurnitureDetailActivity extends AppCompatActivity {

    EditText edtDetailQuantity;
    TextView tvDetailName, tvDetailDescription, tvDetailPrice;
    ImageView imageView;
    RatingBar rbDetail;
    Button btnDetailBuy;
    Vector<Transaction> vectNewTransaction = new Vector<>();
    TransactionData transactionData = new TransactionData();
    UserData userData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture_detail);
        setTitle("Hi " + userData.getLoggedIn().getUsername() + "!");

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        String name = intent.getStringExtra("name");
        String description = intent.getStringExtra("desc");
        String image = intent.getStringExtra("image");
        int price = intent.getIntExtra("price", 0);
        float rating = intent.getFloatExtra("rating", 0);
        String strPrice = String.valueOf(price);

        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailName.setText(name);

        imageView = findViewById(R.id.imageView);
//        imageView.setImageResource(Integer.parseInt(image));

        tvDetailPrice = findViewById(R.id.tvDetailPrice);
        tvDetailPrice.setText(strPrice);

        rbDetail = findViewById(R.id.rbDetail);
        rbDetail.setRating(rating);

        tvDetailDescription = findViewById(R.id.tvDetailDescription);
        tvDetailDescription.setText(description);

        edtDetailQuantity = findViewById(R.id.edtDetailQuantity);
        btnDetailBuy = findViewById(R.id.btnDetailBuy);

        btnDetailBuy.setOnClickListener( v -> {

            String buyQuantity = edtDetailQuantity.getText().toString();
            Log.wtf("deleted", buyQuantity);

            if (Integer.parseInt(buyQuantity) > 0) {
                //intent item selected
//                int size = transactionData.getVectTransaction().size();
                int size = transactionData.getSize();
                int userId = UserData.getLoggedIn().getId();
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                String formattedDate = df.format(c);
                vectNewTransaction.add(new Transaction(size + 1, userId, id, formattedDate, Integer.parseInt(buyQuantity)));
                transactionData.setVectTransaction(vectNewTransaction);
                //update to database
                Toast.makeText(this, "Transaction is Completed!", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(this, HomeActivity.class);
                startActivity(intent2);

            }
        });
    }
}