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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class addDetailActivity extends AppCompatActivity {
    EditText nameEt;
    EditText phoneEt;
    EditText itemNameEt;
    EditText descriptionEt;
    EditText pickupEt;
    Spinner dropdown;
    ImageView itemImageView;
    ActivityResultLauncher<String> mGetContent;
    ItemModel item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_detail);
        dropdown = findViewById(R.id.categoryDropdown);
        itemImageView= findViewById(R.id.itemImageView);

        nameEt = findViewById(R.id.nameEt);
        phoneEt = findViewById(R.id.phoneEt);
        itemNameEt = findViewById(R.id.itemNameEt);
        descriptionEt = findViewById(R.id.descriptionEt);
        pickupEt = findViewById(R.id.pickupEt);

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
        if(nameEt.getText().toString().equals("") || phoneEt.getText().toString().equals("") ||
        itemNameEt.getText().toString().equals("") ||  descriptionEt.getText().toString().equals("")
        || pickupEt.getText().toString().equals("") || dropdown.getSelectedItem().toString().equals("Category")){
            Toast.makeText(addDetailActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
        }else{
            try {
                item = new ItemModel(
                        nameEt.getText().toString(),
                        phoneEt.getText().toString(),
                        itemNameEt.getText().toString(),
                        descriptionEt.getText().toString(),
                        pickupEt.getText().toString(),
                        dropdown.getSelectedItem().toString(),
                        true
                );
                Toast.makeText(addDetailActivity.this, "WOHOO! ITEM ADDED", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                Toast.makeText(addDetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
            dbHelper dbHelper = new dbHelper(addDetailActivity.this);
            dbHelper.addItem(item);

            nameEt.setText("");
            phoneEt.setText("");
            itemNameEt.setText("");
            descriptionEt.setText("");
            pickupEt.setText("");
            dropdown.setSelection(0);
        }
    }
}