package com.example.android.musicbrowser;

/**
 * Created by genetrinks on 2/11/18.
 */

public class Song {

    private String mArtist;
    private String mAlbum;
    private String mSongName;

    // constructor
    public Song(String artist, String album, String songName ) {
        mArtist = artist;
        mAlbum = album;
        mSongName = songName;
    }

    //Getters
    public String getArtist() {
        return mArtist;
    }
    public String getAlbum() {
        return mAlbum;
    }
    public String getSongName() {
        return mSongName;
    }
}
