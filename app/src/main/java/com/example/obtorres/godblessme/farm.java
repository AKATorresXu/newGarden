package com.example.obtorres.godblessme;

public class farm
{




    private String name;
    private String date;
    private String content;
    private int bookable;
    private double price;
    private int imageID;

    public String getName() {
        return name;
    }

    public int getImageID() {
        return imageID;
    }
    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public int getBookable() {
        return bookable;
    }

    public double getPrice() {
        return price;
    }
    public farm(String name, String date, String content, int bookable, double price, int imageID) {
        this.name = name;
        this.date = date;
        this.content = content;
        this.bookable = bookable;
        this.price = price;
        this.imageID = imageID;
    }


}
