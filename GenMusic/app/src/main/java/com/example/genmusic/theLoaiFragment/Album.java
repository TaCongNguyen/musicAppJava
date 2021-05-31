package com.example.genmusic.theLoaiFragment;

public class Album {

    private int imgId;
    private String TieuDe;

    public Album(int imgId, String tieuDe) {
        this.imgId = imgId;
        TieuDe = tieuDe;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String tieuDe) {
        TieuDe = tieuDe;
    }
}
