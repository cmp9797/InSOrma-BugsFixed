package com.example.quiz1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz1.R;
import com.example.quiz1.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    int totalPrice;

//    public  TransactionAdapter(Vector<Transaction> vectTransaction) {
//        this.vectTransaction = vectTransaction;
//    }

//    private Vector<Transaction> vectTransaction = new Vector<>();


    public  TransactionAdapter(List<Transaction> listTransaction) {
        this.listTransaction = listTransaction;
    }

    private List<Transaction> listTransaction = new ArrayList<>();

    @NonNull
    @Override
    public TransactionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_transaction, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ViewHolder holder, int position) {

        holder.tvId.setText(String.valueOf(listTransaction.get(position).getId()));
        holder.tvName.setText(listTransaction.get(position).getProductId());
        holder.tvQuantity.setText(String.valueOf(listTransaction.get(position).getQuantity()));
        holder.tvTotal.setText(String.valueOf(listTransaction.get(position).getQuantity()));
        holder.tvDate.setText(listTransaction.get(position).getTransactionDate());
    }

    @Override
    public int getItemCount() {
        return listTransaction.size();
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
