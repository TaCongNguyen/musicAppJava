package com.example.genmusic.caNhanFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.genmusic.R;

public class CaNhanFragment extends Fragment {

    private Context context;
    RelativeLayout RLayoutBaiHatYeuThich, RLayoutPlaylistYeuThich, RlayoutBaiHatDaTai, RLayoutAlbumYeuThich;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ca_nhan_fragment, container, false);

        RLayoutBaiHatYeuThich = view.findViewById(R.id.RLayoutBaiHatYeuThich);
        RlayoutBaiHatDaTai = view.findViewById(R.id.RLayoutBaiHatDaTai);
        RLayoutAlbumYeuThich = view.findViewById(R.id.RLayoutAlbumYeuThich);
        RLayoutPlaylistYeuThich = view.findViewById(R.id.RLayoutPlaylistYeuThich);

        context = container.getContext();

        RLayoutBaiHatYeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BaiHatYeuThich.class);
                startActivity(intent);
            }
        });

        RLayoutAlbumYeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlbumYeuThichActivity.class);
                startActivity(intent);
            }
        });

        RLayoutPlaylistYeuThich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TheLoaiYeuThichActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
