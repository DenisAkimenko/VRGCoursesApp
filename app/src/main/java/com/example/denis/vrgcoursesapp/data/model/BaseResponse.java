package com.example.denis.vrgcoursesapp.data.model;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse {

    @SerializedName("status") private String status;

    @SerializedName("results")  private List<JsonObject> mArticles;

    public String getStatus() {
        return status;
    }

    public List<Article> getArticles() {

        List<Article> articles = new ArrayList<>();

        for (JsonObject articleJson : mArticles) {
            try {
                Article article = new Gson().fromJson(articleJson, Article.class);
                articles.add(article);
            } catch (JsonSyntaxException exc) {
                exc.printStackTrace();
            }
        }
        return articles;
    }
}
