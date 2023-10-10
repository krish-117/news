package com.example.news;

public class ModelCategories {
    String Title;
    int img;

    public ModelCategories(String title, int img) {
        Title = title;
        this.img = img;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
