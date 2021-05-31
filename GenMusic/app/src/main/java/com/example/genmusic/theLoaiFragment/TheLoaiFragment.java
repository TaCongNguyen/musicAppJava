package com.example.genmusic.theLoaiFragment;

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

import java.util.ArrayList;
import java.util.List;

public class TheLoaiFragment extends Fragment {

    //A. Khai báo biến
    private View view;
    private RecyclerView rcvAlbum, rcvTheLoai;
    private TheLoaiAdapter theLoaiAdapter;
    private AlbumAdapter albumAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.the_loai_fragment, container, false);

        //B. Ánh xạ view

        rcvAlbum = view.findViewById(R.id.rcvAlbum);
        rcvTheLoai = view.findViewById(R.id.rcvTheLoai);


        //C. Code xử lý

        setOnTheLoaiFragment();


        return view;
    }

    private void setOnTheLoaiFragment() {

        //Album
        albumAdapter = new AlbumAdapter();
        //Hiển thị dạng lưới (dạng grid)
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(requireContext(), 2);
        rcvAlbum.setLayoutManager(gridLayoutManager1);

        //Không cho recycleview cuộn
        rcvAlbum.setNestedScrollingEnabled(false);
        rcvAlbum.setFocusable(false);

        //truyền dữ liệu vào adapter và gọi adapter cho recycleview
        albumAdapter.setData(getListAlbum());
        rcvAlbum.setAdapter(albumAdapter);


        //Thể loại (tương tự album)
        theLoaiAdapter = new TheLoaiAdapter();
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(requireContext(), 2);
        rcvTheLoai.setLayoutManager(gridLayoutManager2);
        rcvTheLoai.setNestedScrollingEnabled(false);
        rcvTheLoai.setFocusable(false);

        theLoaiAdapter.setData(getListTheLoai());
        rcvTheLoai.setAdapter(theLoaiAdapter);
    }

    //Nhập data và trả về list album
    private List<Album> getListAlbum() {
        ArrayList<Album> list = new ArrayList<>();
        list.add(new Album(R.drawable.album_batnhiem, "Bất Nhiễm OST"));
        list.add(new Album(R.drawable.album_changes, "Changes"));
        list.add(new Album(R.drawable.album_fearless, "Fearless"));
        list.add(new Album(R.drawable.album_chiconlaiquakhu, "Chỉ còn lại quá khứ"));

        return list;
    }
    //Nhập data và trả về list album
    private List<TheLoai> getListTheLoai() {
        ArrayList<TheLoai> list = new ArrayList<>();
        list.add(new TheLoai(R.drawable.the_loai_edm, "EDM"));
        list.add(new TheLoai(R.drawable.the_loai_hiphop, "Hip Hop"));
        list.add(new TheLoai(R.drawable.the_loai_indie, "Indie"));
        list.add(new TheLoai(R.drawable.the_loai_jazz, "Jazz"));
        list.add(new TheLoai(R.drawable.the_loai_latin, "Latin"));
        list.add(new TheLoai(R.drawable.the_loai_rock, "Rock"));
        list.add(new TheLoai(R.drawable.the_loai_rbviet, "R&B Việt"));

        return list;
    }
}
