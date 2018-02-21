package com.example.denis.vrgcoursesapp.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {

    @SerializedName("media-metadata") private List<MediaMetaData> mediaMetaData;

    public List<MediaMetaData> getMediaMetaData() {
        return mediaMetaData;
    }
}
