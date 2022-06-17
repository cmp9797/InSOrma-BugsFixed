package com.example.quiz1.models;

public class Furniture {

    private int Id;
    private String name;
    private double rating;
    private int price;
    private String image;
    private String description;


    public Furniture(int id, String name, double rating, int price, String image, String description) {
        Id = id;
        this.name = name;
        this.rating = rating;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public double getRating() {
        return rating;
    }
    public int getPrice() {
        return price;
    }
    public String getImage() { return image; }
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) { this.name = name; }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setDescription(String description) { this.description = description; }
}
