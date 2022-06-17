package com.example.quiz1.data;

import android.util.Log;
import com.example.quiz1.models.Furniture;

import java.util.Vector;

public class FurnitureData {
    private static Vector<Furniture> vectFurniture = new Vector<Furniture>();

    public FurnitureData(int id, String name, double rating, int price, String image, String description) {
        vectFurniture.add(new Furniture(id, name, rating, price, image, description));
        Log.e("Message", "Ini masuk ke vector");
    }

    public static Vector<Furniture> getVectFurniture() {
        return vectFurniture;
    }

    public void setVectFurniture(Vector<Furniture> vectFurniture) {
        this.vectFurniture = vectFurniture;
    }
}
