package com.lpaina.musicians;

import android.graphics.drawable.Drawable;

import java.util.List;

public class Musician {
    private String name;
    private List<String> styles;
    private int albumsNum;
    private int songsNum;
    private String biography;
    private Drawable photo;

    public Musician(String name, List<String> styles, int albumsNum, int songsNum,
                    String biography, Drawable photo) {
        this.name = name;
        this.styles = styles;
        this.albumsNum = albumsNum;
        this.songsNum = songsNum;
        this.biography = biography;
        this.photo = photo;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public int getAlbumsNum() {
        return albumsNum;
    }

    public void setAlbumsNum(int albumsNum) {
        this.albumsNum = albumsNum;
    }

    public int getSongsNum() {
        return songsNum;
    }

    public void setSongsNum(int songsNum) {
        this.songsNum = songsNum;
    }

    public String getStyleString() {
        if (styles == null || styles.isEmpty()) {
            return "";
        }

        String separator = ", ";
        StringBuilder builder = new StringBuilder();
        for (String style : styles) {
            builder.append(style).append(separator);
        }
        return builder.substring(0, builder.length() - separator.length());
    }
}
