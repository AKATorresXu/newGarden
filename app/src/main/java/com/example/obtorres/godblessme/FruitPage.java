package com.example.obtorres.godblessme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class FruitPage extends Activity {
    private List<FriutMore> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_page);
        LitePal.getDatabase();
        Intent i=getIntent();
        /*List<farmUser> fruitList1=LitePal.findAll(farmUser.class);*/
        //先从数据库中查找数据
        fruitList=LitePal.where("family=?",i.getStringExtra("family").toString()).find(FriutMore.class);//添加新表一定要更改数据库版本号！！！

        //再定义布局 顺序很重要，不然不能成功！！！
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.fruit_recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        //果园内容
        recyclerView.setLayoutManager(layoutManager);
        FruitMoreAdapter adapter=new FruitMoreAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
}
