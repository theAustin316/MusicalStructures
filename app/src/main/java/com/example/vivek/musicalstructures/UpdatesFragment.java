package com.example.vivek.musicalstructures;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class UpdatesFragment extends Fragment {

    GridView grids;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.updatecard, container, false);

        grids = rootView.findViewById(R.id.grid_view);
        grids.setAdapter(new Grid_adapter(getActivity()));

        grids.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wynk.com"));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
