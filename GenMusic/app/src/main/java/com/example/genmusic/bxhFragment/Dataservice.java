package com.example.genmusic.bxhFragment;

import com.example.genmusic.bxhFragment.Baihatuathich;
import com.example.genmusic.theLoaiFragment.Album;
import com.example.genmusic.theLoaiFragment.ChuDe;
import com.example.genmusic.theLoaiFragment.TheLoai;
import com.example.genmusic.trangChuFragment.QuangCao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    //----------------------------------GET----------------------------------
    @GET("chartforcurrent.php")
    Call<List<bxh>> GetChartCurrentDay();

    @GET("baihatduocthich.php")
    Call<List<Baihatuathich>> GetBaiHatHot();

    @GET("DanhSachAlbum.php")
    Call<List<Album>> GetDanhSachAlbum();

    @GET("DanhSachTatCaAlbum.php")
    Call<List<Album>> GetDanhSachTatCaAlbum();

    @GET("DanhSachChuDe.php")
    Call<List<ChuDe>> GetDanhSachChuDe();

    @GET("DanhSachQuangCao.php")
    Call<List<QuangCao>> GetDanhSachQuangCao();

    @GET("DanhSachTheLoaiRandom.php")
    Call<List<TheLoai>> GetDanhSachTheLoaiRandom();

    @GET("DanhSachBaiHatMoi.php")
    Call<List<Baihatuathich>> GetDanhSachBaiHatMoi();

    @GET("DanhSachAlbumMoi.php")
    Call<List<Album>> GetDanhSachAlbumMoi();

    //----------------------------------POST----------------------------------
    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihatuathich>> GetDanhsachbaihatuathichtheochart(@Field("idxephang") String idxephang);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihatuathich>> GetDanhSachBaiHatTrongAlbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihatuathich>> GetDanhSachBaiHatTrongTheLoai(@Field("idtheloai") String idtheloai);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihatuathich>> GetBaiHatQuangCao(@Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> UpdateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("DanhSachTheLoai.php")
    Call<List<TheLoai>> GetDanhSachTheLoai(@Field("idchude") String idchude);

}
