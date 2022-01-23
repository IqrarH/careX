package com.example.carex;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class addDetailActivity extends AppCompatActivity {
    Spinner dropdown;
    ImageView itemImageView;
    ActivityResultLauncher<String> mGetContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_detail);
        dropdown = findViewById(R.id.categoryDropdown);
        itemImageView= findViewById(R.id.itemImageView);
        String[] items = new String[]{"Category", "Clothes", "Shoes", "Health", "Food", "Vehicle", "Others"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items){
            @Override
            public boolean isEnabled(int position) {
                return position != 0;
            }
        };
        dropdown.setAdapter(adapter);
        mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        itemImageView.setImageURI(uri);
                    }
                });
    }

    public void onImageClick(View view) {
        mGetContent.launch("image/*");
    }

    public void onComplete(View view) {
    }
}