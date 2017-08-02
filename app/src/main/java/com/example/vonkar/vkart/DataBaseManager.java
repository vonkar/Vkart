package com.example.vonkar.vkart;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by vonkar on 14/06/17.
 */

public class DataBaseManager {

    private DataBaseHandler dbHandler;

    public DataBaseManager(Context context)
    {
        instantiateDB(context);
    }

    private void instantiateDB(Context context) {
        dbHandler = new DataBaseHandler(context);


    }
    public void addProducts(Context context)
    {
        dbHandler.addProducts(context);
    }

    public ArrayList<Product> fetchAllProducts() {

        return  (ArrayList<Product>) dbHandler.getAllProducts();
    }

}
