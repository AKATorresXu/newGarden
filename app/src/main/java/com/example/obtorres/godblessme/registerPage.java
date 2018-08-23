package com.example.obtorres.godblessme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class registerPage extends Activity {
    private RadioGroup radioGroup=null;
    private RadioButton radioButton_boy,radioButton_girl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        LitePal.getDatabase();



        final EditText username=(EditText) findViewById(R.id.edit_username);
        final EditText pwd=(EditText) findViewById(R.id.edit_pwd);
        radioGroup=(RadioGroup)findViewById(R.id.rdp_sex);
        radioButton_boy=(RadioButton)findViewById(R.id.select_male) ;
        radioButton_girl=(RadioButton)findViewById(R.id.select_female);
        Button submit=(Button) findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* List<farmUser> farmUsers= LitePal.where("name=?",username.getText().toString()).find(farmUser.class);
                for(farmUser farmUser1:farmUsers)
                {*/if(username.getText().toString().isEmpty()==false&&pwd.getText().toString().isEmpty()==false) {
                  List<farmUser> farmUsers=LitePal.where("name=?",username.getText().toString()).find(farmUser.class);
                    int id=2;
                    if(farmUsers.isEmpty()) {
                        farmUser farmUserSub = new farmUser();

                        switch (radioGroup.getCheckedRadioButtonId()){
                            case R.id.select_male:
                                id=1;
                                farmUserSub.setGender(id);
                                break;
                            case R.id.select_female:
                                id=0;
                                farmUserSub.setGender(id);
                                break;
                            default:
                                break;
                        }
                        if(id!=2) {
                            farmUserSub.setName(username.getText().toString());
                            farmUserSub.setPassword(pwd.getText().toString());
                            farmUserSub.save();
                            //}}
                            Toast.makeText(v.getContext(), "注册成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(registerPage.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(v.getContext(), "请选择性别", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(v.getContext(), "用户名已存在", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(v.getContext(),"用户名或密码不能为空白"  ,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
