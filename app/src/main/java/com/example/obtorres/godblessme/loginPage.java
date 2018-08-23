package com.example.obtorres.godblessme;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class loginPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        LitePal.getDatabase();



        final EditText username=(EditText) findViewById(R.id.edit_login_username);
        final EditText pwd=(EditText) findViewById(R.id.edit_login_pwd);


        Button submit=(Button) findViewById(R.id.btn_login_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* List<farmUser> farmUsers= LitePal.where("name=?",username.getText().toString()).find(farmUser.class);
                for(farmUser farmUser1:farmUsers)
                {*/if(username.getText().toString().isEmpty()==false&&pwd.getText().toString().isEmpty()==false) {
                    List<farmUser> farmUsers=LitePal.where("name=?",username.getText().toString()).find(farmUser.class);
                    if(farmUsers.isEmpty()==false) {
                        for (farmUser farmUser_new : farmUsers) {//Toast.makeText(v.getContext(), farmUser_new.getPassword(), Toast.LENGTH_SHORT).show();
                            if(pwd.getText().toString().trim().equals(farmUser_new.getPassword())) {//此处不能用==比较，因为两个string对象不同地址

                                Toast.makeText(v.getContext(), "登录成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(loginPage.this, loginMainPage.class);
                                intent.putExtra("username", username.getText().toString());
                                startActivity(intent);
                                break;
                            }
                            else {
                               Toast.makeText(v.getContext(), "密码不正确", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else {
                        Toast.makeText(v.getContext(), "该用户不存在", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(v.getContext(),"用户名或密码不能为空白"  ,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
