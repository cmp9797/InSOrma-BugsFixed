package com.example.quiz1.models;

public class Transaction {
//    private int id;
//    private String name;
//    private int quantity;
//    private int price;
//    private String date;

    private int id;
    private int userId;
    private int productId;
    private String transactionDate;
    private int quantity;

    public Transaction(int id, int userId, int productId, String transactionDate, int quantity) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.transactionDate = transactionDate;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
