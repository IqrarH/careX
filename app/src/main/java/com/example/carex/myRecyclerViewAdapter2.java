package com.example.carex;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myRecyclerViewAdapter2 extends RecyclerView.Adapter<myRecyclerViewAdapter.MyViewHolder>{
    List<ItemModel> itemsList;
    private static Context context;

    public myRecyclerViewAdapter2(Context context, List<ItemModel> itemsList){
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
