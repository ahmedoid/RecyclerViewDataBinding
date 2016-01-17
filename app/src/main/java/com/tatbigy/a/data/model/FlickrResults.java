package com.tatbigy.a.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.tatbigy.a.data.model.ItemsEntity;

import java.util.List;

public class FlickrResults implements Parcelable {

    public int totalItems;
    @SerializedName("items")
    public List<ItemsEntity> items;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.totalItems);
        dest.writeTypedList(items);
    }

    public FlickrResults() {
    }

    protected FlickrResults(Parcel in) {
        this.totalItems = in.readInt();
        this.items = in.createTypedArrayList(ItemsEntity.CREATOR);
    }

    public static final Parcelable.Creator<FlickrResults> CREATOR = new Parcelable.Creator<FlickrResults>() {
        public FlickrResults createFromParcel(Parcel source) {
            return new FlickrResults(source);
        }

        public FlickrResults[] newArray(int size) {
            return new FlickrResults[size];
        }
    };
}
