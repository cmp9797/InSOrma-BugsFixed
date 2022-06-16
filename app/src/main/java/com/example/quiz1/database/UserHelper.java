package com.example.quiz1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quiz1.models.User;

import java.security.PrivateKey;
import java.util.Vector;

public class UserHelper {
    private static String TABLE_NAME = "MsUsers";
    private static String FIELD_ID = "Id";
    private static String FIELD_EMAIL= "Email";
    private static String FIELD_NAME= "Name";
    private static String FIELD_PHONE = "Phone";
    private static String FIELD_PASS = "Password";

    private Context context;
    private SqlHelper sqlHelper;
    private SQLiteDatabase db;

    public UserHelper(Context context){
        this.context = context;
    }
    public UserHelper(){
        this.context = context;
    }

    public void open() throws SQLException {
        sqlHelper = new SqlHelper(context);
        db = this.sqlHelper.getWritableDatabase();
    }
    public void close() throws SQLException {
        sqlHelper.close();
    }

    //create table
    public void createTableUser(SQLiteDatabase db){
        Log.wtf("userhelper", "masuk createtable");
        String qCreate = "CREATE TABLE IF NOT EXISTS '"+ TABLE_NAME + "'(\n" +
                "'" + FIELD_ID + "' INTEGER,\n"+
                "'" + FIELD_EMAIL + "' TEXT, \n"+
                "'" + FIELD_NAME + "' TEXT,\n"+
                "'" + FIELD_PHONE + "' TEXT,\n"+
                "'" + FIELD_PASS + "' TEXT\n)";

        //excecute query -> jalanin kuerinya

        db.execSQL(qCreate);

        db.close();
        Log.wtf("userhelper", "end createtable");
    }

    public Vector<User> getAllUsers(Context context) {

        Vector<User> usersData = new Vector<User>();
        Log.wtf("userhelper", "test 1");

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        Log.wtf("userhelper", "test 2");
        Log.wtf("userhelper", "test 3");

        cursor.moveToFirst();

        Log.wtf("userhelper", "masuk getalluser - before if");
//        Log.wtf("userhelper", cursor.getString(1));

//        if(cursor.isNull(0)){
//            createTableUser(db);
//            cursor.close();
//            Log.wtf("userhelper", "masuk getalluser - cursor null");
//        } else

        if(cursor.getCount() > 0){
            int id;
            String email, name, phone, pass;

            do{
                id = cursor.getInt(0);
                email = cursor.getString(1);
                name = cursor.getString(2);
                phone = cursor.getString(3);
                pass = cursor.getString(4);
                User userAdded = new User(id,email,name,phone,pass);
//                userData.getVectUser().add(userAdded);
                usersData.add(userAdded);
                cursor.moveToFirst();
            }while(!cursor.isAfterLast());

            cursor.close();
            Log.wtf("userhelper", "masuk getalluser - ada data");

        }
//
        Log.wtf("userhelper", "masuk getalluser");
        return usersData;
    }

    public boolean isExists(Context context){
        SqlHelper sqlHelper = new SqlHelper(context);
        SQLiteDatabase db = sqlHelper.getWritableDatabase();

        String query = "SELECT name FROM sqlite_master\n" +
                "WHERE type = 'table' AND name = '"+ TABLE_NAME +"';";
        Cursor cursor = db.rawQuery(query, null);
        if(!cursor.moveToFirst()){
            cursor.close();
            return false; //not exist
        }
        cursor.close();
        return true;
    }


}
