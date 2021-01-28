package com.salamov.testproject.models;

import java.util.ArrayList;

public class Inboxes {

    private String withWhom;
    private ArrayList<Messages> messages;
    private int senderPP;
    private int hostPP;
    private boolean active;

    public Inboxes(String withWhom, ArrayList<Messages> messages, int senderPP, int hostPP, boolean active) {
        this.withWhom = withWhom;
        this.messages = messages;
        this.senderPP = senderPP;
        this.hostPP = hostPP;
        this.active = active;
    }

    public String getWithWhom() {
        return withWhom;
    }

    public ArrayList<Messages> getMessages() {
        return messages;
    }

    public int getSenderPP() {
        return senderPP;
    }

    public int getHostPP() {
        return hostPP;
    }

    public boolean isActive() {
        return active;
    }
}
