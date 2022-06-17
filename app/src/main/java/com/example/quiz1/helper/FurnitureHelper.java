package com.example.quiz1.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quiz1.data.FurnitureData;
import com.example.quiz1.models.Furniture;

import java.util.Vector;

public class FurnitureHelper {
    private static String database_table = "Products";
    private Context context;
    private DatabaseHelper databaseHelper;
    private FurnitureData furnitureData;
    private SQLiteDatabase database;

    public FurnitureHelper(Context context){
        this.context = context;
    }

    public void open() throws SQLException{
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public void close() throws SQLException{
        databaseHelper.close();
    }

    public void saveProducts(int i, String name, double rating, int price, String image, String description){
        Log.e("Message", "Ini masuk ke save products2");

        furnitureData = new FurnitureData(i, name, rating, price, image, description);

        String query="INSERT OR REPLACE INTO Products" +
                "(ProductName, " +
                "ProductRating, ProductPrice, ProductImage, ProductDescription) " +
                "VALUES('"+ name +"'," +
                "'"+ rating +"'," +
                "'"+ price +"'," +
                "'"+ image +"'," +
                "'"+ description +"'" +
                ")";
        database.execSQL(query);
    }
}