package com.example.vonkar.vkart;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDetail extends AppCompatActivity {


    public ProductDetail() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        this.updateUI();
    }

    void updateUI()
    {
        TextView prodName = (TextView) findViewById(R.id.productName);
        TextView prodAmount = (TextView) findViewById(R.id.productAmount);


        Intent intent = getIntent();

        String prodNameStr = intent.getStringExtra("productName");
        String prodAmntStr = intent.getStringExtra("productAmount");

        prodName.setTextColor(Color.WHITE);
        prodAmount.setTextColor(Color.WHITE);
        prodName.setText(prodNameStr);
        prodAmount.setText(prodAmntStr);
    }
}
