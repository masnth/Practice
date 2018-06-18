package com.example.huynguyen.listapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Huy Nguyen on 6/14/2018.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] prices;
    String[] descriptions;

    public ItemAdapter(Context ct, String[] it, String[] pr, String[] de) {
        items = it;
        prices = pr;
        descriptions = de;
        mInflater =  (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    public void setItem(String[] newItem) { items = newItem;}

    public void setPrices(String[] newPrices) { prices = newPrices;}

    public void setDescriptions(String[] newDescriptions) { descriptions = newDescriptions;}

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

        String name = items[position];
        String desc = descriptions[position];
        String price = prices[position];

        nameTextView.setText(name);
        descriptionTextView.setText(desc);
        priceTextView.setText(price);

        return v;
    }
}
