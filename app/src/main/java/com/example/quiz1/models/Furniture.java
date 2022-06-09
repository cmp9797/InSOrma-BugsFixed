package com.example.quiz1.models;

public class Furniture {
    private String name;
    private int image;
    private double rating;
    private int price;

    public Furniture(String name, int image, double rating, int price) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
