package com.example.genmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.genmusic.bxhFragment.Baihatuathich;

import java.util.ArrayList;

public class PlayNhacActivity extends AppCompatActivity {
    Toolbar toolbarplaynhac;
    TextView txtTimesong,txtTotaltimesong;
    SeekBar sktime;
    ImageButton imgplay,imgreapeat,imgnext,impre,imgrandom;
    ViewPager viewPagerplaynhac;
    public static ArrayList<Baihatuathich> mangbaihat=new ArrayList<>();
    public static ViewPagerPlaylistnhac adapternhac;
    Fragment_Dia_nhac fragment_dia_nhac;
    Fragment_Play_DanhsachbaiHat fragment_play_danhsachbaiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        init();
        GetDataFromIntent();

    }

    private void GetDataFromIntent() {
        Intent intent=getIntent();
        mangbaihat.clear();
        if(intent!=null)
        {
            if(intent.hasExtra("cakhuc")){
                Baihatuathich baihatuathich=intent.getParcelableExtra("cakhuc");
                mangbaihat.add(baihatuathich);
            }
            if(intent.hasExtra("cacbaihat")){
                ArrayList<Baihatuathich> baihaArrayList=intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat=baihaArrayList;
            }
        }


    }

    private void init() {
        toolbarplaynhac=findViewById((R.id.toolbarplaynhac));
        txtTimesong=findViewById(R.id.textviewtimesong);
        txtTotaltimesong=findViewById(R.id.textviewtotaltimesong);
        sktime =findViewById(R.id.seekbarsong);
        imgplay=findViewById(R.id.imagebuttonplay);
        imgreapeat=findViewById(R.id.imagebuttonrepeat);
        imgnext=findViewById(R.id.imagebuttonnext);
        imgrandom=findViewById(R.id.imagebuttonsuffle);
        impre=findViewById(R.id.imagebuttonpre);
        viewPagerplaynhac=findViewById(R.id.viewpagerplaynhac);
        setSupportActionBar(toolbarplaynhac);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarplaynhac.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbarplaynhac.setTitleTextColor(Color.WHITE);
        fragment_dia_nhac=new Fragment_Dia_nhac();
        fragment_play_danhsachbaiHat=new Fragment_Play_DanhsachbaiHat();
        adapternhac= new ViewPagerPlaylistnhac((getSupportFragmentManager()));
        adapternhac.AddFragment(fragment_play_danhsachbaiHat);
        adapternhac.AddFragment(fragment_dia_nhac);

        viewPagerplaynhac.setAdapter(adapternhac);

    }
}