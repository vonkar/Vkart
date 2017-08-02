package com.example.vonkar.vkart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vonkar on 13/06/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final String KEY_ID = "productID";
    private static final String KEY_NAME = "productname";
    private static final String KEY_AMT = "amount";

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "productManager";
    // Contacts table name
    private static final String TABLE_PRODUCTS = "products";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_AMT + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_PRODUCTS);

        onCreate(sqLiteDatabase);
    }

    void addProducts(Context context)
    {
        ArrayList<Product> products = (ArrayList<Product>) new ProductData().createProducts(context);
        SQLiteDatabase sb = this.getWritableDatabase();

        for (Product prod: products
             ) {

            ContentValues values = new ContentValues();
            values.put(KEY_NAME, prod.getProductName()); // Contact Name
            values.put(KEY_ID, prod.getProductID());
            values.put(KEY_AMT,prod.getAmount());

            sb.insert(TABLE_PRODUCTS,null,values);
        }

        sb.close();
    }

    public List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList();

        String strQuery = "SELECT * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery(strQuery,null);

        if (cursor.moveToFirst()) {
            do {
                Product prod = new Product();
                prod.setProductID(cursor.getString(0));
                prod.setProductName(cursor.getString(1));
                prod.setAmount(cursor.getString(2));

                products.add(prod);

            } while (cursor.moveToNext());
        }
        return  products;
    }

    public void deleteProduct(Product prod)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, KEY_ID + " = ? ", new String[] { String.valueOf(prod.getProductID())} );
        db.close();
    }

    public void updateUproduct(Product prod)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_AMT,prod.getAmount());
        values.put(KEY_ID,prod.getProductID());
        values.put(KEY_NAME,prod.getProductName());

        db.update(TABLE_PRODUCTS,values,KEY_ID + " = ? ",new String[]{String.valueOf(prod.getProductID())});

        db.close();
    }

}
