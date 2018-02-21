package com.example.denis.vrgcoursesapp.ui.details;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.denis.vrgcoursesapp.R;
import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.utils.ActivityUtils;

public class ArticleDetailsActivity extends AppCompatActivity {

    private static final String EXTRA_ARTICLE = "article";

    public static void start(Article article, Activity from) {
        Intent intent = new Intent(from, ArticleDetailsActivity.class);
        intent.putExtra(EXTRA_ARTICLE, article);
        from.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Article article = getIntent().getParcelableExtra(EXTRA_ARTICLE);

        ArticleDetailsFragment detailsFragment =
                (ArticleDetailsFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.details_fragment);

        if (detailsFragment == null) {
            detailsFragment = ArticleDetailsFragment.newInstance(article);
            ActivityUtils.replaceFragmentOnActivity(getSupportFragmentManager(),
                    detailsFragment, R.id.details_fragment);
        }

        new ArticleDetailsPresenter(detailsFragment);
    }

}