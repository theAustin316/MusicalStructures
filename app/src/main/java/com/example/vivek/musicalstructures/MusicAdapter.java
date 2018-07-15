package com.example.vivek.musicalstructures;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// {@link MusicAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
// based on a data source, which is a list of {@link Music} objects.

public class MusicAdapter extends ArrayAdapter<Music> {

    // resource ID for setting background color
    private int colorId;

    public MusicAdapter(@NonNull Context context, ArrayList<Music> songs, int colorResource) {
        super(context, 0, songs);
        colorId = colorResource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Music} object located at this position in the list
        Music currentSong = getItem(position);

        ImageView icon = listItemView.findViewById(R.id.icon);

        // find the songName in list_item.xml with resource ID music
        TextView Song = listItemView.findViewById(R.id.music);
        if (currentSong.hasSongName()) {
            // If song name is available, display the provided name
            Song.setText(currentSong.getMusicName());
            // Make sure the view is visible
            Song.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the TextView
            Song.setVisibility(View.INVISIBLE);
            icon.setVisibility(View.INVISIBLE);
        }

        // find the artistName in list_item.xml with resource ID artist
        TextView Artist = listItemView.findViewById(R.id.artist);
        Artist.setText(currentSong.getArtistName());

        // find the albumImage in list_item.xml with resource id image
        ImageView imageView = listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentSong.getAlbumImage());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), colorId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout so that it can be shown in the ListView.
        return listItemView;
    }
}