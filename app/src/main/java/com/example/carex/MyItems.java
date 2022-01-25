package com.example.carex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MyItems extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<ItemModel> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_items);

        recyclerView = findViewById(R.id.myItemsRecyclerView);
        recyclerView.setHasFixedSize(true);

        dbHelper dbHelper = new dbHelper(MyItems.this);
        itemsList = dbHelper.getAllItems();

        layoutManager = new LinearLayoutManager(MyItems.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter2(MyItems.this, itemsList) ;
        recyclerView.setAdapter(adapter);
    }
}