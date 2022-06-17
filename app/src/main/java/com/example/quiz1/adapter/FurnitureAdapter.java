package com.example.quiz1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quiz1.FurnitureDetailActivity;
import com.example.quiz1.R;
import com.example.quiz1.models.Furniture;

import java.util.Vector;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.ViewHolder> {

    Context context;
    private final Vector<Furniture> vectFurniture;

    public FurnitureAdapter(Context context, Vector<Furniture> vectFurniture) {
        this.vectFurniture = vectFurniture;
        this.context = context;
    }

    @NonNull
    @Override
    public FurnitureAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_furniture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.picture.setImageResource(vectFurniture.get(position).getImage());

        Glide.with(context)
                .load(vectFurniture.get(position).getImage())
                .into(holder.picture);

//        holder.ratingrb.setRating((float) vectFurniture.get(position).getRating());
//        holder.ratingBar.setRating((double) vectFurniture.get(position).getRating());
        String priceHolder = "$" + vectFurniture.get(position).getPrice();

        holder.name.setText(vectFurniture.get(position).getName());
        holder.price.setText(priceHolder);
        holder.rating.setText(String.valueOf(vectFurniture.get(position).getRating()));
        holder.description.setText(vectFurniture.get(position).getDescription());

        int id = vectFurniture.get(position).getId();
        String name = vectFurniture.get(position).getName();
        String description = vectFurniture.get(position).getDescription();
        String image = vectFurniture.get(position).getImage();
        int price = vectFurniture.get(position).getPrice();
        double rating = vectFurniture.get(position).getRating();

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, FurnitureDetailActivity.class);
            intent.putExtra("id", id);
            intent.putExtra("name", name);
            intent.putExtra("desc", description);
            intent.putExtra("image", image);
            intent.putExtra("price", price);
            intent.putExtra("rating", rating);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return vectFurniture.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView name, price, rating, description;
//        RatingBar ratingBar;
//        TextView itemSelected;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.ivListFurniture);
            name = itemView.findViewById(R.id.tvNameListFurniture);
            rating = itemView.findViewById(R.id.tvRatingListFurniture);
            price = itemView.findViewById(R.id.tvPriceListFurniture);
            description = itemView.findViewById(R.id.tvDescriptionListFurniture);
//            ratingrb = itemView.findViewById(R.id.rbListFurniture);
//            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
