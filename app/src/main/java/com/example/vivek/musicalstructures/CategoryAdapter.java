package com.example.vivek.musicalstructures;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

// {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
// each list item based on a data source which is a list of {@link Music} objects.
public class CategoryAdapter extends FragmentPagerAdapter {

    // context of the app
    private Context mContext;

    // Create a new {@link CategoryAdapter} object.
    // @param context is the context of the app
    // @param fm is the fragment manager that will keep each fragment's state in the adapter across swipes.
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // Return the {@link Fragment} that should be displayed for the given page number.
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MyMusicFragment();
        } else if (position == 1) {
            return new ArtistFragment();
        } else {
            return new UpdatesFragment();
        }
    }

    // return the total number of pages
    @Override
    public int getCount() {
        return 3;
    }

    // sequence of those pages
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.mymusic);
        } else if (position == 1) {
            return mContext.getString(R.string.artist);
        } else {
            return mContext.getString(R.string.update);
        }
    }
}