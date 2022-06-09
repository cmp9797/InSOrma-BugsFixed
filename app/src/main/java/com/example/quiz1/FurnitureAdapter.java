package com.example.quiz1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz1.models.Furniture;

import java.util.Vector;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.ViewHolder> {

    private Vector<Furniture> vectFurniture = new Vector<>();

    public FurnitureAdapter(Vector<Furniture> vectFurniture) {
        this.vectFurniture = vectFurniture;
    }

    @NonNull
    @Override
    public FurnitureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_furniture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FurnitureAdapter.ViewHolder holder, int position) {
        holder.picture.setImageResource(vectFurniture.get(position).getImage());
        holder.name.setText(vectFurniture.get(position).getName());
        holder.rating.setRating((float) vectFurniture.get(position).getRating());
        holder.price.setText(String.valueOf(vectFurniture.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return vectFurniture.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView name, price;
        RatingBar rating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.ivListFurniture);
            name = itemView.findViewById(R.id.tvNameListFurniture);
            rating = itemView.findViewById(R.id.rbListFurniture);
            price = itemView.findViewById(R.id.tvPriceListFurniture);
        }
    }
}
