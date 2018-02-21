package com.example.denis.vrgcoursesapp.ui.mostviewed;


import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.data.source.ArticlesDataSource;
import com.example.denis.vrgcoursesapp.data.source.ArticlesRepository;

import java.util.List;

public class MostViewedPresenter implements MostViewedContract.Presenter {

    private final ArticlesRepository mArticlesRepository;

    private final MostViewedContract.View mView;

    public MostViewedPresenter(ArticlesRepository articlesRepository, MostViewedContract.View view) {
        mArticlesRepository = articlesRepository;
        mView = view;

        mView.setPresenter(this);
    }

    @Override
    public void start() {
        fetchMostViewedList();
    }

    @Override
    public void fetchMostViewedList() {
        mArticlesRepository.loadMostViewed(new ArticlesDataSource.LoadArticlesCallback() {
            @Override
            public void onSuccess(List<Article> articles) {
                mView.showProgress(false);
                mView.showMostViewedList(articles);
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
