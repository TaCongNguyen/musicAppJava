package com.example.genmusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.genmusic.trangChuFragment.SongImage;
import com.example.genmusic.trangChuFragment.SongImageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    //-----------------------A. Khai báo biến -------------------------
    private BottomNavigationView bottomNavigationView;

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------------------b. Ánh xạ view -------------------------
        bottomNavigationView = findViewById(R.id.BottomNav);
        viewPager = findViewById(R.id.ViewPager);

        //-----------------------C. Code xử lý -------------------------


        //NAVIGATION BAR------------------------
        //Xử lý ViewPager
        setOnViewPager();

        //Xử lý BottomNavigationBar
        setOnNavBar();

        //Xử lý quay về đúng TheLoaiFragment
        troVeTheLoaiFragment();

        //Xử lý quay về đúng CaNhanFragment
        troVeCaNhanFragment();

    }
    // CÁC HÀM XỬ LÝ -----------------------------------------------------


    private void setOnNavBar() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.menuTrangChu:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menuTheLoai:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menuXepHang:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.menuCaNhan:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    private void setOnViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        //Xử lí sự kiện vuốt ngang màn hình
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch(position)
                {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menuTrangChu).setChecked(true);
                        break;

                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menuTheLoai).setChecked(true);
                        break;

                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menuXepHang).setChecked(true);
                        break;

                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.menuCaNhan).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void troVeTheLoaiFragment() {
        Intent intent = getIntent();
        int index = intent.getIntExtra("the_loai", 0);
        if(index == 1)
            viewPager.setCurrentItem(index);

    }

    private void troVeCaNhanFragment() {
        Intent intent = getIntent();
        int index = intent.getIntExtra("ca_nhan", 0);
        if(index == 3)
            viewPager.setCurrentItem(index);
    }


}