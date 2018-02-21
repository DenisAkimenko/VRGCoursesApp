package com.example.denis.vrgcoursesapp.data.source.remote;


import com.example.denis.vrgcoursesapp.BuildConfig;
import com.example.denis.vrgcoursesapp.data.api.ApiConstants;
import com.example.denis.vrgcoursesapp.data.api.ApiManager;
import com.example.denis.vrgcoursesapp.data.model.BaseResponse;
import com.example.denis.vrgcoursesapp.data.model.Article;
import com.example.denis.vrgcoursesapp.data.source.ArticlesDataSource;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesRemoteDataSource implements ArticlesDataSource {

    private static ArticlesRemoteDataSource INSTANCE;

    private static ApiManager sApiManager;

    private ArticlesRemoteDataSource() {
        sApiManager = ApiManager.getInstance();
    }

    public static ArticlesRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (ArticlesRemoteDataSource.class) {
                if (INSTANCE == null)
                    INSTANCE = new ArticlesRemoteDataSource();
            }
        }
        return INSTANCE;
    }

    @Override
    public void loadMostEmailed(final LoadArticlesCallback callback) {
        sApiManager
                .getApiService()
                .getMostEmailedArticles(ApiConstants.ARTICLES_SECTION, ApiConstants.TIME_PERIOD_DAYS, BuildConfig.API_KEY)
                .enqueue(new Callback<BaseResponse>() {
                    @Override
                    public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                        if (response.body() != null) {
                            int statusCode = response.code();
                            if (statusCode == HttpURLConnection.HTTP_OK) {
                                callback.onSuccess(response.body().getArticles());
                            } else {
                                callback.onFailure();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse> call, Throwable t) {
                        callback.onFailure();
                    }
                });
    }

    @Override
    public void loadMostShared(final LoadArticlesCallback callback) {
        sApiManager
                .getApiService()
                .getMostSharedArticles(ApiConstants.ARTICLES_SECTION, ApiConstants.TIME_PERIOD_DAYS, BuildConfig.API_KEY)
                .enqueue(new Callback<BaseResponse>() {
                    @Override
                    public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                        if (response.body() != null) {
                            int statusCode = response.code();
                            if (statusCode == HttpURLConnection.HTTP_OK) {
                                callback.onSuccess(response.body().getArticles());
                            } else {
                                callback.onFailure();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse> call, Throwable t) {
                        callback.onFailure();
                    }
                });
    }

    @Override
    public void loadMostViewed(final LoadArticlesCallback callback) {
        sApiManager
                .getApiService()
                .getMostViewedArticles(ApiConstants.ARTICLES_SECTION, ApiConstants.TIME_PERIOD_DAYS, BuildConfig.API_KEY)
                .enqueue(new Callback<BaseResponse>() {
                    @Override
                    public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                        if (response.body() != null) {
                            int statusCode = response.code();
                            if (statusCode == HttpURLConnection.HTTP_OK) {
                                callback.onSuccess(response.body().getArticles());
                            } else {
                                callback.onFailure();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse> call, Throwable t) {
                        callback.onFailure();
                    }
                });
    }

    @Override
    public void loadFavorites(LoadFavoritesCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addToFavourites(Article article) {
        throw new UnsupportedOperationException();
    }
}
