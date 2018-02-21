package com.example.denis.vrgcoursesapp.data.source.local;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ArticlesDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "Favourites.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_FAVOURITE =
            "CREATE TABLE " + ArticlesDbContract.FavouritesEntry.TABLE_NAME + " (" +
                    ArticlesDbContract.FavouritesEntry._ID + INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT," +
                    ArticlesDbContract.FavouritesEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    ArticlesDbContract.FavouritesEntry.COLUMN_NAME_AUTHOR + TEXT_TYPE + COMMA_SEP +
                    ArticlesDbContract.FavouritesEntry.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP +
                    ArticlesDbContract.FavouritesEntry.COLUMN_NAME_IMAGE_URL + TEXT_TYPE + " )";

    public ArticlesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_FAVOURITE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not required as at version 1
    }
}
