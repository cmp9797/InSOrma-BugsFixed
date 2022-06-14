package com.example.quiz1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.quiz1.R;
import com.example.quiz1.models.Furniture;

import java.util.Vector;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.ViewHolder> {

    Context context;
    private Vector<Furniture> vectFurniture = new Vector<>();
    private RecyclerViewClickListener listener;

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

        holder.name.setText(vectFurniture.get(position).getName());
//        holder.ratingrb.setRating((float) vectFurniture.get(position).getRating());
        holder.price.setText("$" + String.valueOf(vectFurniture.get(position).getPrice()));
        holder.rating.setText(String.valueOf(vectFurniture.get(position).getRating()));
        holder.description.setText(vectFurniture.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



    @Override
    public int getItemCount() {
        return vectFurniture.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView picture;
        TextView name, price, rating, description;
//        RatingBar ratingrb;
//        TextView itemSelected;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.ivListFurniture);
            name = itemView.findViewById(R.id.tvNameListFurniture);
//            ratingrb = itemView.findViewById(R.id.rbListFurniture);
            rating = itemView.findViewById(R.id.tvRatingListFurniture);
            price = itemView.findViewById(R.id.tvPriceListFurniture);
            description = itemView.findViewById(R.id.tvDescriptionListFurniture);

        }
    }

    public interface  RecyclerViewClickListener{
        void onClick(View view, int position);
    }
}
