package com.example.genmusic.bxhFragment;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Baihatuathich implements Parcelable {

    @SerializedName("Idbaihat")
    @Expose
    private String idbaihat;
    @SerializedName("Tenbaihat")
    @Expose
    private String tenbaihat;
    @SerializedName("Hinhbaihat")
    @Expose
    private String hinhbaihat;
    @SerializedName("Casi")
    @Expose
    private String casi;
    @SerializedName("Linkbaihat")
    @Expose
    private String linkbaihat;
    @SerializedName("Luotthich")
    @Expose
    private String luotthich;

    protected Baihatuathich(Parcel in) {
        idbaihat = in.readString();
        tenbaihat = in.readString();
        hinhbaihat = in.readString();
        casi = in.readString();
        linkbaihat = in.readString();
        luotthich = in.readString();
    }

    public static final Creator<Baihatuathich> CREATOR = new Creator<Baihatuathich>() {
        @Override
        public Baihatuathich createFromParcel(Parcel in) {
            return new Baihatuathich(in);
        }

        @Override
        public Baihatuathich[] newArray(int size) {
            return new Baihatuathich[size];
        }
    };

    public String getIdbaihat() {
        return idbaihat;
    }

    public void setIdbaihat(String idbaihat) {
        this.idbaihat = idbaihat;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getHinhbaihat() {
        return hinhbaihat;
    }

    public void setHinhbaihat(String hinhbaihat) {
        this.hinhbaihat = hinhbaihat;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public String getLinkbaihat() {
        return linkbaihat;
    }

    public void setLinkbaihat(String linkbaihat) {
        this.linkbaihat = linkbaihat;
    }

    public String getLuotthich() {
        return luotthich;
    }

    public void setLuotthich(String luotthich) {
        this.luotthich = luotthich;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idbaihat);
        dest.writeString(tenbaihat);
        dest.writeString(hinhbaihat);
        dest.writeString(casi);
        dest.writeString(linkbaihat);
        dest.writeString(luotthich);
    }
}
