package com.example.android.musicbrowser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {
    // we're going to create an array to hold the number words
    ArrayList<Song> songs = new ArrayList<Song>();
    String albumName;
    String artistName;
    String songName;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        Bundle bundle = getIntent().getExtras();
        albumName = bundle.getString("album_name");
        artistName = bundle.getString("artist_name");
        songName = bundle.getString("song_name");
        position = bundle.getInt("position");

        // now we'll fill in the array  Album 0 is Purple Rain...
        switch (albumName) {
            case "Purple Rain": {
                songs.add(new Song(artistName, albumName, "Lets Go Crazy"));
                songs.add(new Song(artistName, albumName, "Take Me With U"));
                songs.add(new Song(artistName, albumName, "The Beautiful Ones"));
                songs.add(new Song(artistName, albumName, "Computer Blue"));
                songs.add(new Song(artistName, albumName, "Darling Nikki"));
                songs.add(new Song(artistName, albumName, "When Doves Cry"));
                songs.add(new Song(artistName, albumName, "I Would Die 4 U"));
                songs.add(new Song(artistName, albumName, "Baby Im a Star"));
                songs.add(new Song(artistName, albumName, "Purple Rain"));
                break;
            }

            case "Born In The USA": {
                songs.add(new Song(artistName, albumName, "Born in the USA"));
                songs.add(new Song(artistName, albumName, "Cover Me"));
                songs.add(new Song(artistName, albumName, "Darlington County"));
                songs.add(new Song(artistName, albumName, "Working on the Highway"));
                songs.add(new Song(artistName, albumName, "Downbound Train"));
                songs.add(new Song(artistName, albumName, "I'm on fire"));
                songs.add(new Song(artistName, albumName, "No Surrender"));
                songs.add(new Song(artistName, albumName, "Bobby Jean"));
                songs.add(new Song(artistName, albumName, "I'm Going Down"));
                songs.add(new Song(artistName, albumName, "Glory Days"));
                songs.add(new Song(artistName, albumName, "Dancing in the Dark"));
                songs.add(new Song(artistName, albumName, "My Hometown"));

                break;
            }

            case "The Unforgettable Fire": {
                songs.add(new Song(artistName, albumName, "A Sort of Homecoming"));
                songs.add(new Song(artistName, albumName, "Pride (in the name of love)"));
                songs.add(new Song(artistName, albumName, "Wire"));
                songs.add(new Song(artistName, albumName, "The Unforgettable Fire"));
                songs.add(new Song(artistName, albumName, "Promenade"));
                songs.add(new Song(artistName, albumName, "4th of July"));
                songs.add(new Song(artistName, albumName, "Bad"));
                songs.add(new Song(artistName, albumName, "Indian Summer Sky"));
                songs.add(new Song(artistName, albumName, "Elvis Presley and America"));
                songs.add(new Song(artistName, albumName, "MLK"));
                break;
            }

            case "1984": {
                songs.add(new Song(artistName, albumName, "1984"));
                songs.add(new Song(artistName, albumName, "Jump"));
                songs.add(new Song(artistName, albumName, "Panama"));
                songs.add(new Song(artistName, albumName, "Top Jimmy"));
                songs.add(new Song(artistName, albumName, "Drop Dead Legs"));
                songs.add(new Song(artistName, albumName, "Hot for Teacher"));
                songs.add(new Song(artistName, albumName, "I'll Wait"));
                songs.add(new Song(artistName, albumName, "Girl Gone Bad"));
                songs.add(new Song(artistName, albumName, "House of Pain"));
                break;
            }

            case "Ride The Lightning": {
                songs.add(new Song(artistName, albumName, "Fight Fire With Fire"));
                songs.add(new Song(artistName, albumName, "Ride The Lightning"));
                songs.add(new Song(artistName, albumName, "For Whom the Bell Tolls"));
                songs.add(new Song(artistName, albumName, "Fade To Black"));
                songs.add(new Song(artistName, albumName, "Trapped Under Ice"));
                songs.add(new Song(artistName, albumName, "Escape"));
                songs.add(new Song(artistName, albumName, "Creeping Death"));
                songs.add(new Song(artistName, albumName, "The Call of Ktulu"));
                break;
            }

            case "Diamond Life": {
                songs.add(new Song(artistName, albumName, "Smooth Operator"));
                songs.add(new Song(artistName, albumName, "Your Love is King"));
                songs.add(new Song(artistName, albumName, "Hang On To Your Love"));
                songs.add(new Song(artistName, albumName, "Frankies First Affair"));
                songs.add(new Song(artistName, albumName, "When Am I Going To Make A Living"));
                songs.add(new Song(artistName, albumName, "Cherry Pie"));
                songs.add(new Song(artistName, albumName, "Sally"));
                songs.add(new Song(artistName, albumName, "I Will Be Your Friend"));
                songs.add(new Song(artistName, albumName, "Why Cant We Live Together"));
                break;
            }
        }

        // create a wordadapter whose data source is the arraylist of type Word
        SongAdapter adapter = new SongAdapter(this, songs);

        // get a reference to the listview and add the adapter to the listview
        ListView listView = (ListView) findViewById(R.id.album_list_ListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg) {
                Intent nowPlayingIntent = new Intent(AlbumActivity.this, NowPlayingActivity.class);
                Song currentSong = songs.get(position);

                Bundle bundle = new Bundle();
                bundle.putString("album_name", currentSong.getAlbum());
                bundle.putString("artist_name", currentSong.getArtist());
                bundle.putString("song_name", currentSong.getSongName());
                bundle.putInt("position", position);

                nowPlayingIntent.putExtras(bundle);
                startActivity(nowPlayingIntent);
            }
        });

        // set up the back to albums button, send them to the main activity to see the albums
        final Button backToAlbumsButton = findViewById(R.id.album_view_back_to_albums_button);
        backToAlbumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumIntent = new Intent(AlbumActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("album_name", albumName);
                bundle.putString("artist_name", artistName);
                bundle.putString("song_name", songName);
                bundle.putInt("position", position);
                albumIntent.putExtras(bundle);

                startActivity(albumIntent);
            }
        });

        // set up the back to Tracks button, send them back to the Album activity to see the tracks
        final Button nowPlayingButton = findViewById(R.id.album_view_now_playing_button);
        nowPlayingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowPlayingIntent = new Intent(AlbumActivity.this, NowPlayingActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("album_name", albumName);
                bundle.putString("artist_name", artistName);
                bundle.putString("song_name", songName);
                bundle.putInt("position", position);
                nowPlayingIntent.putExtras(bundle);

                startActivity(nowPlayingIntent);
            }
        });

    }
}

