package com.tatbigy.a.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.tatbigy.a.data.model.MediaEntity;

public  class ItemsEntity implements Parcelable {

    private String title;
    private String link;
    /**
     * m : http://farm2.staticflickr.com/1545/24055632919_b0210161af_m.jpg
     */

    private MediaEntity media;
    private String date_taken;
    private String description;
    private String published;
    private String author;
    private String author_id;
    private String tags;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setMedia(MediaEntity media) {
        this.media = media;
    }

    public void setDate_taken(String date_taken) {
        this.date_taken = date_taken;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public MediaEntity getMedia() {
        return media;
    }

    public String getDate_taken() {
        return date_taken;
    }

    public String getDescription() {
        return description;
    }

    public String getPublished() {
        return published;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public String getTags() {
        return tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.link);
        dest.writeParcelable(this.media, 0);
        dest.writeString(this.date_taken);
        dest.writeString(this.description);
        dest.writeString(this.published);
        dest.writeString(this.author);
        dest.writeString(this.author_id);
        dest.writeString(this.tags);
    }

    public ItemsEntity() {
    }

    protected ItemsEntity(Parcel in) {
        this.title = in.readString();
        this.link = in.readString();
        this.media = in.readParcelable(MediaEntity.class.getClassLoader());
        this.date_taken = in.readString();
        this.description = in.readString();
        this.published = in.readString();
        this.author = in.readString();
        this.author_id = in.readString();
        this.tags = in.readString();
    }

    public static final Parcelable.Creator<ItemsEntity> CREATOR = new Parcelable.Creator<ItemsEntity>() {
        public ItemsEntity createFromParcel(Parcel source) {
            return new ItemsEntity(source);
        }

        public ItemsEntity[] newArray(int size) {
            return new ItemsEntity[size];
        }
    };
}