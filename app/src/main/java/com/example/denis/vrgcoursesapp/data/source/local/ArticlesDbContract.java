package com.example.denis.vrgcoursesapp.data.source.local;


import android.provider.BaseColumns;

public final class ArticlesDbContract {

    private ArticlesDbContract() {
    }

    public static abstract class FavouritesEntry implements BaseColumns {
        public static final String TABLE_NAME = "favourites";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_IMAGE_URL = "image";
    }
}
