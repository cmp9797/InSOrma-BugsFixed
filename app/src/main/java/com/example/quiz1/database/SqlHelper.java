package com.example.quiz1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {
    //bikin konstanta
    public static final String dbName = "dbInsorma";
    public static final int dbVersion = 1;
    public static final SQLiteDatabase.CursorFactory cFactory = null;
    private Context context;

    //constructor
    public SqlHelper(Context context){
        super(context, dbName, cFactory, dbVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //cm dipanggil sekali ketika db pertama dibuat
        //perlu create table" yg dibutuhkan di awal

        //table user
        Log.wtf("sqlhelper", "masuk sqlhelper oncreate - start");
        UserHelper userHelper = new UserHelper();
        userHelper.createTableUser(this.getWritableDatabase());
        Log.wtf("sqlhelper", "masuk sqlhelper oncreate - end");

        //table furniture
        FurnitureHelper furnitureHelper = new FurnitureHelper();
//        furnitureHelper.createTableFurniture(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS MsUsers");
//        onCreate(sqLiteDatabase);
    }

}
