package com.example.denis.vrgcoursesapp.ui.mostviewed;


import com.example.denis.vrgcoursesapp.base.BasePresenter;
import com.example.denis.vrgcoursesapp.base.BaseView;
import com.example.denis.vrgcoursesapp.data.model.Article;

import java.util.List;

public interface MostViewedContract {

    interface View extends BaseView<Presenter> {

        void showMostViewedList(List<Article> articleList);

        void showProgress(boolean isVisible);

        void showError();
    }

    interface Presenter extends BasePresenter {

        void fetchMostViewedList();

        void addToFavourites(Article article);
    }

}
