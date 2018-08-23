package com.example.obtorres.godblessme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import org.litepal.LitePal;

import java.util.List;

public class loginMainPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main_page);
        LitePal.getDatabase();

        Intent i = getIntent();
        String user = i.getStringExtra("username");
        List<farmUser> farmUsers = LitePal.where("name=?", user).find(farmUser.class);

        TextView txt_title = (TextView) findViewById(R.id.txt_user2);
        TextView txt_gender = (TextView) findViewById(R.id.user_gender);
        txt_title.setText(user);
        for (farmUser farmUser1 : farmUsers) {
            if (farmUser1.getGender() == 1) {
                txt_gender.setText("先生");
            } else {
                txt_gender.setText("女士");

            }
        }

    }



}