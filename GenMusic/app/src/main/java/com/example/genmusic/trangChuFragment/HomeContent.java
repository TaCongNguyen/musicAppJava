package com.example.genmusic.trangChuFragment;

import com.example.genmusic.theLoaiFragment.Album;

import java.util.List;

public class HomeContent {
    private String nameContent;
    private List<Album> hotAlbums;

    public HomeContent(String nameContent, List<Album> hotAlbums) {
        this.nameContent = nameContent;
        this.hotAlbums = hotAlbums;
    }

    public String getNameContent() {
        return nameContent;
    }

    public void setNameContent(String nameContent) {
        this.nameContent = nameContent;
    }

    public List<Album> getHotAlbums() {
        return hotAlbums;
    }

    public void setHotAlbums(List<Album> hotAlbums) {
        this.hotAlbums = hotAlbums;
    }
}
