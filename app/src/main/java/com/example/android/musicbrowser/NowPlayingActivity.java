package com.example.android.musicbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by genetrinks on 2/12/18.
 */

public class NowPlayingActivity extends AppCompatActivity {

    Boolean playing = true;
    String albumName = "";
    String artistName = "";
    String songName = "";
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // if we passed in an intent bundle, lets grab the data
        Bundle bundle = getIntent().getExtras();
        if (!(bundle == null)) {

            albumName = bundle.getString("album_name");
            artistName = bundle.getString("artist_name");
            songName = bundle.getString("song_name");
            position = bundle.getInt("position");
        }

        // populate the imageView and textviews
        ImageView albumImageImageView = findViewById(R.id.now_playing_album_ImageView);

        switch (albumName) {
            case "Purple Rain": {
                albumImageImageView.setImageResource(R.drawable.purplerain);
                break;
            }
            case "Born In The USA": {
                albumImageImageView.setImageResource(R.drawable.bornintheusa);
                break;
            }
            case "The Unforgettable Fire": {
                albumImageImageView.setImageResource(R.drawable.unforgettablefire);
                break;
            }
            case "1984": {
                albumImageImageView.setImageResource(R.drawable.album1984);
                break;
            }
            case "Ride The Lightning": {
                albumImageImageView.setImageResource(R.drawable.ridethelightning);
                break;
            }
            case "Diamond Life": {
                albumImageImageView.setImageResource(R.drawable.diamondlife);
                break;
            }
            default: {
                //  set a generic image or nothing if there is no album chosen
            };
        }

        TextView songNameTextView = findViewById(R.id.now_playing_song_name_TextView);
        songNameTextView.setText(songName);

        TextView artistNameTextView = findViewById(R.id.now_playing_artist_name_TextView);
        artistNameTextView.setText(artistName);

        TextView albumNameTextView = findViewById(R.id.now_playing_album_name_TextView);
        albumNameTextView.setText(albumName);

        // set up the Play button to just toggle
        final ImageView playButton = findViewById(R.id.play_pause_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playing = !(playing);
                if (playing) {
                    playButton.setImageResource(R.drawable.ic_play);
                } else {
                    playButton.setImageResource(R.drawable.ic_pause);
                }
            }
        });

        // set up the Play button to just toggle
        final ImageView reverseButton = findViewById(R.id.reverse_button);
        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        // set up the back to albums button, send them to the main activity to see the albums
        final Button backToAlbumsButton = findViewById(R.id.now_playing_back_to_albums);
        backToAlbumsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumIntent = new Intent(NowPlayingActivity.this, MainActivity.class);

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
        final Button backToTracksButton = findViewById(R.id.now_playing_back_to_tracks);
        backToTracksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("NowPlaying Activity", "Position "+ position);

                Intent albumIntent = new Intent(NowPlayingActivity.this, AlbumActivity.class);

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
