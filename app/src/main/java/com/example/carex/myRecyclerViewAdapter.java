package com.example.carex;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyViewHolder>{
    List<ItemModel> itemsList;
    private static Context context;

    public myRecyclerViewAdapter(Context context, List<ItemModel> itemsList){
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyViewHolder holder, int position) {
        ItemModel data = itemsList.get(position);
        holder.itemNameTextView.setText(data.getItemName());
        holder.itemDescriptionTextView.setText(data.getItemDescription());
        holder.pickupTextView.setText(data.getPickupAddress());
        holder.phoneTextView.setText(data.getPhoneNo());
        holder.donorNameTextView.setText(data.getDonorName());
        holder.categoryTextView.setText(data.getCategory());

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView;
        TextView itemDescriptionTextView;
        TextView pickupTextView;
        TextView phoneTextView;
        TextView donorNameTextView;
        TextView categoryTextView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            itemDescriptionTextView = itemView.findViewById(R.id.itemDescriptionTextView);
            pickupTextView = itemView.findViewById(R.id.pickupTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            donorNameTextView = itemView.findViewById(R.id.donorNameTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
        }
    }
}
