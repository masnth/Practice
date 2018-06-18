package com.example.huynguyen.listapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final TextView noteTextView = (TextView) findViewById(R.id.noteMultilineText);
        Button savenoteBtn = (Button) findViewById(R.id.savenoteButton);
        savenoteBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String newItem = noteTextView.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("com.example.huynguyen.NEW_ITEM", newItem);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
