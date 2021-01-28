package com.salamov.testproject.models;

public class ItemsAtVerticalAdapter {

    private int image;
    private String name;
    private String message;
    private String date;
    private boolean active;

    public ItemsAtVerticalAdapter(int image, String name, String message, String date, boolean active) {
        this.image = image;
        this.name = name;
        this.message = message;
        this.date = date;
        this.active = active;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public boolean isActive() {
        return active;
    }
}
