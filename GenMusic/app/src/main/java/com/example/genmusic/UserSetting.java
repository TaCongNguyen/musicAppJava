package com.example.genmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class UserSetting extends AppCompatActivity {
    private ImageButton btnUserBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        btnUserBack = findViewById(R.id.btnUserBack);

        //Quay về Main Activity
        backToMainActivity();

    }

    private void backToMainActivity() {
        btnUserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainIntent = getIntent();
                int index = MainIntent.getIntExtra("current_fragment",0);
                Intent intent = new Intent(UserSetting.this, MainActivity.class);
                intent.putExtra("current_fragment",index);
                startActivity(intent);
            }
        });
    }
}