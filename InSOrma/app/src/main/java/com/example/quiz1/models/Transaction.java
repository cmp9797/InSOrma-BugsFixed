package com.example.quiz1.models;

public class Transaction {
//    private int id;
//    private String name;
//    private int quantity;
//    private int price;
//    private String date;

    private String id;
    private int userId;
    private int productId;
    private int price;
    private int totPrice;
    private String transactionDate;
    private int quantity;

    public Transaction(String id, int userId, int productId, int price, int totPrice, String transactionDate, int quantity) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.price = price;
        this.totPrice = totPrice;
        this.transactionDate = transactionDate;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public int getPrice() {
        return price;
    }

    public void setPrice(int totPrice) {
        this.totPrice = price;
    }

    public int getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(int totPrice) {
        this.totPrice = totPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
