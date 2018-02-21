package com.example.denis.vrgcoursesapp.ui.mostviewed;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class MostViewedFragment extends Fragment implements MostViewedContract.View, ArticlesRecyclerAdapter.ArticleItemListener {

    private MostViewedContract.Presenter mPresenter;

    private ArticlesRecyclerAdapter mArticlesListAdapter;

    private RecyclerView mRecyclerView;

    private ProgressBar mProgressBar;

    private View mView;

    public MostViewedFragment() {

    }

    public static MostViewedFragment newInstance() {
        return new MostViewedFragment();
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

        mArticlesListAdapter = new ArticlesRecyclerAdapter(new ArrayList<Article>(), getContext(), this,false);
        mRecyclerView.setAdapter(mArticlesListAdapter);

        return mView;
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (menuVisible) {
            mPresenter.start();
        }
    }

    @Override
    public void setPresenter(MostViewedContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMostViewedList(List<Article> articleList) {
        mArticlesListAdapter.setArticlesList(articleList);
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
        Snackbar.make(mView, R.string.error_message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onArticleClicked(Article clickedArticle) {
        ArticleDetailsActivity.start(clickedArticle, getActivity());
    }

    @Override
    public void onFavoriteAddClicked(Article favoritedArticle) {
        mPresenter.addToFavourites(favoritedArticle);
    }
}
