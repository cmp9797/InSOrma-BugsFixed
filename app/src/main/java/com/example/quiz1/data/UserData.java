package com.example.quiz1.data;
import com.example.quiz1.models.User;

import java.util.Vector;

public class UserData {
    private static Vector<User> vectUser = new Vector<>();
    private static User loggedIn = null;

    public static Vector<User> getVectUser() {
        return vectUser;
    }

    public void setVectUser(Vector<User> vectUser) {
        this.vectUser = vectUser;
    }

    public static User getLoggedIn() {
        return loggedIn;
    }

    public void changeUsername(String usernameNew, String email, String phone){
        for(User user : this.vectUser){
            if(email.equals(user.getEmailAddress()) && phone.equals(user.getPhoneNum())){
                user.setUsername(usernameNew);
            }
        }
    }

    public static void setLoggedIn(User loggedIn) {
        UserData.loggedIn = loggedIn;
    }


    // ARSIPPP Kode LAMA
//    public static UserHelper userHelper;
//    public static int loggedInPostition = -1;
//    public static  void loadData(Context context){
//        vectUser = userHelper.getAllUsers(context);
//    }

//    public static int getLoggedInPostition() {
//        return loggedInPostition;
//    }

//    public static void setLoggedInPostition(int loggedInPostition) {
//        UserData.loggedInPostition = loggedInPostition;
//    }

    //    public static void setVectUser(Vector<User> vectUser) {
//        this.vectUser = vectUser;
//    }
}
