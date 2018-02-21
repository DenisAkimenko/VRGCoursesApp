package com.example.denis.vrgcoursesapp.data.api;


import com.example.denis.vrgcoursesapp.data.model.BaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET(ApiConstants.MOST_EMAILED_ARTICLES)
    Call<BaseResponse> getMostEmailedArticles(@Path("section") String section,
                                              @Path("time-period") int timePeriod,
                                              @Query("api_key") String apiKey);

    @GET(ApiConstants.MOST_SHARED_ARTICLES)
    Call<BaseResponse> getMostSharedArticles(@Path("section") String section,
                                             @Path("time-period") int timePeriod,
                                             @Query("api_key") String apiKey);

    @GET(ApiConstants.MOST_VIEWED_ARTICLES)
    Call<BaseResponse> getMostViewedArticles(@Path("section") String section,
                                             @Path("time-period") int timePeriod,
                                             @Query("api_key") String apiKey);
}
