package com.example.denis.vrgcoursesapp;


import android.content.Context;

import com.example.denis.vrgcoursesapp.data.source.ArticlesRepository;
import com.example.denis.vrgcoursesapp.data.source.local.ArticlesLocalDataSource;
import com.example.denis.vrgcoursesapp.data.source.remote.ArticlesRemoteDataSource;

public class Injection {

    public static ArticlesRepository provideArticlesRepository(Context context) {
        return ArticlesRepository.getInstance(ArticlesRemoteDataSource.getInstance(), ArticlesLocalDataSource.getInstance(context));
    }
}
