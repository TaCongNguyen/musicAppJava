package com.example.genmusic.theLoaiFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.genmusic.R;

public class AlbumPlaylist extends AppCompatActivity {

    TextView txtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_playlist);

        txtText = findViewById(R.id.txtText);

        Intent intent = getIntent();
        String str = intent.getStringExtra("key");
        txtText.setText(str);

    }
}