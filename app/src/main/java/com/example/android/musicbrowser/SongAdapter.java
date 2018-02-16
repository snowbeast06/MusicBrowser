package com.example.android.musicbrowser;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by genetrinks on 2/11/18.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the album_list_ListView
        Song currentSong = getItem(position);

        // Find the TextView in the song_item.xml layout with the ID songname
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_item_name_TextView);

        // Get the song name from the currentSong object and
        // set this text on the name TextView
        songNameTextView.setText(currentSong.getSongName());

        // Find the TextView in the song_item.xml layout with the ID Album
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.song_item_album_TextView);

        // Get the Album from the currentSong object and
        // set this text on the name TextView
        albumTextView.setText(currentSong.getAlbum());

        // Find the TextView in the song_item.xml layout with the ID Artist
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.song_item_artist_TextView);

        // Get the artist from the currentSong object and
        // set this text on the name TextView
        artistTextView.setText(currentSong.getArtist());

        //return the view
        return listItemView;
    }
}
