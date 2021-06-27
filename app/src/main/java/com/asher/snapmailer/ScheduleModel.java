package com.asher.snapmailer;

public class ScheduleModel {

    public String name;
    public String dateTime;
    public String time;
    public int image;


    public ScheduleModel(String name, String daTetime, String time, int image) {
        this.name = name;
        this.dateTime = dateTime;
        this.time = time;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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
}
