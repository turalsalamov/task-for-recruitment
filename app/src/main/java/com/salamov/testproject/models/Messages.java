package com.salamov.testproject.models;

public class Messages {

    private int messageFrom;
    private String message;
    private int photo;

    public Messages(int messageFrom, String message, int photo) {
        this.messageFrom = messageFrom;
        this.message = message;
        this.photo = photo;

    }

    public int getMessageFrom() {
        return messageFrom;
    }

    public String getMessage() {
        return message;
    }

    public int getPhoto() {
        return photo;
    }
}
