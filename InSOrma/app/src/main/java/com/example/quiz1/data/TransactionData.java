package com.example.quiz1.data;

import android.content.Context;
import android.util.Log;

import com.example.quiz1.database.TransactionHelper;
import com.example.quiz1.models.Transaction;
import com.example.quiz1.models.User;

import java.util.Vector;

public class TransactionData {
    private static Vector<Transaction> vectTransaction = new Vector<Transaction>();
//    private static Vector<Transaction> listPersonTransaction = new Vector<>();
    private static TransactionHelper transactionHelper = new TransactionHelper();
    private static boolean loadStatus = false;
//    public TransactionData() {
        //add to database
//        vectTransaction.add(new Transaction(1, 1, 1, "29/03/2022", 1));
//        vectTransaction.add(new Transaction(2, 3, 0, "02/04/2022", 1));
//        vectTransaction.add(new Transaction(3, 1, 0, "25/03/2022", 3));
//        vectTransaction.add(new Transaction(4, 2, 2, "25/03/2022", 4));
//        vectTransaction.add(new Transaction(5, 4, 3, "28/03/2022", 1));
//        vectTransaction.add(new Transaction(6, 4, 1, "27/03/2022", 1));
//        vectTransaction.add(new Transaction(7, 5, 2, "01/04/2022", 2));
//        vectTransaction.add(new Transaction(8, 2, 1, "02/04/2022", 1));
//        vectTransaction.add(new Transaction(9, 2, 0, "01/04/2022", 1));
//        vectTransaction.add(new Transaction(10, 1, 3, "31/03/2022", 1));

//    }
    public static void loadDataFromDatabase(Context context){
        Log.wtf("userdata", "load data - masok");
        vectTransaction = transactionHelper.getAllTransactionByUserId(context, UserData.getLoggedIn().getId());
        Log.wtf("userdata", "load data - selesai");
    }
//    public int checkDatabase(Context context){
//        return transactionHelper.isTransactionDataExist(context);
//    }

    public static  void deleteAllTransaction(Context context, User user){
        transactionHelper.deleteAllData(context, user);
    }
    public static void insertNewTransaction(Context context, Transaction trans){
        transactionHelper.insertTransaction(context, trans);
    }
    public static String getLastTransactionId(Context context){
        return transactionHelper.getLastTransactionId(context);
    }

    public static Vector<Transaction> getVectTransaction() {
        return vectTransaction;
    }

//    public static List<Transaction> getListPersonTransaction(int userId) {
//
//        for ( Transaction transaction : vectTransaction ) {
//            if (transaction.getUserId() == userId) {
////                int tempId = transaction.getId();
//                int tempUserId = transaction.getUserId();
//                int tempProductId = transaction.getProductId();
//                String tempDate = transaction.getTransactionDate();
//                int tempQuantity = transaction.getQuantity();
////                listPersonTransaction.add(new Transaction(tempId, tempUserId, tempProductId, tempDate, tempQuantity));
//            }
//        }
//        return listPersonTransaction;
//    }

    public static void setVectTransaction(Vector<Transaction> vectTransaction) {
        TransactionData.vectTransaction = vectTransaction;
    }

    public static boolean isLoadStatus() {
        return loadStatus;
    }

    public static void setLoadStatus(boolean loadStatus) {
        TransactionData.loadStatus = loadStatus;
    }
}
