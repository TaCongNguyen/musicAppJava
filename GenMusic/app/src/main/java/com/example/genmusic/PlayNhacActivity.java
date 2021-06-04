package com.example.genmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.genmusic.bxhFragment.Baihatuathich;

import java.util.ArrayList;

public class PlayNhacActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        Intent intent=getIntent();
        if(intent.hasExtra("cakhuc")){
            Baihatuathich baihatuathich=intent.getParcelableExtra("cakhuc");
            Toast.makeText(this,baihatuathich.getTenbaihat(),Toast.LENGTH_SHORT).show();
        }
        if(intent.hasExtra("cacbaihat")){
            ArrayList<Baihatuathich> mangbaihat=intent.getParcelableArrayListExtra("cacbaihat");
            for(int i=0;i<mangbaihat.size();i++)
            {
                Log.d("BBB",mangbaihat.get(i).getTenbaihat());
            }
        }
    }
}