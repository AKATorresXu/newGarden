package com.example.obtorres.godblessme;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class showContent extends Activity {
    private String name;
    private String date;
    private String content;
    private double price;
    private int imageID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_show_content);//

        Intent i=getIntent();
        TextView txt_title=(TextView)findViewById(R.id.txt_title);
        txt_title.setText(i.getStringExtra("name"));
        TextView txt_date=(TextView)findViewById(R.id.txt_date);
        txt_date.setText(i.getStringExtra("date"));
        TextView txt_content=(TextView)findViewById(R.id.txt_content);
        txt_content.setText(i.getStringExtra("content"));
        TextView txt_price=(TextView)findViewById(R.id.txt_price);
        price=i.getDoubleExtra("price",price);
        txt_price.setText("¥"+String.valueOf(price));
        ImageView view_pic=(ImageView)findViewById(R.id.content_image);
        view_pic.setImageResource(i.getIntExtra("imageID",123));//取int型数据值，第二个参数是当没有取到值时备用的值自己设置；
        this.imageID=i.getIntExtra("pic",123);
        /*if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }*/


    }
}
