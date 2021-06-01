package com.example.genmusic.trangChuFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.genmusic.R;

import java.util.List;

public class SongImageAdapter extends PagerAdapter {

    private Context context;
    private List<SongImage> listSongImage;

    public SongImageAdapter(Context context, List<SongImage> listSongImage) {
        this.context = context;
        this.listSongImage = listSongImage;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull  ViewGroup container, int position) {

        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_slide_song, container, false);
        ImageView imgSongImage = view.findViewById(R.id.imgSongImage);

        SongImage songImage = listSongImage.get(position);
        if(songImage != null)
        {
            Glide.with(context).load(songImage.getID()).into(imgSongImage);
        }

        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if(listSongImage != null)
            return listSongImage.size();
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position,  Object object) {
        container.removeView((View) object);
    }
}
