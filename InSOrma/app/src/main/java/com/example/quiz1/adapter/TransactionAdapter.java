package com.example.quiz1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz1.R;
import com.example.quiz1.data.FurnitureData;
import com.example.quiz1.models.Furniture;
import com.example.quiz1.models.Transaction;

import java.util.Vector;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private Vector<Transaction> transactionVector;
    int totalPrice;

//    public  TransactionAdapter(Vector<Transaction> vectTransaction) {
//        this.vectTransaction = vectTransaction;
//    }

//    private Vector<Transaction> vectTransaction = new Vector<>();


    public  TransactionAdapter(Vector<Transaction> transactionVector) {
        this.transactionVector = transactionVector;
    }

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_transaction, parent, false);
        return  new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {

        String name = "-";
        int price = 1;

        holder.tvId.setText(transactionVector.get(position).getId());
        transactionVector.get(position).getProductId();

        Vector<Furniture> vectFurniture = FurnitureData.getVectFurniture();
        for (Furniture furniture: vectFurniture) {
            if (transactionVector.get(position).getProductId() == furniture.getId()) {
                name = furniture.getName();
                price = furniture.getPrice();
            }
        }
        totalPrice = transactionVector.get(position).getTotPrice();
//        holder.tvName.setText(Integer.toString(listTransaction.get(position).getProductId()));
        holder.tvName.setText(name);
        holder.tvQuantity.setText(String.valueOf(transactionVector.get(position).getQuantity()));
        holder.tvPriceEach.setText("$" + String.valueOf(price));
        holder.tvTotal.setText("$" + String.valueOf(totalPrice));
        holder.tvDate.setText(String.valueOf(transactionVector.get(position).getTransactionDate()));
    }


    @Override
    public int getItemCount() {
        return transactionVector.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvQuantity, tvTotal, tvDate, tvPriceEach;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvIdTransaction);
            tvName = itemView.findViewById(R.id.tvNameTransaction);
            tvQuantity = itemView.findViewById(R.id.tvQuantityTransaction);
            tvPriceEach = itemView.findViewById(R.id.tvPriceEachTransaction);
            tvTotal = itemView.findViewById(R.id.tvTotalTransaction);
            tvDate = itemView.findViewById(R.id.tvDateTransaction);
        }
    }
}
