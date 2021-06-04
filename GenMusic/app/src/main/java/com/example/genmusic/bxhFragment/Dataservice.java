package com.example.genmusic.bxhFragment;

import com.example.genmusic.bxhFragment.Baihatuathich;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("chartforcurrent.php")
    Call<List<bxh>> GetChartCurrentDay();

    @GET("baihatduocthich.php")
    Call<List<Baihatuathich>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihatuathich>> GetDanhsachbaihatuathichtheochart(@Field("idxephang") String idxephang);

    @FormUrlEncoded
    @POST(("updateluotthich"))
    Call<String> UpdateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);
}
