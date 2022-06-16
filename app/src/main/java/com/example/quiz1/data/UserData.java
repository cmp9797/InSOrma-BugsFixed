package com.example.quiz1.data;

import android.content.Context;

import com.example.quiz1.database.UserHelper;
import com.example.quiz1.models.User;

import java.util.Vector;

public class UserData {
    private static Vector<User> vectUser = new Vector<>();
    private static User loggedIn = null;
    public static UserHelper userHelper;
    public static int loggedInPostition = -1;
    public static  void loadData(Context context){
        vectUser = userHelper.getAllUsers(context);
    }

    public static Vector<User> getVectUser() {
        return vectUser;
    }

    public static void setVectUser(Vector<User> vectUser) {
        UserData.vectUser = vectUser;
    }

    public static User getLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(User loggedIn) {
        UserData.loggedIn = loggedIn;
    }


    public static int getLoggedInPostition() {
        return loggedInPostition;
    }

    public static void setLoggedInPostition(int loggedInPostition) {
        UserData.loggedInPostition = loggedInPostition;
    }
}
