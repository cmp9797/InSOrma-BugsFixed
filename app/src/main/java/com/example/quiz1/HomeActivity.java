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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.quiz1.adapter.FurnitureAdapter;
import com.example.quiz1.data.FurnitureData;
import com.example.quiz1.data.TransactionData;
import com.example.quiz1.data.UserData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {

    FurnitureData furnitureData;
    UserData userData;
    TransactionData transactionData;
    RecyclerView rvFurniture;
    FurnitureAdapter furnitureAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Hi " + userData.getLoggedIn().getUsername() + "!");

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url = "https://mocki.io/v1/5f379081-2473-4494-9cc3-9e808772dc54";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray furnitures = response.getJSONArray("furnitures");
                    for(int i=0;i<furnitures.length(); i++){
                        JSONObject c = furnitures.getJSONObject(i);
                        String product_name = c.getString("product_name");
                        String rating = c.getString("rating");
                        String price = c.getString("price");
                        String desc = c.getString("description");
                        String image = c.getString("image");
                        int priceInt = Integer.parseInt(price);
                        double ratingInt = Double.parseDouble(rating);

//                        furnitureData(i, product_name, ratingInt, price, desc, image);
                        furnitureData = new FurnitureData(i, product_name, ratingInt, priceInt, image, desc);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                furnitureAdapter.notifyDataSetChanged();
            }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Info", error.toString());
                }
        });

//        furnitureData = new FurnitureData();

        requestQueue.add(jsonObjectRequest);

        rvFurniture = findViewById(R.id.rvFurniture);
        furnitureAdapter = new FurnitureAdapter(this, FurnitureData.getVectFurniture());

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
                startActivity(intent);
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