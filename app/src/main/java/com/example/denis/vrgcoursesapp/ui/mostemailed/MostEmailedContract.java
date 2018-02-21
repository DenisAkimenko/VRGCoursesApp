package com.example.denis.vrgcoursesapp.ui.mostemailed;


import com.example.denis.vrgcoursesapp.base.BasePresenter;
import com.example.denis.vrgcoursesapp.base.BaseView;
import com.example.denis.vrgcoursesapp.data.model.Article;

import java.util.List;

public interface MostEmailedContract {

    interface View extends BaseView<Presenter> {

        void showMostEmailedList(List<Article> articleList);

        void showProgress(boolean isVisible);

        void showError();
    }

    interface Presenter extends BasePresenter {

        void fetchMostEmailedList();

        void addToFavourites(Article article);
    }
}