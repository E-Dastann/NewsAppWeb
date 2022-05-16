package com.example.newsappweb.data.remote;



import com.example.newsappweb.data.model.MainResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines")
    Call<MainResponce> getTopNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=business")
    Call<MainResponce> getBusinessNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=entertainment")
    Call<MainResponce> getEntertainmentNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=general")
    Call<MainResponce> getGeneralNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=health")
    Call<MainResponce> getHealthNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=science")
    Call<MainResponce> getScienceNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=sport")
    Call<MainResponce> getSportNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
    @GET("top-headlines?category=technology")
    Call<MainResponce> getTechnologyNews(
            @Query("apiKey") String apiKey,
            @Query("country") String country);
}
