package com.example.vivek.musicalstructures;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MyMusicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.music_list, container, false);

        final ArrayList<Music> songs = new ArrayList<>();

        // creating a list of all songs, artists and albumarts
        songs.add(new Music(R.string.song1, R.string.artist1,
                R.drawable.soorma_antham));
        songs.add(new Music(R.string.song2, R.string.artist2,
                R.drawable.karhar));
        songs.add(new Music(R.string.song3, R.string.artist3,
                R.drawable.dilgallan));
        songs.add(new Music(R.string.song4, R.string.artist4,
                R.drawable.halfgirl));
        songs.add(new Music(R.string.song5, R.string.artist5,
                R.drawable.harrymet));
        songs.add(new Music(R.string.song6, R.string.artist6,
                R.drawable.hindimed));
        songs.add(new Music(R.string.song7, R.string.artist7,
                R.drawable.mererashke));
        songs.add(new Music(R.string.song8, R.string.artist8,
                R.drawable.padmavat));
        songs.add(new Music(R.string.song9, R.string.artist9,
                R.drawable.sonu));
        songs.add(new Music(R.string.song10, R.string.artist10,
                R.drawable.sweetydrama));

        // Create an {@link MusicAdapter}, whose data source is a list of {@link Music song}s. The
        // adapter knows how to create list items for each item in the list.
        MusicAdapter adapter = new MusicAdapter(getActivity(), songs, R.color.backish);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // music_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link MusicAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Music} in the list.
        listView.setAdapter(adapter);

        // onClickListener for each item in listview resulting in start of player class
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyMusicFragment.this.getActivity(), player.class);
                switch (position) {
                    case 0:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 7:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 8:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                    case 9:
                        intent.putExtra("score", position);
                        startActivity(intent);
                        break;
                }
            }
        });

        return rootView;
    }
}
