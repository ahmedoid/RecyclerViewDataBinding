package com.tatbigy.a.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MediaEntity implements Parcelable {

    private String m;

    public void setM(String m) {
        this.m = m;
    }

    public String getM() {
        return m;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.m);
    }

    public MediaEntity() {
    }

    protected MediaEntity(Parcel in) {
        this.m = in.readString();
    }

    public static final Parcelable.Creator<MediaEntity> CREATOR = new Parcelable.Creator<MediaEntity>() {
        public MediaEntity createFromParcel(Parcel source) {
            return new MediaEntity(source);
        }

        public MediaEntity[] newArray(int size) {
            return new MediaEntity[size];
        }
    };
}
