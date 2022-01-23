package com.example.carex;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    public static final String ITEM_TABLE = "ItemTable";
    public static final String ITEM_ID = "ItemID";
    public static final String DONOR_NAME = "DonorName";
    public static final String PHONE_NO = "PhoneNo";
    public static final String ITEM_NAME = "ItemName";
    public static final String ITEM_DESCRIPTION = "ItemDescription";
    public static final String PICKUP_ADDRESS = "PickupAddress";
    public static final String CATEGORY = "Category";

    public dbHelper(@Nullable Context context){
        super(context, "studentDB.db", null, 4);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + ITEM_TABLE + "("
                + ITEM_ID + " Integer PRIMARY KEY AUTOINCREMENT, "
                + DONOR_NAME + " Text, "
                + PHONE_NO + " Text, "
                + ITEM_NAME + " Text, "
                + ITEM_DESCRIPTION + " Text, "
                + PICKUP_ADDRESS + " Text, "
                + CATEGORY + " Text) ";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ITEM_TABLE);
        onCreate(db);
    }

    public void  addItem(ItemModel Item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DONOR_NAME, Item.getDonorName());
        cv.put(PHONE_NO, Item.getPhoneNo());
        cv.put(ITEM_NAME, Item.getItemName());
        cv.put(ITEM_DESCRIPTION, Item.getItemDescription());
        cv.put(PICKUP_ADDRESS, Item.getPickupAddress());
        cv.put(CATEGORY, Item.getCategory());

        db.insert(ITEM_TABLE, null, cv);
        db.close();

    }
}
