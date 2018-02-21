package com.example.denis.vrgcoursesapp.ui.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denis.vrgcoursesapp.R;
import com.example.denis.vrgcoursesapp.data.model.Article;
import com.squareup.picasso.Picasso;

public class ArticleDetailsFragment extends Fragment implements ArticleDetailsContract.View {

    private static final String EXTRA_ARTICLE = "article";

    private Article mArticle;

    private ArticleDetailsContract.Presenter mPresenter;

    private TextView titleView;
    private TextView authorView;
    private TextView dateView;
    private ImageView imageView;

    public static ArticleDetailsFragment newInstance(Article article) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_ARTICLE, article);
        ArticleDetailsFragment detailsFragment = new ArticleDetailsFragment();
        detailsFragment.setArguments(bundle);
        return detailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        titleView = view.findViewById(R.id.tv_title);
        authorView = view.findViewById(R.id.tv_author);
        dateView = view.findViewById(R.id.tv_date);
        imageView = view.findViewById(R.id.image);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mArticle = bundle.getParcelable(EXTRA_ARTICLE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(ArticleDetailsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showArticleDetails() {
        updateDetailsView(mArticle);
    }

    public void updateDetailsView(Article article) {
        if (article != null) {
            titleView.setText(article.getTitle());
            authorView.setText(article.getAuthor());
            dateView.setText(article.getPublishedDate());

            Picasso.with(getContext())
                    .load(article.getImageUrl())
                    .into(imageView);
        }
    }
}
