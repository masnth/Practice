package com.example.huynguyen.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter itemAdapter;
    private ListView myListView;
    String[] items;
    String[] prices;
    String[] descriptions;
    String[] tempitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        String[] res_items = res.getStringArray(R.array.items);
        if (tempitems == null) {
            items = res_items;
        }
        else {
            items = tempitems;
        }


        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.description);

        itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        myListView.setAdapter(itemAdapter);

        Button additemBtn = (Button) findViewById(R.id.additemBtn);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity =
                        new Intent(getApplicationContext(),DetailActivity.class);
                showDetailActivity.putExtra("example.huynguyen.ITEM_INDEX", position);
                startActivity(showDetailActivity);
            }
        });

        additemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent additemIntent = new Intent(getApplicationContext(), AddItem.class);
                startActivityForResult(additemIntent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String newItem = data.getStringExtra("com.example.huynguyen.NEW_ITEM");
                tempitems = Arrays.copyOf(items, items.length + 1);
                tempitems[items.length] = newItem;
                items = tempitems;
                prices = new String[] {"0.1", "0.2", "0.3", "0.4"};
                descriptions = new String[] {"a", "b", "c", "d"};
                itemAdapter.setItem(items);
                itemAdapter.setPrices(prices);
                itemAdapter.setDescriptions(descriptions);
                itemAdapter.notifyDataSetChanged();
            }
        }
    }
}
