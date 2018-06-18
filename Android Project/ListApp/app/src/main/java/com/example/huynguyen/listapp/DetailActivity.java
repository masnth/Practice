package com.example.huynguyen.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in  = getIntent();
        int position =
                in.getIntExtra("example.huynguyen.ITEM_INDEX", -1);

        if (position > -1) {
            int pic = getImg(position);
            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            scaleImg(imgView, pic);
        }

    }

    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.img1;
            case 1: return R.drawable.img2;
            case 2: return R.drawable.img3;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        Point size = new Point();
        screen.getSize(size);
        int width = size.x;
        int height = size.y;

        int imgWidth = options.outWidth;
        int screenWidth = width;
        //screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);

    }
}
