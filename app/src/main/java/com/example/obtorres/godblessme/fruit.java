package com.example.obtorres.godblessme;


public class fruit {
    private String name;



    private String family;
    private int imageID;
    public String getName() {
        return name;
    }
    public String getFamily() {
        return family;
    }

    public int getImageID() {
        return imageID;
    }



    public fruit(String name,String family, int imageID) {
        this.name = name;
        this.imageID = imageID;
        this.family=family;
    }

}
