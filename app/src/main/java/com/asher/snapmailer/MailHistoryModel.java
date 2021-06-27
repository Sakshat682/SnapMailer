package com.asher.snapmailer;

public class MailHistoryModel {

    public  String name;
    public  String time;
    public  int image;
    public boolean isIncoming;

    public MailHistoryModel(String name, String time, int image, boolean isIncoming) {
        this.name = name;
        this.time = time;
        this.image = image;
        this.isIncoming = isIncoming;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isIncoming() {
        return isIncoming;
    }

    public void setIncoming(boolean incoming) {
        isIncoming = incoming;
    }
}
