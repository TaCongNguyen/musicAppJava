package com.example.genmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AsyncPlayer;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.genmusic.bxhFragment.Baihatuathich;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        StrictMode.ThreadPolicy policy=new  StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        init();
        GetDataFromIntent();
        eventClick();

    }

    private void eventClick() {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapternhac.getItem(1)!=null){
                    if (mangbaihat.size()>0){
                        fragment_dia_nhac.Playnhac(mangbaihat.get(0).getHinhbaihat());
                        handler.removeCallbacks(this);

                    }else {
                        handler.postDelayed(this,300);

                    }
                }
            }
        },500);
        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null){


                    if(mediaPlayer.isPlaying()){

                        mediaPlayer.pause();
                        imgplay.setImageResource(R.drawable.iconplay);
                    }
                    else {
                        mediaPlayer.start();
                        imgplay.setImageResource(R.drawable.iconpause);
                    }
                }

            }
        });
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
        fragment_dia_nhac= (Fragment_Dia_nhac) adapternhac.getItem(1);
        if(mangbaihat.size()>0)
        {
            getSupportActionBar().setTitle(mangbaihat.get(0).getTenbaihat());
            new  PlayMp3().execute(mangbaihat.get(0).getLinkbaihat());
            imgplay.setImageResource(R.drawable.iconpause);
        }

    }
    class PlayMp3 extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
            mediaPlayer=new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });

            mediaPlayer.setDataSource(baihat);
            mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
        txtTotaltimesong.setText((simpleDateFormat.format(mediaPlayer.getDuration())));
        sktime.setMax(mediaPlayer.getDuration());
    }
}