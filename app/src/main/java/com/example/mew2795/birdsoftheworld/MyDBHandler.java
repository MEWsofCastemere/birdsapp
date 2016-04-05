package com.example.mew2795.birdsoftheworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_PRODUCTS = "products";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_BIRDTYPE = "bird type";
    public static final String COLUMN_DATOS = "date and time of sighting";
    public static final String COLUMN_LOS = "location";
    public static final String COLUMN_NOTES = "notes";

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_PRODUCTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_BIRDTYPE
                + " TEXT," + COLUMN_DATOS + " TEXT" + COLUMN_LOS + " TEXT" + COLUMN_NOTES + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);

    }
    public void addProduct(data product) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_BIRDTYPE, product.getBIRDTYPE());
        values.put(COLUMN_DATOS, product.getDATOS());
        values.put(COLUMN_LOS, product.getLOS());
        values.put(COLUMN_NOTES, product.getNOTES());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_PRODUCTS, null, values);
        db.close();}

    public data findProduct(String birdtype) {
        String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_BIRDTYPE + " =  \"" + birdtype + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        data product = new data();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            product.setID(Integer.parseInt(cursor.getString(0)));
            product.setbirdtype(cursor.getString(1));
            product.setdatos(cursor.getString(2));
            product.setlos(cursor.getString(3));
            product.setnotes(cursor.getString(4));
            cursor.close();
        } else {
            product = null;
        }
        db.close();
        return product;
    }
    public boolean deleteProduct(String birdtype) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_BIRDTYPE + " =  \"" + birdtype + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        data product = new data();

        if (cursor.moveToFirst()) {
            product.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_PRODUCTS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(product.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

}
