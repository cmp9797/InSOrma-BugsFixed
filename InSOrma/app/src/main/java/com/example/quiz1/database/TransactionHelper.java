package com.example.quiz1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quiz1.data.TransactionData;
import com.example.quiz1.models.Transaction;
import com.example.quiz1.models.User;

import java.util.Vector;

public class TransactionHelper {
    private static String TABLE_NAME = "MsTransactions";
    private static String FIELD_ID = "Id";
    private static String FIELD_USER_ID = "UserId";
    private static String FIELD_PRD_ID = "ProductId";
    private static String FIELD_DATE= "TransactionDate";
    private static String FIELD_QTY= "Quantity";
    private static String FIELD_TOTPRC= "TotalPrice";

    private static String USER_TABLE_NAME = UserHelper.getTableName();
    private static String USER_FIELD_ID = UserHelper.getFieldId();

    private static String FURNITURE_TABLE_NAME = FurnitureHelper.getTableName();
    private static String FURNITURE_FIELD_ID = FurnitureHelper.getFieldId();
    private static String FURNITURE_FIELD_PRC = FurnitureHelper.getFieldPrc();

    TransactionData transactionData;

    //create table
    public void createTableTransaction(SQLiteDatabase db){
        Log.wtf("userhelper", "masuk createtable");
        String qCreate = "CREATE TABLE IF NOT EXISTS '"+ TABLE_NAME + "'(\n" +
                "'" + FIELD_ID + "' TEXT PRIMARY KEY,\n"+
                "'" + FIELD_USER_ID + "' INTEGER NOT NULL, \n"+
                "'" + FIELD_PRD_ID + "' TEXT NOT NULL,\n"+
                "'" + FIELD_DATE + "' TEXT NOT NULL,\n"+
                "'" + FIELD_QTY + "' INTEGER NOT NULL,\n" +
                "'" + FIELD_TOTPRC  + "' INTEGER NOT NULL,\n" +
                "FOREIGN KEY('" + FIELD_USER_ID + "') REFERENCES "+ USER_TABLE_NAME +"('"+ USER_FIELD_ID +"'),\n"+
                "FOREIGN KEY('" + FIELD_PRD_ID + "') REFERENCES "+ FURNITURE_TABLE_NAME +"('"+ FURNITURE_FIELD_ID + "')" +
                ");";

        //excecute query -> jalanin kuerinya
        db.execSQL(qCreate);
//        db.close(); //emg ga perlu
        Log.wtf("userhelper", "end createtable");
    }

    //insert to database
    public void insertTransaction(Context context, Transaction trans){
        SqlHelper sqlHelper = new SqlHelper(context);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();

        String query =
                "INSERT OR IGNORE INTO "+ TABLE_NAME +" ("+
                        FIELD_ID + ", "+ FIELD_USER_ID + ", "+ FIELD_PRD_ID + ", "+
                        FIELD_DATE + ", "+ FIELD_QTY + ", "+ FIELD_TOTPRC +")\n" +
                        "VALUES ( '" + trans.getId() +"', " +
                        "'" + trans.getUserId() +"', " +
                        "'" + trans.getProductId() +"', " +
                        "'" + trans.getTransactionDate() +"', " +
                        "" + trans.getQuantity() +", " +
                        "" + trans.getTotPrice() +")\n";
        try {
            db.execSQL(query);
            db.close();
            transactionData.getVectTransaction().add(trans);
        }catch (SQLException e){
        }
        Log.wtf("insert trans",query);
    }


    public Vector<Transaction> getAllTransactionByUserId(Context context, int num) {
        SqlHelper sqlHelper = new SqlHelper(context);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();

        Vector<Transaction> transactions = new Vector<Transaction>();
//        Log.wtf("transHelper", "getAllTransaction start");

        String query = "SELECT " + TABLE_NAME + "."+ FIELD_ID + ",\n"+
                            FIELD_USER_ID + ",\n" +
                            FURNITURE_TABLE_NAME+ "." + FURNITURE_FIELD_ID + ",\n" +
                            FURNITURE_TABLE_NAME+ "." + FURNITURE_FIELD_PRC + ",\n" +
                            FIELD_TOTPRC + ",\n" +
                            FIELD_DATE + ",\n" +
                            FIELD_QTY + "\n" +
                        "FROM " + TABLE_NAME + "\n"+
                        "INNER JOIN " + FURNITURE_TABLE_NAME+ "\n"+
                        "ON "+ TABLE_NAME +"."+ FIELD_PRD_ID +" = "+ FURNITURE_TABLE_NAME+ "."+ FURNITURE_FIELD_ID + "\n"+
                        "WHERE "+ FIELD_USER_ID +" = " + num;

        Cursor cursor = null;
        try{
            cursor = db.rawQuery(query, null);
//            Log.wtf("transHelper", "test");

            String id, date;
            int userId, productId, prc, totPrc, qty;

            while(cursor.moveToNext()){
                id = cursor.getString(0);
                userId = cursor.getInt(1);
                productId = cursor.getInt(2);
                prc = cursor.getInt(3);
                totPrc = cursor.getInt(4);
                date = cursor.getString(5);
                qty = cursor.getInt(6);

                Transaction trans = new Transaction(id, userId, productId, prc, totPrc, date,qty);
                transactions.add(trans);
//                Log.wtf("transHelper", "loop");
            };
            while(cursor.moveToNext());

            cursor.close();
//            Log.wtf("transHelper", "masuk getAllTransaction - ada data");

        }catch (SQLException e){
            createTableTransaction(db);
//            Log.wtf("transHelper", "masuk getAllTransaction - kena catch");

        }
//        Log.wtf("transHelper", query);
//        Log.wtf("transHelper", "trans size = "+transactions.size());
//        Log.wtf("transHelper", "getAllTransaction done");
        return transactions;
    }

    public String getLastTransactionId(Context context){
        SqlHelper sqlHelper = new SqlHelper(context);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        String query = "SELECT "+FIELD_ID+" FROM "+ TABLE_NAME+"\n"+
                "ORDER BY "+FIELD_ID+" DESC \n"+
                "LIMIT 1";
        Cursor cursor = null;
        String lastTransId = null;
        try{
            cursor = db.rawQuery(query, null);
            if(cursor.moveToNext()){
                lastTransId = cursor.getString(0);
            }
        }catch (SQLException e){
            createTableTransaction(db);
        }
        cursor.close();
        Log.wtf("transHelper - last trans id", query);

        return lastTransId;
    }

    public int isTransactionDataExist(Context context){
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
            createTableTransaction(db);
        }
        cursor.close();
        return count;
    }

    public void deleteAllData(Context context, User user) {
        SqlHelper sqlHelper = new SqlHelper(context);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();

        String query =
                "DELETE FROM " + TABLE_NAME + "\n" +
                        "WHERE " + FIELD_USER_ID + " = " + user.getId();
        Log.wtf("transHelper - del all data", query);
        db.execSQL(query);
        db.close();
    }

}

