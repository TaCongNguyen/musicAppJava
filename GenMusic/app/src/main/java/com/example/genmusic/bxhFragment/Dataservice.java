package com.example.genmusic.bxhFragment;

import com.example.genmusic.bxhFragment.Baihatuathich;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("chartforcurrent.php")
    Call<List<bxh>> GetChartCurrentDay();

    @GET("baihatduocthich.php")
    Call<List<Baihatuathich>> GetBaiHatHot();
}
