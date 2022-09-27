package com.example.quiz1.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quiz1.FurnitureDetailActivity;
import com.example.quiz1.R;
import com.example.quiz1.data.FurnitureData;
import com.example.quiz1.models.Furniture;

import java.util.Vector;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.ViewHolder> {

    Context context;
    private final Vector<Furniture> vectFurniture;
    FurnitureData furnitureData;

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

        String name, img, desc;
        float rating = 0;
        int id, prc;

        id = vectFurniture.get(position).getId();
//        Log.wtf("adapter furniture", String.valueOf(id));
        name = vectFurniture.get(position).getName();
        rating = vectFurniture.get(position).getRating();
        prc = vectFurniture.get(position).getPrice();
        img = vectFurniture.get(position).getImage();
        desc = vectFurniture.get(position).getDescription();

        Glide.with(context)
                .load(img)
                .into(holder.picture);

//        for (Furniture f:vectFurniture) {
//            Log.wtf("loop", String.valueOf(f.getId()));
//        }
        holder.name.setText(name);
        holder.price.setText("$" + prc);
        holder.ratingrb.setEnabled(false);
        holder.ratingrb.setMax(5);
        holder.ratingrb.setStepSize(0.01f);
        holder.ratingrb.setRating(rating);
        holder.ratingrb.invalidate();

        holder.rating.setText(String.valueOf(rating));
        holder.description.setText(desc);

        float finalRating = rating;
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, FurnitureDetailActivity.class);
            intent.putExtra("prodId", id);
            intent.putExtra("name", name);
            intent.putExtra("rating", finalRating);
            intent.putExtra("prc", prc);
            intent.putExtra("img", img);
            intent.putExtra("desc", desc);
            context.startActivity(intent);
        });


//        Glide.with(context)
//                .load(vectFurniture.get(position).getImage())
//                .into(holder.picture);
//
//        holder.name.setText(vectFurniture.get(position).getName());
////        holder.ratingrb.setRating((float) vectFurniture.get(position).getRating());
//        holder.price.setText("$" + vectFurniture.get(position).getPrice());
//        holder.rating.setText(String.valueOf(vectFurniture.get(position).getRating()));
//        holder.description.setText(vectFurniture.get(position).getDescription());
//
//        String name = vectFurniture.get(position).getName();
//
//        holder.itemView.setOnClickListener(view -> {
//            Intent intent = new Intent(context, FurnitureDetailActivity.class);
//            intent.putExtra("name", name);
//            context.startActivity(intent);
//        });
    }



    @Override
    public int getItemCount() {
        return vectFurniture.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView name, price, rating, description;
        RatingBar ratingrb;
//        TextView itemSelected;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.ivListFurniture);
            name = itemView.findViewById(R.id.tvNameListFurniture);
            ratingrb = itemView.findViewById(R.id.rbListFurniture);

//            ratingrb = (RatingBar) rowView.findViewById(R.id.rbListFurniture);
//            ratingrb.setStepSize((float) 0.25);
//            ratingrb.setIsIndicator(true);
//            ratingrb.setRating((int) rating);

            rating = itemView.findViewById(R.id.tvRatingListFurniture);
            price = itemView.findViewById(R.id.tvPriceListFurniture);
            description = itemView.findViewById(R.id.tvDescriptionListFurniture);

        }
    }

    public Vector<Furniture> getVectFurniture() {
        return vectFurniture;
    }
}
