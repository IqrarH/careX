package com.example.carex;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter2 extends RecyclerView.Adapter<myRecyclerViewAdapter2.MyViewHolder2>{
    List<ItemModel> itemsList;
    private static Context context;

    public myRecyclerViewAdapter2(Context context, List<ItemModel> itemsList){
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_item_view, parent, false);
        return new myRecyclerViewAdapter2.MyViewHolder2(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter2.MyViewHolder2 holder, int position) {
        ItemModel data = itemsList.get(position);
        holder.itemNameTextView.setText(data.getItemName());
        holder.itemDescriptionTextView.setText(data.getItemDescription());
        holder.pickupTextView.setText(data.getPickupAddress());
        holder.phoneTextView.setText(data.getPhoneNo());
        holder.donorNameTextView.setText(data.getDonorName());
        holder.availableTextView.setText(data.isAvailable()?"Available":"Delivered");
        if(holder.availableTextView.getText()=="Delivered"){
            holder.availableTextView.setTextColor(Color.RED);
            holder.deliveredBtn.setEnabled(false);
        }

        holder.deliveredBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper dbHelper = new dbHelper(context);
                dbHelper.markAsDelivered(data.getId());
                holder.availableTextView.setText("Delivered");
                holder.availableTextView.setTextColor(Color.RED);
                holder.deliveredBtn.setEnabled(false);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView itemNameTextView;
        TextView itemDescriptionTextView;
        TextView pickupTextView;
        TextView phoneTextView;
        TextView donorNameTextView;
        TextView availableTextView;
        Button deliveredBtn;

        public MyViewHolder2(@NonNull View itemView){
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            itemDescriptionTextView = itemView.findViewById(R.id.itemDescriptionTextView);
            pickupTextView = itemView.findViewById(R.id.pickupTextView);
            phoneTextView = itemView.findViewById(R.id.phoneTextView);
            donorNameTextView = itemView.findViewById(R.id.donorNameTextView);
            availableTextView = itemView.findViewById(R.id.availableTextView);
            deliveredBtn = itemView.findViewById(R.id.deliveredBtn);
        }


    }
}
