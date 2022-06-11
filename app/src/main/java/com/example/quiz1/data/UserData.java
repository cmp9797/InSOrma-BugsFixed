package com.example.quiz1.data;

import com.example.quiz1.models.User;

import java.util.Vector;

public class UserData {
    private static Vector<User> vectUser = new Vector<>();
    private static User loggedIn = null;


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

}
