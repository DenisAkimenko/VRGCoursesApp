package com.example.denis.vrgcoursesapp.data.source;


import com.example.denis.vrgcoursesapp.data.model.Article;

public class ArticlesRepository implements ArticlesDataSource {

    private static ArticlesRepository INSTANCE = null;

    private ArticlesDataSource mRemoteDataSource;

    private ArticlesDataSource mLocalDataSource;

    private ArticlesRepository(ArticlesDataSource articlesRemoteDataSource,
                               ArticlesDataSource articlesLocalDataSource) {
        mRemoteDataSource = articlesRemoteDataSource;
        mLocalDataSource = articlesLocalDataSource;
    }

    public static ArticlesRepository getInstance(ArticlesDataSource articlesRemoteDataSource,
                                                              ArticlesDataSource articlesLocalDataSource) {
        if (INSTANCE == null) {
            synchronized (ArticlesRepository.class) {
                if (INSTANCE == null)
                    INSTANCE = new ArticlesRepository(articlesRemoteDataSource, articlesLocalDataSource);
            }
        }
        return INSTANCE;
    }

    @Override
    public void loadMostEmailed(final LoadArticlesCallback callback) {
        mRemoteDataSource.loadMostEmailed(callback);
    }

    @Override
    public void loadMostShared(LoadArticlesCallback callback) {
        mRemoteDataSource.loadMostShared(callback);
    }

    @Override
    public void loadMostViewed(LoadArticlesCallback callback) {
        mRemoteDataSource.loadMostViewed(callback);
    }

    @Override
    public void loadFavorites(LoadFavoritesCallback callback) {
        mLocalDataSource.loadFavorites(callback);
    }

    @Override
    public void addToFavourites(Article article) {
        mLocalDataSource.addToFavourites(article);
    }
}
