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
//        Vector<Furniture> furnitureVector = furnitureData.getVectFurniture();
//        for(Furniture furniture : furnitureVector){
//            String name = furniture.getName();
//            Double rating = furniture.getRating();
//            int price = furniture.getPrice();
//            String description = furniture.getDescription();
//            String image = furniture.getImage();
//            String query="INSERT INTO Products " +
//                    "VALUES('"+ name +"', " +
//                    "'"+ rating +"', " +
//                    "'"+ price +"', " +
//                    "'"+ image +"', " +
//                    "'"+ description +"'" +
//                    ")";
//            database.execSQL(query);
//        }

        String query = "SELECT * FROM Products";

//        Cursor cursor = database.rawQuery(query, null);
//
//        if(cursor!=null && cursor.moveToLast()){
//            Log.e("Message", "Ini masuk ke save products1");
//            furnitureData = new FurnitureData(i, name, rating, price, image, description);
//
//            query="INSERT INTO Products" +
//                    "(ProductName, " +
//                    "ProductRating, ProductPrice, ProductImage, ProductDescription) " +
//                    "VALUES('"+ name +"'," +
//                    "'"+ rating +"'," +
//                    "'"+ price +"'," +
//                    "'"+ image +"'," +
//                    "'"+ description +"'" +
//                    ")";
//            database.execSQL(query);
//        } else {
            Log.e("Message", "Ini masuk ke save products2");
            furnitureData = new FurnitureData(i, name, rating, price, image, description);

            query="INSERT OR REPLACE INTO Products" +
                    "(ProductName, " +
                    "ProductRating, ProductPrice, ProductImage, ProductDescription) " +
                    "VALUES('"+ name +"'," +
                    "'"+ rating +"'," +
                    "'"+ price +"'," +
                    "'"+ image +"'," +
                    "'"+ description +"'" +
                    ")";
            database.execSQL(query);
//        }
//        cursor.close();
    }
}