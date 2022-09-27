package com.example.quiz1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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
import com.example.quiz1.models.Furniture;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

public class HomeActivity extends AppCompatActivity {

    FurnitureData furnitureData = new FurnitureData();
    UserData userData;
    TransactionData transactionData;
    RecyclerView rvFurniture;
    FurnitureAdapter furnitureAdapter;
    Intent intent;

    private RequestQueue requestQueue;
    private ProgressDialog progressDialog;
    final String url = "https://mocki.io/v1/5f379081-2473-4494-9cc3-9e808772dc54";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        requestQueue = Volley.newRequestQueue(this);
        progressDialog = new ProgressDialog(this);

        startAsyncTask(R.layout.activity_home);

    }


    public void startAsyncTask(int view){
        InsormaAsyncTask task = new InsormaAsyncTask();
        task.execute(url);

    }

    private class InsormaAsyncTask extends AsyncTask<String, String, Vector<Furniture>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected Vector<Furniture> doInBackground(String... strings) {
            int dataCountInDatabase = 0;
            Vector<Furniture> furnitureVector;
            Log.wtf(" .homeactivity", "Furniture data load status = " + furnitureData.getLoadStatus());

            if(furnitureData.getLoadStatus() == false){
                furnitureVector = new Vector<Furniture>();
                dataCountInDatabase = furnitureData.checkDatabase(HomeActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray furnitures = response.getJSONArray("furnitures");
                                    for (int i = 0; i < furnitures.length(); i++) {
                                        JSONObject c = furnitures.getJSONObject(i);
                                        String product_name = c.getString("product_name");
                                        String rating = c.getString("rating");
                                        String price = c.getString("price");
                                        String desc = c.getString("description");
                                        String image = c.getString("image");
                                        int priceInt = Integer.parseInt(price);
                                        float ratingInt = Float.parseFloat(rating);

                                        //tambah data ke vector
                                        furnitureVector.add(new Furniture(i+1, product_name, ratingInt, priceInt, image, desc));
                                    }
                                    furnitureData.loadDataToDatabase(HomeActivity.this, furnitureVector);
                                    furnitureData.setLoadStatus(true);
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
                }
                );
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                requestQueue.add(jsonObjectRequest);
            } else {
                furnitureVector = furnitureData.getVectFurniture();
            }

            Log.wtf(" .homeactivity", "dataCountInDatabase = " + dataCountInDatabase);
            Log.wtf(" .homeactivity", "furnitureVector.size() = " + furnitureVector.size());
            Log.wtf(" .homeactivity", "transactionData.getVectTransaction() = " + transactionData.getVectTransaction());

            if(transactionData.getVectTransaction() != null ) {
                transactionData.loadDataFromDatabase(HomeActivity.this);
                Log.wtf(" .homeactivity", "if 2");
            }

            transactionData.setLoadStatus(true);

            return furnitureVector;
        }

        @Override
        protected void onPostExecute(Vector<Furniture> furnitureVector) {
            super.onPostExecute(furnitureVector);
//            setTitle("Hi " + userData.getLoggedIn().getUsername() + "!");

            progressDialog.dismiss();
            Toast.makeText(HomeActivity.this, "Welcome "+userData.getLoggedIn().getUsername(), Toast.LENGTH_LONG).show();

            rvFurniture = findViewById(R.id.rvFurniture);
            furnitureAdapter = new FurnitureAdapter(HomeActivity.this, furnitureVector);
            rvFurniture.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rvFurniture.setAdapter(furnitureAdapter);
            Log.wtf(" .homeactivity", "do post excecute, arr ="+ furnitureVector.size());

        }
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