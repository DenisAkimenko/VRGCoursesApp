package com.example.denis.vrgcoursesapp.data.source;


import com.example.denis.vrgcoursesapp.data.model.Article;

import java.util.List;

public interface ArticlesDataSource {

    interface LoadArticlesCallback {

        void onSuccess(List<Article> articles);

        void onFailure();
    }

    interface LoadFavoritesCallback {

        void onSuccess(List<Article> favourites);

        void onFailure();
    }

    void loadFavorites(LoadFavoritesCallback callback);

    void addToFavourites(Article article);

    void loadMostEmailed(LoadArticlesCallback callback);

    void loadMostShared(LoadArticlesCallback callback);

    void loadMostViewed(LoadArticlesCallback callback);
}
