package com.example.quiz1.data;

import com.example.quiz1.R;
import com.example.quiz1.models.Furniture;

import java.util.Vector;

public class FurnitureData {
    private static Vector<Furniture> vectFurniture = new Vector<Furniture>();

    public FurnitureData() {
        vectFurniture.add(new Furniture("Couch", R.drawable.furniture1, 4.8, 1500000));
        vectFurniture.add(new Furniture("Garden Chair", R.drawable.furniture2, 4.5, 450000));
        vectFurniture.add(new Furniture("Dining Set", R.drawable.furniture3, 4.4, 1700000));
        vectFurniture.add(new Furniture("Nightstand", R.drawable.furniture4, 4.5, 800000));
        vectFurniture.add(new Furniture("Cupboard", R.drawable.furniture5, 4.6, 1250000));
    }

    public static Vector<Furniture> getVectFurniture() {
        return vectFurniture;
    }

    public void setVectFurniture(Vector<Furniture> vectFurniture) {
        this.vectFurniture = vectFurniture;
    }
}
