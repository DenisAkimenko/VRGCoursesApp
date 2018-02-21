package com.example.denis.vrgcoursesapp.data.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Article implements Parcelable {

    @SerializedName("url") private String url;

    @SerializedName("title") private String title;

    @SerializedName("abstract") private String abstractText;

    @SerializedName("byline") private String author;

    @SerializedName("published_date") private String  publishedDate;

    @SerializedName("media") private List<Media> media;

    private String imageUrl;

    public Article(String title, String author, String publishedDate, String imageUrl) {
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        if (imageUrl == null) {
            if (media != null && !media.isEmpty()) {
                return media.get(0).getMediaMetaData().get(1).getUrl();
            }
        }
        return imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public List<Media> getMedia() {
        return media;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(publishedDate);
        parcel.writeString(getImageUrl());
    }

    private Article(Parcel in) {
        this.title = in.readString();
        this.author = in.readString();
        this.publishedDate = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Parcelable.Creator<Article> CREATOR = new Parcelable.Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel source) {
            return new Article(source);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };
}
