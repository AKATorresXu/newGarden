/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * 该项目由TorresXu学习学习使用，不得转载，归属权由TorresXu所有。
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.obtorres.godblessme;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private List<farm> farmList=new ArrayList<>();
    private List<fruit> fruitList=new ArrayList<>();

    private RollPagerView mRollViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addpic();
        initFarms();
        initFruits();
        // LitePal.getDatabase();
     LitePal.getDatabase();
        saveData();
        //卡片式布局
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,1);
        //果园内容
        recyclerView.setLayoutManager(layoutManager);
        FarmAdapter adapter=new FarmAdapter(farmList);
        recyclerView.setAdapter(adapter);
        /*以下是水果内容*/
        RecyclerView recyclerView1=(RecyclerView)findViewById(R.id.recycler_menu);
        LinearLayoutManager layoutManager1=new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager1);
        FruitAdapter adapter1=new FruitAdapter(fruitList);
         recyclerView1.setAdapter(adapter1);

        Button register=(Button)findViewById(R.id.btn_register);
        Button login=(Button)findViewById(R.id.btn_login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,registerPage.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,loginPage.class);
                startActivity(intent);
            }
        });


    }
    private void saveData(){
       //保底数据
        for (int i=0;i<2;i++) {
            FriutMore friutMore = new FriutMore();
            friutMore.setName("苹果");
            friutMore.setFamily("apple");
            friutMore.setImageID(R.drawable.apple1);
            friutMore.save();
            FriutMore friutMore1 = new FriutMore();
            friutMore1.setName("草莓");
            friutMore1.setFamily("berry");
            friutMore1.setImageID(R.drawable.berry);
            friutMore1.save();
            FriutMore friutMore2 = new FriutMore();
            friutMore2.setName("樱桃");
            friutMore2.setFamily("cherry");
            friutMore2.setImageID(R.drawable.cherry1);
            friutMore2.save();
            FriutMore friutMore3 = new FriutMore();
            friutMore3.setName("葡萄");
            friutMore3.setFamily("grape");
            friutMore3.setImageID(R.drawable.grape);

        friutMore3.save(); }
    }
    private void addpic()
    {
        mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(2000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.parseColor("#7BA23F"),Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.fruitins1,
                R.drawable.fruitins2,
                R.drawable.fruitins3,
                R.drawable.fruitins4,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }

    private void initFarms() {

        for (int i = 0; i < 2; i++) {
            farm jinkang = new farm("King's Garden", "20180504", "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!", 1, 189.00, R.drawable.farm1);
            farmList.add(jinkang);
            farm dafu = new farm("Torres's Garden", "20180504", "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!", 1, 189.00, R.drawable.farm2);
            farmList.add(dafu);
            farm zhaocai = new farm("Jake's Garden", "20180504", "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!", 1, 189.00, R.drawable.farm3);
            farmList.add(zhaocai);
            farm zhuangzhuang = new farm("Sheldon's Garden", "20180504", "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!", 1, 189.00, R.drawable.farm4);
            farmList.add(zhuangzhuang);
            farm xinjiapuo = new farm("DaYe's Garden", "20180504", "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!", 1, 189.00, R.drawable.farm5);
            farmList.add(xinjiapuo);
            farm qiange = new farm("Your Garden", "20180504", "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!" +
                    "This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!This is a great place,you can have a lot fun here!", 1, 189.00, R.drawable.farm6);
            farmList.add(qiange);
        }
    }
    private void initFruits() {
        for(int i=0; i<1;i++){

            fruit jiangguo=new fruit("浆果类","berry",R.drawable.strawberry);
            fruitList.add(jiangguo);
            fruit heguo=new fruit("核果类","cherry",R.drawable.cherry);
            fruitList.add(heguo);
            fruit renguo=new fruit("仁果类","apple",R.drawable.apple);
            fruitList.add(renguo);
            fruit putao=new fruit("葡萄类","grape",R.drawable.grapes);
            fruitList.add(putao);
        }
    }
}
