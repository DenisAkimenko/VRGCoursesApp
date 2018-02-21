package com.example.denis.vrgcoursesapp.data.source.local;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.data.source.ArticlesDataSource;

import java.util.ArrayList;
import java.util.List;

public class ArticlesLocalDataSource implements ArticlesDataSource {

    private static ArticlesLocalDataSource INSTANCE;

    private ArticlesDbHelper mDbHelper;

    private SQLiteDatabase mDb;

    private ArticlesLocalDataSource(Context context) {
        mDbHelper = new ArticlesDbHelper(context);
        mDb = mDbHelper.getWritableDatabase();
    }

    public static ArticlesLocalDataSource getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ArticlesLocalDataSource.class) {
                if (INSTANCE == null)
                    INSTANCE = new ArticlesLocalDataSource(context);
            }
        }
        return INSTANCE;
    }

    @Override
    public void loadFavorites(LoadFavoritesCallback callback) {
        List<Article> favourites = new ArrayList<>();
        try {
            Cursor cursor = mDb.query(
                    ArticlesDbContract.FavouritesEntry.TABLE_NAME,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String title = cursor
                            .getString(cursor.getColumnIndexOrThrow(
                                    ArticlesDbContract.FavouritesEntry.COLUMN_NAME_TITLE));
                    String author = cursor
                            .getString(cursor.getColumnIndexOrThrow(
                                    ArticlesDbContract.FavouritesEntry.COLUMN_NAME_AUTHOR));
                    String date = cursor
                            .getString(cursor.getColumnIndexOrThrow(
                                    ArticlesDbContract.FavouritesEntry.COLUMN_NAME_DATE));
                    String image = cursor
                            .getString(cursor.getColumnIndexOrThrow(
                                    ArticlesDbContract.FavouritesEntry.COLUMN_NAME_IMAGE_URL));
                    Article favourite = new Article(title, author, date, image);
                    favourites.add(favourite);
                }
                callback.onSuccess(favourites);
                cursor.close();
            } else {
                callback.onFailure();
            }

        } catch (IllegalStateException e) {
            callback.onFailure();
        }
    }

    @Override
    public void addToFavourites(Article article) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ArticlesDbContract.FavouritesEntry.COLUMN_NAME_TITLE, article.getTitle());
        contentValues.put(ArticlesDbContract.FavouritesEntry.COLUMN_NAME_AUTHOR, article.getAuthor());
        contentValues.put(ArticlesDbContract.FavouritesEntry.COLUMN_NAME_DATE, article.getPublishedDate());
        contentValues.put(ArticlesDbContract.FavouritesEntry.COLUMN_NAME_IMAGE_URL, article.getMedia().get(0).getMediaMetaData().get(0).getUrl());
        mDb.insert(ArticlesDbContract.FavouritesEntry.TABLE_NAME, null, contentValues);
    }

    @Override
    public void loadMostEmailed(LoadArticlesCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadMostShared(LoadArticlesCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadMostViewed(LoadArticlesCallback callback) {
        throw new UnsupportedOperationException();
    }
}
