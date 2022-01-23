package com.example.carex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {
    TextView emptyTv;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<ItemModel> itemsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        recyclerView = findViewById(R.id.exploreRecyclerView);
        recyclerView.setHasFixedSize(true);

        emptyTv = findViewById(R.id.emptyTextView);

        dbHelper dbHelper = new dbHelper(ExploreActivity.this);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        if(category.equals("None")){
            itemsList = dbHelper.getAllItems();
        }else{
            itemsList = dbHelper.getCategoryItems(category);
        }
        layoutManager = new LinearLayoutManager(ExploreActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new myRecyclerViewAdapter(ExploreActivity.this, itemsList) ;
        recyclerView.setAdapter(adapter);

        if(itemsList.size() == 0){
            emptyTv.setText("No Items Found");
        }
    }
}