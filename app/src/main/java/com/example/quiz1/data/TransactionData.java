package com.example.quiz1.data;

import com.example.quiz1.models.Transaction;

import java.util.Vector;

public class TransactionData {
    private Vector<Transaction> vectTransaction = new Vector<Transaction>();

    public TransactionData() {
        vectTransaction.add(new Transaction(1, "Couch", 1, 1500000, "29/03/2022"));
        vectTransaction.add(new Transaction(2, "Couch", 1, 1500000, "02/04/2022"));
        vectTransaction.add(new Transaction(3, "Nightstand", 3, 2400000, "25/03/2022"));
        vectTransaction.add(new Transaction(4, "Garden Chair", 4, 1800000, "25/03/2022"));
        vectTransaction.add(new Transaction(5, "Cupboard", 1, 1250000, "28/03/2022"));
        vectTransaction.add(new Transaction(6, "Couch", 1, 1500000, "27/03/2022"));
        vectTransaction.add(new Transaction(7, "Garden Chair", 2, 900000, "01/04/2022"));
        vectTransaction.add(new Transaction(8, "Couch", 1, 1500000, "02/04/2022"));
        vectTransaction.add(new Transaction(9, "Nightstand", 1, 800000, "01/04/2022"));
        vectTransaction.add(new Transaction(10, "Cupboard", 1, 1250000, "31/03/2022"));

    }

    public Vector<Transaction> getVectTransaction() {
        return vectTransaction;
    }

    public void setVectTransaction(Vector<Transaction> vectTransaction) {
        this.vectTransaction = vectTransaction;
    }
}
