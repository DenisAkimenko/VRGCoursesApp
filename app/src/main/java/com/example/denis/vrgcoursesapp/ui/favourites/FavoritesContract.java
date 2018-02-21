package com.example.denis.vrgcoursesapp.ui.favourites;


import com.example.denis.vrgcoursesapp.base.BasePresenter;
import com.example.denis.vrgcoursesapp.base.BaseView;
import com.example.denis.vrgcoursesapp.data.model.Article;

import java.util.List;

public interface FavoritesContract {

    interface View extends BaseView<Presenter> {

        void showFavourites(List<Article> favourites);

        void showProgress(boolean isVisible);

        void showError();
    }

    interface Presenter extends BasePresenter {

        void loadFavourites();
    }
}