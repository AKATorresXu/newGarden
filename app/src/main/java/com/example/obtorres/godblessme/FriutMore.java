package com.example.obtorres.godblessme;

import org.litepal.crud.LitePalSupport;

public class FriutMore extends LitePalSupport {

    private int id;
    private String name;
    private String family;
    private int imageID;



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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }


}
