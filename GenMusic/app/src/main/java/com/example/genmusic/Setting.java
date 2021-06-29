package com.example.genmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.genmusic.trangChuFragment.FeedBack;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Setting extends AppCompatActivity {
    private Toolbar toolbarSetting;
    private AdView mAdView;
    private ImageView ivFeedBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        toolbarSetting = findViewById(R.id.toolbarSetting);

        setOnToolbar();

        //Quảng cáo
        MobileAds.initialize(Setting.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

                mAdView = findViewById(R.id.adView);
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
            }
        });

        ivFeedBack = findViewById(R.id.imvFeedBack);

        ivFeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, FeedBack.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setOnToolbar() {
        setSupportActionBar(toolbarSetting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cài đặt");
        toolbarSetting.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}