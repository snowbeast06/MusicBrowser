package com.example.android.musicbrowser;

/**
 * Created by genetrinks on 2/11/18.
 */

public class Album {

    private String mArtist;
    private String mAlbum;

    // constructor
    public Album(String artist, String album) {
        mArtist = artist;
        mAlbum = album;
    }

    //Getters
    public String getArtist() {
        return mArtist;
    }
    public String getAlbum() {
        return mAlbum;
    }
}
