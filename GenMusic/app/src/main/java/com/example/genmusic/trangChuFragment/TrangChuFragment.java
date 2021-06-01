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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.genmusic.MainActivity;
import com.example.genmusic.NewsActivity;
import com.example.genmusic.R;
import com.example.genmusic.theLoaiFragment.Album;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class TrangChuFragment extends Fragment {

    private ViewPager viewPagerOfHome;
    private CircleIndicator circleIndicator;
    private SongImageAdapter songImageAdapter;
    private RecyclerView rcvHomeContent;
    private HomeContentAdapter homeContentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trang_chu_fragment, container, false);

        viewPagerOfHome = view.findViewById(R.id.vpgSongImage);
        circleIndicator = view.findViewById(R.id.ciSongImage);
        rcvHomeContent = view.findViewById(R.id.rcv_HomeContent);
        homeContentAdapter = new HomeContentAdapter(this.getContext());


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        rcvHomeContent.setLayoutManager(linearLayoutManager);
        homeContentAdapter.setData(getListHomeContent());
        rcvHomeContent.setAdapter(homeContentAdapter);

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

    private List<HomeContent> getListHomeContent() {
        List<HomeContent> listHomeContent = new ArrayList<>();
        List<Album> listAlbum = new ArrayList<>();
        listAlbum.add(new Album(R.drawable.album_batnhiem, "Bất Nhiễm OST"));
        listAlbum.add(new Album(R.drawable.album_changes, "Changes"));
        listAlbum.add(new Album(R.drawable.album_fearless, "Fearless"));
        listAlbum.add(new Album(R.drawable.album_chiconlaiquakhu, "Chỉ còn lại quá khứ"));
        listAlbum.add(new Album(R.drawable.album_batnhiem, "Bất Nhiễm OST"));
        listAlbum.add(new Album(R.drawable.album_changes, "Changes"));
        listAlbum.add(new Album(R.drawable.album_fearless, "Fearless"));
        listAlbum.add(new Album(R.drawable.album_chiconlaiquakhu, "Chỉ còn lại quá khứ"));

        listHomeContent.add(new HomeContent("Có thể bạn muốn nghe", listAlbum));
        listHomeContent.add(new HomeContent("Album nổi bật", listAlbum));
        listHomeContent.add(new HomeContent("Tin tức hot", listAlbum));
        listHomeContent.add(new HomeContent("Top BXH", listAlbum));

        return listHomeContent;
    }
}
