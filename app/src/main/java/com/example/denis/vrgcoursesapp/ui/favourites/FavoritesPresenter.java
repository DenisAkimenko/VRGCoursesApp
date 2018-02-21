package com.example.denis.vrgcoursesapp.ui.favourites;


import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.data.source.ArticlesDataSource;
import com.example.denis.vrgcoursesapp.data.source.ArticlesRepository;

import java.util.List;

public class FavoritesPresenter implements FavoritesContract.Presenter {

    private final ArticlesRepository mArticlesRepository;

    private FavoritesContract.View mView;

    public FavoritesPresenter(ArticlesRepository articlesRepository, FavoritesContract.View favoritesView) {
        mArticlesRepository = articlesRepository;
        mView = favoritesView;

        mView.setPresenter(this);
    }

    @Override
    public void start() {
        loadFavourites();
    }

    @Override
    public void loadFavourites() {
        mArticlesRepository.loadFavorites(new ArticlesDataSource.LoadFavoritesCallback() {
            @Override
            public void onSuccess(List<Article> favourites) {
                mView.showProgress(false);
                mView.showFavourites(favourites);
            }

            @Override
            public void onFailure() {
                mView.showError();
                mView.showProgress(false);
            }
        });
    }
}