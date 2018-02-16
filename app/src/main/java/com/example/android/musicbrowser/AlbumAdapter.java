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

public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(Activity context, ArrayList<Album> albums) {
        super(context, 0, albums);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the album_list_ListView
        Album currentAlbum = getItem(position);

        // Find the TextView in the song_item.xml layout with the ID Album
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.album_item_name_TextView);

        // Get the Album from the currentSong object and
        // set this text on the name TextView
        albumTextView.setText(currentAlbum.getAlbum());

        // Find the TextView in the song_item.xml layout with the ID Artist
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.albumArtist);

        // Get the artist from the currentSong object and
        // set this text on the name TextView
        artistTextView.setText(currentAlbum.getArtist());

        //return the view
        return listItemView;
    }
}
