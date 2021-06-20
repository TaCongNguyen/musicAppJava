package com.example.genmusic.caNhanFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.genmusic.R;

public class CaNhanFragment extends Fragment {

    private Context context;
    RelativeLayout RLayoutBaiHat;
    RelativeLayout RLayoutPlaylist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ca_nhan_fragment, container, false);

        RLayoutBaiHat = view.findViewById(R.id.RLayoutBaiHat);
        RLayoutPlaylist = view.findViewById(R.id.RLayoutPlaylist);

        context = container.getContext();

        RLayoutBaiHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BaiHatDaTai.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
