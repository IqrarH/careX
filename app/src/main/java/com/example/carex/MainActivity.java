package com.example.carex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setNavigationViewListener();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_menu);
        navigationView.setNavigationItemSelectedListener(this);
        MenuItem item = navigationView.getMenu().findItem(R.id.nav_myItems);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Log.d("TAD", "MENU");
                return false;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("Tag", "Clicked");
        Log.d("TAG", String.valueOf(item.getItemId()));
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setNavigationViewListener() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d("Tag", String.valueOf(item.getItemId()));
        return true;
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

    public void onMyItemsClick(View view) {
        Intent intent = new Intent(MainActivity.this, PhoneActivity.class);
        startActivity(intent);
    }
}