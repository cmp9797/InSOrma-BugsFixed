package com.example.quiz1.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quiz1.data.UserData;
import com.example.quiz1.models.User;


public class UserHelper {
    private static String database_table = "Users";
    private Context context;
    private DatabaseHelper databaseHelper;
    private UserData userData;
    private User user;

    private SQLiteDatabase database;

    public UserHelper(Context context){
        this.context = context;
    }

    public void open() throws SQLException{
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
    }

    public void close() throws SQLException{
        databaseHelper.close();
    }

    public void viewUsers(){
//        Vector<User> userVector = new Vector<>();
        String query = "SELECT * FROM Users";

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();

        int tempID;
        String tempEmail, tempUsername, tempPhoneNumber, tempPassword;

        if(cursor.getCount() > 0) {
            do {
                tempID = cursor.getInt(cursor.getColumnIndexOrThrow("UserID"));
                tempEmail = cursor.getString(cursor.getColumnIndexOrThrow("UserEmailAddress"));
                tempUsername = cursor.getString(cursor.getColumnIndexOrThrow("UserUsername"));
                tempPhoneNumber = cursor.getString(cursor.getColumnIndexOrThrow("UserPhoneNumber"));
                tempPassword = cursor.getString(cursor.getColumnIndexOrThrow("UserPassword"));

                user = new User(tempID, tempEmail, tempUsername, tempPhoneNumber, tempPassword);
//                userVector.add(user);
                userData.getVectUser().add(user);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
//        return userVector;
    }

    public void insertNew(String email, String username, String phoneNumber, String password){
        String query = "SELECT UserEmailAddress, UserUsername, UserPhoneNumber, UserPassword FROM Users";

        Cursor cursor = database.rawQuery(query, null);

        if(cursor!=null && cursor.moveToLast()){
            Log.e("Message", "Masukk");
            query = "INSERT INTO Users(UserEmailAddress, UserUsername, UserPhoneNumber, UserPassword) VALUES('"+email+"','"+username+"','"+phoneNumber+"','"+password+"')";
            database.execSQL(query);
        } else {
            Log.e("Message", "Masukk kedua");
            query = "INSERT INTO Users(" +
                    "UserEmailAddress, " +
                    "UserUsername, " +
                    "UserPhoneNumber, " +
                    "UserPassword) " +
                    "VALUES('"+email+"','"+username+"','"+phoneNumber+"','"+password+"')";
            database.execSQL(query);
        }
        cursor.close();
    }

    public void updateProfile(String usernameNew, String userEmailNew, String userPhoneNew){
        String query = "UPDATE Users SET UserUsername = '"+ usernameNew +"' WHERE UserEmailAddress = '"+ userEmailNew +"' AND UserPhoneNumber = '"+ userPhoneNew +"'";
        database.execSQL(query);
//        userData.changeUsername(usernameNew, userEmailNew, userPhoneNew);
    }

    public void deleteProfile(String userEmailNew, String userPhoneNew){
        String query = "DELETE FROM Users WHERE UserEmailAddress = '"+ userEmailNew +"' AND UserPhoneNumber = '"+ userPhoneNew +"'";
        database.execSQL(query);
    }
}
