package com.example.carex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDonateClick(View view) {
        Intent intent = new Intent(MainActivity.this, addDetailActivity.class);
        startActivity(intent);
    }

    public void onExploreClick(View view) {
        Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
        intent.putExtra("category", "None");
        startActivity(intent);
    }

    public void onOthersClick(View view) {
        Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
        intent.putExtra("category", "Others");
        startActivity(intent);
    }

    public void onVehicleClick(View view) {
        Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
        intent.putExtra("category", "Vehicle");
        startActivity(intent);
    }

    public void onFoodClick(View view) {
        Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
        intent.putExtra("category", "Food");
        startActivity(intent);
    }

    public void onHealthClick(View view) {
        Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
        intent.putExtra("category", "Health");
        startActivity(intent);
    }

    public void onShoesClick(View view) {
        Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
        intent.putExtra("category", "Shoes");
        startActivity(intent);
    }

    public void onClothesClick(View view) {
        Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
        intent.putExtra("category", "Clothes");
        startActivity(intent);
    }
}