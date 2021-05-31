package com.example.genmusic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.R;
import com.example.genmusic.theLoaiFragment.TheLoai;
import com.example.genmusic.theLoaiFragment.TheLoaiAdapter;

import java.util.ArrayList;
import java.util.List;

public class BangXepHangFragment extends Fragment {
    private View view;
    private RecyclerView rcvChart;
    private SongAdapter songAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bxh_fragment, container, false);
        songAdapter =new SongAdapter();
        rcvChart=view.findViewById(R.id.rcvChart);
        songAdapter.setData(getListSong());
        rcvChart.setAdapter(songAdapter);

        return view;
    }

    private List<Song> getListSong() {
        ArrayList<Song> list = new ArrayList<>();
        list.add(new Song(R.drawable.music_empty, "Em của ngày hôm qua","Sơn Tùng MTP",R.drawable.ic_more_horiz_black_24dp));
        list.add(new Song(R.drawable.music_empty, "Em của ngày hôm qua","Sơn Tùng MTP",R.drawable.ic_more_horiz_black_24dp));
        list.add(new Song(R.drawable.music_empty, "Em của ngày hôm qua","Sơn Tùng MTP",R.drawable.ic_more_horiz_black_24dp));
        list.add(new Song(R.drawable.music_empty, "Em của ngày hôm qua","Sơn Tùng MTP",R.drawable.ic_more_horiz_black_24dp));
        list.add(new Song(R.drawable.music_empty, "Em của ngày hôm qua","Sơn Tùng MTP",R.drawable.ic_more_horiz_black_24dp));
        list.add(new Song(R.drawable.music_empty, "Em của ngày hôm qua","Sơn Tùng MTP",R.drawable.ic_more_horiz_black_24dp));

        return list;
    }

}
