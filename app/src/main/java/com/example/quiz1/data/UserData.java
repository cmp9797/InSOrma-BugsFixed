package com.example.quiz1.data;

import com.example.quiz1.helper.UserHelper;
import com.example.quiz1.models.User;

import java.util.Vector;

public class UserData {
    private static Vector<User> vectUser = new Vector<>();
    private static User loggedIn = null;

    // method ini digunakan untuk memanggil vecotr vectuser
    public static Vector<User> getVectUser() {
        return vectUser;
    }

    // method ini digunakan untuk set data user dari db ke vector
    public void setVectUser(Vector<User> vectUser) {
        this.vectUser = vectUser;
    }

    public static User getLoggedIn() {
        return loggedIn;
    }

    public void changeUsername(String usernameNew, String email, String phone){
        for(User user : vectUser){
            if(email.equals(user.getEmailAddress()) && phone.equals(user.getPhoneNum())){
                user.setUsername(usernameNew);
            }
        }
    }

    public static void setLoggedIn(User loggedIn) {
        UserData.loggedIn = loggedIn;
    }

}
