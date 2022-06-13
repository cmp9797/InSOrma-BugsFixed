package com.example.quiz1.data;

import com.example.quiz1.models.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TransactionData {
    private Vector<Transaction> vectTransaction = new Vector<Transaction>();
    private List<Transaction> listPersonTransaction = new ArrayList<>();

    public TransactionData() {
        vectTransaction.add(new Transaction(1, 1, 1, "29/03/2022", 1));
        vectTransaction.add(new Transaction(2, 3, 1, "02/04/2022", 1));
        vectTransaction.add(new Transaction(3, 1, 4, "25/03/2022", 3));
        vectTransaction.add(new Transaction(4, 2, 2, "25/03/2022", 4));
        vectTransaction.add(new Transaction(5, 4, 5, "28/03/2022", 1));
        vectTransaction.add(new Transaction(6, 4, 1, "27/03/2022", 1));
        vectTransaction.add(new Transaction(7, 5, 2, "01/04/2022", 2));
        vectTransaction.add(new Transaction(8, 2, 1, "02/04/2022", 1));
        vectTransaction.add(new Transaction(9, 2, 4, "01/04/2022", 1));
        vectTransaction.add(new Transaction(10, 1, 5, "31/03/2022", 1));

    }

    public Vector<Transaction> getVectTransaction() {
        return vectTransaction;
    }

    public List<Transaction> getListPersonTransaction(int userId) {

        for ( Transaction transaction : vectTransaction ) {
            if (transaction.getUserId() == userId) {
                int tempId = transaction.getId();
                int tempUserId = transaction.getUserId();
                int tempProductId = transaction.getProductId();
                String tempDate = transaction.getTransactionDate();
                int tempQuantity = transaction.getQuantity();
                listPersonTransaction.add(new Transaction(tempId, tempUserId, tempProductId, tempDate, tempQuantity));
            }
        }
        return listPersonTransaction;
    }


    public void setListPersonTransaction(List<Transaction> listPersonTransaction) {
        this.listPersonTransaction = listPersonTransaction;
    }

    public void setVectTransaction(Vector<Transaction> vectTransaction) {
        this.vectTransaction = vectTransaction;
    }
}
