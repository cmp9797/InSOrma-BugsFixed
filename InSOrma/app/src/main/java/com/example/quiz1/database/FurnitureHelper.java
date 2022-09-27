package com.example.quiz1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quiz1.data.FurnitureData;
import com.example.quiz1.data.UserData;
import com.example.quiz1.models.Furniture;
import com.example.quiz1.models.User;

import java.util.Vector;

public class FurnitureHelper {
    private static String TABLE_NAME = "MsFurnitures";
    private static String FIELD_ID = "Id";
    private static String FIELD_NAME= "Name";
    private static String FIELD_RATING= "Rating";
    private static String FIELD_PRC= "Price";
    private static String FIELD_IMG_SRC = "ImageSource";
    private static String FIELD_DESC = "Description";

    FurnitureData furnitureData;

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getFieldId() {
        return FIELD_ID;
    }

    public static String getFieldPrc() {
        return FIELD_PRC;
    }
    //create table
    public void createTableFurniture(SQLiteDatabase db){
        Log.wtf(" .furniturehelper", "masuk createtable");
        String qCreate = "CREATE TABLE IF NOT EXISTS '"+ TABLE_NAME + "'(\n" +
                "'" + FIELD_ID + "' INTEGER NOT NULL,\n"+
                "'" + FIELD_NAME + "' TEXT PRIMARY KEY, \n"+
                "'" + FIELD_RATING + "' REAL NOT NULL,\n"+
                "'" + FIELD_PRC + "' INTEGER NOT NULL,\n"+
                "'" + FIELD_IMG_SRC + "' TEXT NOT NULL,\n"+
                "'" + FIELD_DESC + "' TEXT NOT NULL, \n" +
                "UNIQUE('" + FIELD_ID + "')" +
                ");";

        //excecute query -> jalanin kuerinya
        db.execSQL(qCreate);
        Log.wtf(" .furniturehelper", "end createtable");
    }

    //insert to database
    public void insertFurnitureList(Context context, Vector<Furniture> furnitures){
        SqlHelper sqlHelper = new SqlHelper(context);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        Log.wtf(" .furniturehelper", "masuk insert, arr size = "+ furnitures.size());

        try {
            String query;
            try{
                query = "SELECT * FROM "+ TABLE_NAME;
                db.execSQL(query);
            }catch (SQLException e){
                createTableFurniture(db);
            }

            for (Furniture furniture:furnitures) {
                Log.wtf(" .furniturehelper", "inloop");
                query =
                        "INSERT OR IGNORE INTO " + TABLE_NAME + " (" +
                                FIELD_ID + ", " + FIELD_NAME + ", " + FIELD_RATING + ", " +
                                FIELD_PRC + ", " + FIELD_IMG_SRC + ", " + FIELD_DESC + ")\n" +
                                "VALUES ( " + furniture.getId() + ", " +
                                "'" + furniture.getName() + "', " +
                                "'" + furniture.getRating() + "', " +
                                "'" + furniture.getPrice() + "', " +
                                "'" + furniture.getImage() + "', " +
                                "'" + furniture.getDescription() + "')\n";
                furnitureData.getVectFurniture().add(furniture);
                db.execSQL(query);
                Log.wtf(" .furniturehelper", "loop");
            }
            db.close();
            Log.wtf(" .furniturehelper", "end createtable");

        }catch (SQLException e){
            Log.wtf(" .furniturehelper", "kena catch");

        }
    }

    public int isFurnitureDataExist(Context context){
        SqlHelper sqlHelper = new SqlHelper(context);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
//        Log.wtf(" .furniturehelper", "masuk insert, arr size = "+ furnitures.size());

        String query = "SELECT COUNT (*) FROM "+ TABLE_NAME;
        Cursor cursor = null;
        int count = -1;
        try{
            cursor = db.rawQuery(query, null);
            if(cursor.moveToNext()){
                count = cursor.getInt(0);
            }
        }catch (SQLException e){
            createTableFurniture(db);
        }
        cursor.close();
        return count;
    }

    //delete furniture
    public void deleteAllData(Context context){
    SqlHelper sqlHelper = new SqlHelper(context);
    SQLiteDatabase db = sqlHelper.getWritableDatabase();

    String query =
            "DELETE FROM "+ TABLE_NAME ;
    try {
        db.execSQL(query);
    }catch (SQLException e){
    }

    db.close();
}



}
