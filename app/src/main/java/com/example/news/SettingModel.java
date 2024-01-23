package com.example.news;

public class SettingModel {
    int img;
    String name;

    public int getImg() {
        return img;
    }

    public SettingModel(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
