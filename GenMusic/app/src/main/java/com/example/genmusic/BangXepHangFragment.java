package com.example.genmusic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.genmusic.R;
import com.example.genmusic.theLoaiFragment.PlaylistAdapter;
import com.example.genmusic.theLoaiFragment.TheLoai;
import com.example.genmusic.theLoaiFragment.TheLoaiAdapter;

import java.util.ArrayList;
import java.util.List;

public class BangXepHangFragment extends Fragment {
    private View view;
    private RecyclerView rcvChart;
    private SongAdapter songAdapter;
    private PlaylistAdapter playlistAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bxh_fragment, container, false);

        rcvChart= view.findViewById(R.id.rcvChart);

//        songAdapter =new SongAdapter();
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
//
//        rcvChart.setFocusable(false);
//
//        songAdapter.setData(getListSong());
//        rcvChart.setAdapter(songAdapter);

        hienthiBaiHat();


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


    private void hienthiBaiHat() {
        playlistAdapter = new PlaylistAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        rcvChart.setLayoutManager(linearLayoutManager);

        rcvChart.setFocusable(false);
        rcvChart.setNestedScrollingEnabled(false);

        playlistAdapter.setData(getListData());
        rcvChart.setAdapter(playlistAdapter);

    }

    private List<BaiHat> getListData() {

        ArrayList<BaiHat> list = new ArrayList<>();
        list.add(new BaiHat(R.drawable.baihat_buocquamuacodon, "Bước qua mùa cô đơn","Vũ"));
        list.add(new BaiHat(R.drawable.baihat_buocquamuacodon, "Bước qua mùa cô đơn","Vũ"));
        list.add(new BaiHat(R.drawable.baihat_buocquamuacodon, "Bước qua mùa cô đơn","Vũ"));
        list.add(new BaiHat(R.drawable.baihat_buocquamuacodon, "Bước qua mùa cô đơn","Vũ"));
        list.add(new BaiHat(R.drawable.baihat_mongphonhoa, "Mộng phồn hoa", "Hoàng Linh"));
        list.add(new BaiHat(R.drawable.baihat_mongphonhoa, "Mộng phồn hoa", "Hoàng Linh"));
        list.add(new BaiHat(R.drawable.baihat_mongphonhoa, "Mộng phồn hoa", "Hoàng Linh"));
        list.add(new BaiHat(R.drawable.baihat_mongphonhoa, "Mộng phồn hoa", "Hoàng Linh"));

        return list;
    }
}
