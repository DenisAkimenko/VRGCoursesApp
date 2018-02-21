package com.example.denis.vrgcoursesapp.ui.mostshared;


import com.example.denis.vrgcoursesapp.base.BasePresenter;
import com.example.denis.vrgcoursesapp.base.BaseView;
import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.ui.mostemailed.MostEmailedContract;

import java.util.List;

public interface MostSharedContract {

    interface View extends BaseView<Presenter> {

        void showMostSharedList(List<Article> articleList);

        void showProgress(boolean isVisible);

        void showError();
    }

    interface Presenter extends BasePresenter {

        void fetchMostSharedList();

        void addToFavourites(Article article);
    }
}
