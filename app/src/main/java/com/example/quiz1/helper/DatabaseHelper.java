package com.example.quiz1.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "InsormaDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query1 = "CREATE TABLE Users(" +
                "UserID integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "UserEmailAddress, " +
                "UserUsername, " +
                "UserPhoneNumber, " +
                "UserPassword" +
                ")";

        String query2 = "CREATE TABLE Products(" +
                "ProductName PRIMARY KEY, " +
                "ProductRating, " +
                "ProductPrice, " +
                "ProductImage, " +
                "ProductDescription" +
                ")";

        String query3 = "CREATE TABLE Transactions(" +
                "TransactionID integer NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "UserID integer, " +
                "ProductID, " +
                "TransactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                "Quantity, " +
                "FOREIGN KEY(UserID) REFERENCES Users(UserID), " +
                "FOREIGN KEY(ProductID) REFERENCES Product(ProductName)" +
                ")";

        sqLiteDatabase.execSQL(query1);
        sqLiteDatabase.execSQL(query2);
        sqLiteDatabase.execSQL(query3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Users");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Trasanctions");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Products");
        onCreate(sqLiteDatabase);
    }
}
