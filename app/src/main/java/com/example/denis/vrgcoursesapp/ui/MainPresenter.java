package com.example.denis.vrgcoursesapp.ui;


public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mMainView;

    public MainPresenter(MainContract.View view) {
        mMainView = view;
        mMainView.setPresenter(this);
    }

    public void start() {
    }
}
