package com.example.quiz1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz1.models.Transaction;

import java.util.Vector;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    public  TransactionAdapter(Vector<Transaction> vectTransaction) {
        this.vectTransaction = vectTransaction;
    }

    private Vector<Transaction> vectTransaction = new Vector<>();

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_transaction, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {

        holder.tvId.setText(String.valueOf(vectTransaction.get(position).getId()));
        holder.tvName.setText(vectTransaction.get(position).getName());
        holder.tvQuantity.setText(String.valueOf(vectTransaction.get(position).getQuantity()));
        holder.tvTotal.setText(String.valueOf(vectTransaction.get(position).getPrice()));
        holder.tvDate.setText(vectTransaction.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return vectTransaction.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvQuantity, tvTotal, tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvIdTransaction);
            tvName = itemView.findViewById(R.id.tvNameTransaction);
            tvQuantity = itemView.findViewById(R.id.tvQuantityTransaction);
            tvTotal = itemView.findViewById(R.id.tvTotalTransaction);
            tvDate = itemView.findViewById(R.id.tvDateTransaction);
        }
    }
}
