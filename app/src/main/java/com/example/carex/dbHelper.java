package com.example.carex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
    public static final String ITEM_TABLE = "ItemTable1";
    public static final String ITEM_ID = "ItemID";
    public static final String DONOR_NAME = "DonorName";
    public static final String PHONE_NO = "PhoneNo";
    public static final String ITEM_NAME = "ItemName";
    public static final String ITEM_DESCRIPTION = "ItemDescription";
    public static final String PICKUP_ADDRESS = "PickupAddress";
    public static final String STATUS = "Status";
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
                + STATUS + " BOOL, "
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
        cv.put(STATUS, true);
        cv.put(CATEGORY, Item.getCategory());


        db.insert(ITEM_TABLE, null, cv);
        db.close();
    }

    public ArrayList<ItemModel> getAllItems() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + ITEM_TABLE, null);

        ArrayList<ItemModel> itemArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                itemArrayList.add(new ItemModel(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(7),
                        cursorCourses.getInt(6)== 1 ? true : false)
                        );
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        Log.d("TAG", String.valueOf(itemArrayList));
        return itemArrayList;
    }

    public ArrayList<ItemModel> getCategoryItems(String category){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + ITEM_TABLE +
                " where " + CATEGORY + "='" + category+ "'", null);

        ArrayList<ItemModel> itemArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                itemArrayList.add(new ItemModel(cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4),
                        cursorCourses.getString(5),
                        cursorCourses.getString(7),
                        cursorCourses.getInt(6)== 1 ? true : false)
                );
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        Log.d("TAG", String.valueOf(itemArrayList));
        return itemArrayList;
    }

    public void deleteStudent(int id){
        SQLiteDatabase db = this.getWritableDatabase();
//        db.update(ITEM_TABLE,"STUDENTID=?",new String[]{String.valueOf(id)});
        db.close();

    }
}
