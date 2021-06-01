package com.example.genmusic.trangChuFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.genmusic.MainActivity;
import com.example.genmusic.NewsActivity;
import com.example.genmusic.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class TrangChuFragment extends Fragment {

    private ViewPager viewPagerOfHome;
    private CircleIndicator circleIndicator;
    private SongImageAdapter songImageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trang_chu_fragment, container, false);

        viewPagerOfHome = view.findViewById(R.id.vpgSongImage);
        circleIndicator = view.findViewById(R.id.ciSongImage);

        //Xử lý slide show bài hát
        setOnSlideShow();


        Button btnMoNhac = view.findViewById(R.id.btnMoNhac);
        btnMoNhac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), NewsActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
    private void setOnSlideShow() {
        songImageAdapter = new SongImageAdapter(getContext(), getListSongImage());
        viewPagerOfHome.setAdapter(songImageAdapter);
        circleIndicator.setViewPager(viewPagerOfHome);
        songImageAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
    }

    private ArrayList<SongImage> getListSongImage() {
        ArrayList<SongImage> list = new ArrayList<>();

        list.add(new SongImage(R.drawable.khiemlon_hoangdungxoranger) );
        list.add(new SongImage(R.drawable.kimnguu_nhungkecungdau) );
        list.add(new SongImage(R.drawable.nhacmay_brayxhansara) );

        return list;
    }
}
