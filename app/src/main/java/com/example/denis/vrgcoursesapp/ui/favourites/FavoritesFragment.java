package com.example.denis.vrgcoursesapp.ui.favourites;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.denis.vrgcoursesapp.R;
import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.ui.adapter.ArticlesRecyclerAdapter;
import com.example.denis.vrgcoursesapp.ui.details.ArticleDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment implements FavoritesContract.View, ArticlesRecyclerAdapter.ArticleItemListener {

    private FavoritesContract.Presenter mPresenter;

    private RecyclerView mRecyclerView;

    private ArticlesRecyclerAdapter mRecyclerAdapter;

    private ProgressBar mProgressBar;

    private View mView;

    public FavoritesFragment() {

    }

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_articles, container, false);

        mProgressBar = mView.findViewById(R.id.progressBar);
        mRecyclerView = mView.findViewById(R.id.rv_articles);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(),
                linearLayoutManager.getOrientation()));

        mRecyclerAdapter = new ArticlesRecyclerAdapter(new ArrayList<Article>(), getContext(), this, true);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        return mView;
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (menuVisible && isAdded()) {
            mPresenter.start();
        }
    }

    public void setPresenter(FavoritesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showFavourites(List<Article> favourites) {
        mRecyclerAdapter.setArticlesList(favourites);
    }

    @Override
    public void showProgress(boolean isVisible) {
        if (isVisible) {
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
        } else {
            mProgressBar.setVisibility(ProgressBar.GONE);
        }
    }

    @Override
    public void showError() {
        if (isAdded()) {
            Snackbar.make(mView, R.string.error_message, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onArticleClicked(Article clickedArticle) {
        ArticleDetailsActivity.start(clickedArticle, getActivity());
    }

    @Override
    public void onFavoriteAddClicked(Article favoritedArticle) {
        //
    }
}