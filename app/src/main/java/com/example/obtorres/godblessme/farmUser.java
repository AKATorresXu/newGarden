package com.example.obtorres.godblessme;

import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

public class farmUser extends LitePalSupport{

    private int id;
    private String name;
    private String password;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    private int gender;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
