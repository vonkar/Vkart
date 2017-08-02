package com.example.vonkar.vkart;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;
import static com.example.vonkar.vkart.ProductsAdaptor.context;

/**
 * Created by vonkar on 13/06/17.
 */

public class ProductData {


    private Context context;
    //Create Sample Products
    public List<Product> createProducts(Context context)
    {
        this.context = context;
        List<Product> products = new ArrayList();

        products = new ProductsParser(this.context).parseJson();
        return  products;
    }



}
