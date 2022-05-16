package com.example.newsappweb.data.repository;

import androidx.lifecycle.MutableLiveData;


import com.example.newsappweb.common.Resource;
import com.example.newsappweb.data.model.MainResponce;
import com.example.newsappweb.data.remote.NewsApi;
import com.example.newsappweb.repositories.NewsRepository;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepositoryImpl implements NewsRepository {
    private final String API_KEY = "bfe58d5883544f1d8d0b1447c0d98243";
    private MutableLiveData<Resource<MainResponce>> liveData = new MutableLiveData<>();
    private NewsApi api;
    @Inject
    public NewsRepositoryImpl(NewsApi api) {
        this.api=api;
    }

    @Override
    public MutableLiveData<Resource<MainResponce>> getTopNews() {
        liveData.setValue(Resource.loading());
        api.getTopNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                        if(response.isSuccessful() && response.body() != null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponce>> getBusinessNews() {
        liveData.setValue(Resource.loading());
        api.getBusinessNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponce>> getEntertainmentNews() {
        liveData.setValue(Resource.loading());
        api.getEntertainmentNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponce>> getGeneralNews() {
        liveData.setValue(Resource.loading());
        api.getGeneralNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponce>> getHealthNews() {
        liveData.setValue(Resource.loading());
        api.getHealthNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponce>> getScienceNews() {
        liveData.setValue(Resource.loading());
        api.getScienceNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponce>> getSportNews() {
        liveData.setValue(Resource.loading());
        api.getSportNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }

    @Override
    public MutableLiveData<Resource<MainResponce>> getTechnologyNews() {
        liveData.setValue(Resource.loading());
        api.getTechnologyNews(API_KEY,"ru")
                .enqueue(new Callback<MainResponce>() {
                    @Override
                    public void onResponse(Call<MainResponce> call, Response<MainResponce> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            liveData.setValue(Resource.success(response.body()));
                        }else{
                            liveData.setValue(Resource.error(response.message(),null));
                        }
                    }

                    @Override
                    public void onFailure(Call<MainResponce> call, Throwable t) {
                        liveData.setValue(Resource.error(t.getLocalizedMessage(),null));

                    }
                });
        return liveData;
    }
}
