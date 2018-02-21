package com.example.denis.vrgcoursesapp.ui.details;


public class ArticleDetailsPresenter implements ArticleDetailsContract.Presenter {

    private ArticleDetailsContract.View mView;

    public ArticleDetailsPresenter(ArticleDetailsContract.View view) {
        mView = view;

        mView.setPresenter(this);
    }

    @Override
    public void start() {
        mView.showArticleDetails();
    }
}
