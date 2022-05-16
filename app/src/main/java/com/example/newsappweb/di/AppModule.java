package com.example.newsappweb.di;


import com.example.newsappweb.data.remote.NewsApi;
import com.example.newsappweb.data.repository.NewsRepositoryImpl;
import com.example.newsappweb.repositories.NewsRepository;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)

public class AppModule {

    @Provides
    @OtherInterceptorOkHttpClient
    public static OkHttpClient provideBaseOkHttpClient(){
        return new OkHttpClient.Builder().addInterceptor(
                new HttpLoggingInterceptor().
                        setLevel(HttpLoggingInterceptor.Level.BODY)
        ).build();
    }

    @Provides
    @AuthInterceptorOkHttpClient
    public static OkHttpClient provideAuthOkHttpClient(){
        return new OkHttpClient.Builder().addInterceptor(
                new HttpLoggingInterceptor().
                        setLevel(HttpLoggingInterceptor.Level.BODY)
        ).build();
    }
    @Provides
    public static Retrofit provideRetrofit(@OtherInterceptorOkHttpClient OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    public static NewsApi provideApi (Retrofit retrofit){
        return retrofit.create(NewsApi.class);
    }

    @Provides
    public static NewsRepository provideNewsRepository(NewsApi api){
        return new NewsRepositoryImpl(api);
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    private @interface AuthInterceptorOkHttpClient {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    private @interface OtherInterceptorOkHttpClient {}
}
