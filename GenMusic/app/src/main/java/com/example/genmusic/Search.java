package com.example.genmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.genmusic.Service.MusicService;
import com.example.genmusic.bxhFragment.APIService;
import com.example.genmusic.bxhFragment.Baihatuathich;
import com.example.genmusic.bxhFragment.BaihatuathichAdapter;
import com.example.genmusic.bxhFragment.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.genmusic.MainActivity.isServiceConnected;
import static com.example.genmusic.MainActivity.musicService;

public class Search extends AppCompatActivity implements MinimizedPlayerFragment.ISendDataListener {

    private Toolbar toolbarSearch;
    private SearchView Search;
    private RecyclerView rcvSearchResult;
    private BaihatuathichAdapter baihatuathichAdapter;
    //service
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MusicService.MusicBinder musicBinder = (MusicService.MusicBinder) service;
            musicService = musicBinder.getMusicService();
            isServiceConnected = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            musicService = null;
            isServiceConnected = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolbarSearch = findViewById(R.id.toolbarSearch);
        rcvSearchResult = findViewById(R.id.rcvSearchResult);
        Search = findViewById(R.id.Search);

        setOnToolbar();
        Search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                setDataBaiHat(newText);
                return false;
            }
        });
    }

    private void setDataBaiHat(String tukhoa) {
        Log.d("search","tu khoa = " + tukhoa);
        Dataservice dataservice = APIService.getService();
        Call<List<Baihatuathich>> callback = dataservice.GetBaiHatSearched(tukhoa.trim());
        //Call<List<Baihatuathich>> callback = dataservice.GetDanhSachBaiHatMoi();
        callback.enqueue(new Callback<List<Baihatuathich>>() {
            @Override
            public void onResponse(Call<List<Baihatuathich>> call, Response<List<Baihatuathich>> response) {
                ArrayList<Baihatuathich> mangbaihatmoi = (ArrayList<Baihatuathich>) response.body();
                Log.d("search","size = " + mangbaihatmoi.size());
                if(mangbaihatmoi.size() > 0)
                {
                    Log.d("search","ten = " + mangbaihatmoi.get(0).getTenbaihat());
                }
                baihatuathichAdapter = new BaihatuathichAdapter(Search.this, mangbaihatmoi);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Search.this, RecyclerView.VERTICAL,false);
                rcvSearchResult.setLayoutManager(linearLayoutManager);
                rcvSearchResult.setNestedScrollingEnabled(false);
                rcvSearchResult.setFocusable(false);
                rcvSearchResult.setAdapter(baihatuathichAdapter);
            }

            @Override
            public void onFailure(Call<List<Baihatuathich>> call, Throwable t) {

            }
        });
    }

    private void setOnToolbar() {
        setSupportActionBar(toolbarSearch);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        toolbarSearch.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void sendNextSongData(Baihatuathich baihat) {
        Intent intentService = new Intent(Search.this, MusicService.class);
        //Gửi bài hát sang service
        Bundle bundle = new Bundle();
        bundle.putParcelable("baihat", baihat);
        intentService.putExtras(bundle);

        startService(intentService);
        bindService(intentService, serviceConnection, Context.BIND_AUTO_CREATE);
    }
}