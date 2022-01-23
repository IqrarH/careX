package com.example.carex;

import android.content.Context;
import android.graphics.Color;
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
        holder.availableTextView.setText(data.isAvailable()?"Available":"Finished");
        if(holder.availableTextView.getText()=="Finished"){
            holder.availableTextView.setTextColor(Color.RED);
        }
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
        TextView availableTextView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            itemDescriptionTextView = itemView.findViewById(R.id.itemDescriptionTextView);
            pickupTextView = itemView.findViewById(R.id.pickupTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            donorNameTextView = itemView.findViewById(R.id.donorNameTextView);
            availableTextView = itemView.findViewById(R.id.availableTextView);

        }
    }
}
