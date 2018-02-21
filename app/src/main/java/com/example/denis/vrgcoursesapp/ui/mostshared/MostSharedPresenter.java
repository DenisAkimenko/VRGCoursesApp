package com.example.denis.vrgcoursesapp.ui.mostshared;


import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.data.source.ArticlesDataSource;
import com.example.denis.vrgcoursesapp.data.source.ArticlesRepository;

import java.util.List;

public class MostSharedPresenter implements MostSharedContract.Presenter {

    private final ArticlesRepository mArticlesRepository;

    private final MostSharedContract.View mView;

    public MostSharedPresenter(ArticlesRepository articlesRepository, MostSharedContract.View view) {
        mArticlesRepository = articlesRepository;
        mView = view;

        mView.setPresenter(this);
    }

    @Override
    public void start() {
        fetchMostSharedList();
    }

    @Override
    public void fetchMostSharedList() {
        mArticlesRepository.loadMostShared(new ArticlesDataSource.LoadArticlesCallback() {
            @Override
            public void onSuccess(List<Article> articles) {
                mView.showProgress(false);
                mView.showMostSharedList(articles);
            }

            @Override
            public void onFailure() {
                mView.showError();
                mView.showProgress(false);
            }
        });
    }

    @Override
    public void addToFavourites(final Article article) {
        mArticlesRepository.addToFavourites(article);
    }
}