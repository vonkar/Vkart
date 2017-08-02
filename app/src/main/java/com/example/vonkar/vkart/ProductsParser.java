package com.example.vonkar.vkart;

import android.content.ContentValues;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vonkar on 15/06/17.
 */

public class ProductsParser {

    private Context context;

    public ProductsParser(Context context) {
        this.context = context;
    }

    public List<Product> parseJson(){

        List<Product> products = new ArrayList();
        String inputJson = loadJSONFromAsset();
        try {
            JSONObject reader = new JSONObject(inputJson);
            JSONArray prodArray = reader.getJSONArray("products");

            for (int i=0;i<prodArray.length();i++){
                JSONObject prod = prodArray.getJSONObject(i);
                Product product = new Product();
                product.setProductName(prod.opt("name").toString());
                product.setAmount(prod.opt("amount").toString());
                product.setProductID(prod.opt("id").toString());

                products.add(product);

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return products;
    }

    public String loadJSONFromAsset()
    {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Products.JSON");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
