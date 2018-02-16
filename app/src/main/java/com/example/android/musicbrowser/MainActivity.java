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

public class MainActivity extends AppCompatActivity {
    // we're going to create an array to hold the Albums
    ArrayList<Album> albums = new ArrayList<Album>();
    String albumName = "";
    String artistName = "";
    String songName = "";
    int position = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we passed in an intent bundle, lets grab the data
        Bundle bundle = getIntent().getExtras();
        if (!(bundle == null)) {

            albumName = bundle.getString("album_name");
            artistName = bundle.getString("artist_name");
            songName = bundle.getString("song_name");
            position = bundle.getInt("position");
        }

        // now we'll fill in the array
        albums.add(new Album("Prince", "Purple Rain"));
        albums.add(new Album("Bruce Springsteen", "Born In The USA"));
        albums.add(new Album("U2", "The Unforgettable Fire"));
        albums.add(new Album("Van Halen", "1984"));
        albums.add(new Album("Metallica", "Ride The Lightning"));
        albums.add(new Album("Sade", "Diamond Life"));

        // create a wordadapter whose data source is the arraylist of type Word
        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        // get a reference to the listview and add the adapter to the listview
        ListView listView = (ListView) findViewById(R.id.album_list_ListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg) {

                Intent albumIntent = new Intent(MainActivity.this, AlbumActivity.class);
                Album currentAlbum = albums.get(position);

                // there could be a situation where you've picked an album and but not a song,
                // and you go to now playing and it wont have a song to play...
                // not ideal, but intended behavior for now.
                Bundle bundle = new Bundle();
                bundle.putString("album_name", currentAlbum.getAlbum());
                bundle.putString("artist_name", currentAlbum.getArtist());
                bundle.putInt("position", position);

                albumIntent.putExtras(bundle);

                startActivity(albumIntent);
            }
        });

        // set up the back to Tracks button, send them back to the Album activity to see the tracks
        // There is a chance this state doesnt really make sense as a song may not have been chosen yet
        final Button nowPlayingButton = findViewById(R.id.main_jump_to_now_playing_button);
        nowPlayingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Main Activity", "Position " + position);

                Intent albumIntent = new Intent(MainActivity.this, NowPlayingActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("album_name", albumName);
                bundle.putString("artist_name", artistName);
                bundle.putString("song_name", songName);
                bundle.putInt("position", position);
                albumIntent.putExtras(bundle);

                startActivity(albumIntent);

            }
        });
    }
}

