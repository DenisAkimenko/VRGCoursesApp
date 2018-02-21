package com.example.denis.vrgcoursesapp.ui.details;


import com.example.denis.vrgcoursesapp.base.BasePresenter;
import com.example.denis.vrgcoursesapp.base.BaseView;

public interface ArticleDetailsContract {

    interface View extends BaseView<Presenter> {

        void showArticleDetails();
    }

    interface Presenter extends BasePresenter {

    }
}
