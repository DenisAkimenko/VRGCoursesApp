package com.example.denis.vrgcoursesapp.ui.mostemailed;


import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.data.source.ArticlesDataSource;
import com.example.denis.vrgcoursesapp.data.source.ArticlesRepository;

import java.util.List;

public class MostEmailedPresenter implements MostEmailedContract.Presenter {

    private final ArticlesRepository mArticlesRepository;

    private final MostEmailedContract.View mView;

    public MostEmailedPresenter(ArticlesRepository articlesRepository, MostEmailedContract.View view) {
        mArticlesRepository = articlesRepository;

        mView = view;

        mView.setPresenter(this);
    }

    @Override
    public void start() {
        fetchMostEmailedList();
    }

    @Override
    public void fetchMostEmailedList() {
        mArticlesRepository.loadMostEmailed(new ArticlesDataSource.LoadArticlesCallback() {
            @Override
            public void onSuccess(List<Article> articles) {
                mView.showProgress(false);
                mView.showMostEmailedList(articles);
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
