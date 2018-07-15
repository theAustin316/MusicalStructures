package com.example.vivek.musicalstructures;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Grid_adapter extends BaseAdapter {

    private Context mContext;

    public Integer thumbs[] = {R.drawable.karhar, R.drawable.uber, R.drawable.zing, R.drawable.michael, R.drawable.kaala, R.drawable.alltime,
            R.drawable.dilgallan, R.drawable.mererashke};

    public Grid_adapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return thumbs.length;
    }

    @Override
    public Object getItem(int position) {
        return thumbs[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(thumbs[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(450, 450));
        return imageView;
    }
}
