package com.example.quiz1.data;

import com.android.volley.RequestQueue;
import com.example.quiz1.R;
import com.example.quiz1.models.Furniture;

import java.util.Vector;

public class FurnitureData {
    private static Vector<Furniture> vectFurniture = new Vector<Furniture>();

    public FurnitureData(int id, String name, double rating, int price, String image, String description) {

        vectFurniture.add(new Furniture(id, name, rating, price, image, description));

//        vectFurniture.add(new Furniture(1, "Couch", 4.8, 1500000, R.drawable.furniture1, "Double size pastel couch"));
//        vectFurniture.add(new Furniture(2, "Garden Chair", 4.5, 450000, R.drawable.furniture2, "Single wooden outdoor chair"));
//        vectFurniture.add(new Furniture(3, "Dining Set", 4.4, 1700000, R.drawable.furniture3, "Inspired from original Japanese culture"));
//        vectFurniture.add(new Furniture(4, "Nightstand", 4.5, 800000, R.drawable.furniture4, "Classic mini nightstand set"));
//        vectFurniture.add(new Furniture(5, "Cupboard", 4.6, 1250000, R.drawable.furniture5, "Basic double door cupboard"));



    }

    public static Vector<Furniture> getVectFurniture() {
        return vectFurniture;
    }

    public void setVectFurniture(Vector<Furniture> vectFurniture) {
        this.vectFurniture = vectFurniture;
    }
}
