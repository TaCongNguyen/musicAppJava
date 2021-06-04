package com.example.genmusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DanhsachbaihatActivity extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    ImageView imgdanhsachcakhuc;

    DanhsachbaihatAdapter danhsachbaihatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachbaihat);
        anhxa();
        init();

    }
    private void SetValueInView(String ten, String hinh){
        collapsingToolbarLayout.setTitle(ten);

        try {
            URL url=new URL(hinh);
            Bitmap bitmap= BitmapFactory.decodeStream((url.openConnection().getInputStream()));
            BitmapDrawable bitmapDrawable=new BitmapDrawable(getResources(),bitmap);
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
                collapsingToolbarLayout.setBackground(bitmapDrawable);
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load(hinh).into(imgdanhsachcakhuc);
    }
    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void anhxa() {
        coordinatorLayout=findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout=findViewById(R.id.collapsingtoolbar);
        toolbar=findViewById(R.id.toolbardanhsach);
        recyclerViewdanhsachbaihat=findViewById(R.id.recyclerviewtopbaihatuathich);
        imgdanhsachcakhuc=findViewById(R.id.imageviewdanhsachcakhuc);
        floatingActionButton=findViewById(R.id.floatingactionbutton);
    }
}