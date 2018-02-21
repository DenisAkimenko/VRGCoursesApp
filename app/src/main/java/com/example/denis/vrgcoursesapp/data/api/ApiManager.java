package com.example.denis.vrgcoursesapp.data.api;


import com.example.denis.vrgcoursesapp.BuildConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static ApiManager sInstance;

    private ApiService mApiService;

    private ApiManager() {

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mApiService = retrofit.create(ApiService.class);
    }

    public static synchronized ApiManager getInstance() {
        if (sInstance == null) {
            sInstance = new ApiManager();
        }
        return sInstance;
    }

    public ApiService getApiService() {
        return mApiService;
    }
}
