package com.example.genmusic;

public class Song {
    private int imgId;
    private String title;
    private String Description;
    private int imgMenu;

    public Song(int imgId, String title, String description, int imgMenu) {
        this.imgId = imgId;
        this.title = title;
        Description = description;
        this.imgMenu = imgMenu;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImgMenu() {
        return imgMenu;
    }

    public void setImgMenu(int imgMenu) {
        this.imgMenu = imgMenu;
    }

}


