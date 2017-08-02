package com.example.vonkar.vkart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by vonkar on 13/06/17.
 */

public class ProductsAdaptor extends RecyclerView.Adapter<ProductsAdaptor.ViewHolder>  {

    protected static  ArrayList<Product> productsSet;
    protected static  Context context;
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        public TextView pNameTextView;
        public TextView pAmountTextView;
        public int position;
        public ViewHolder(View v) {
            super(v);

            pAmountTextView = v.findViewById(R.id.amount);
            pNameTextView = v.findViewById(R.id.info_text);


            v.setOnClickListener(this);
        }

        public void onClick(View v) {
            Log.d("RecyclerView", "CLICK!");

            int pos = getPosition();

            Product prod = productsSet.get(pos);
            Intent myactivity = new Intent(context, ProductDetail.class);

            myactivity.putExtra("productName",prod.getProductName());
            myactivity.putExtra("productAmount", prod.getAmount());

            context.startActivity(myactivity);
        }
    }



    public ProductsAdaptor(ArrayList<Product> products,Context context) {


        this.productsSet = products;
        notifyDataSetChanged();
        this.context = context;

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowitem, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.pNameTextView.setText(this.productsSet.get(position).getProductName());
        holder.pAmountTextView.setText(this.productsSet.get(position).getAmount());

        holder.pNameTextView.setTextColor(Color.WHITE);
        holder.pAmountTextView.setTextColor(Color.WHITE);

    }

    public ProductsAdaptor() {
        super();
    }

    @Override
    public int getItemCount() {
        return this.productsSet.size();
    }


}
