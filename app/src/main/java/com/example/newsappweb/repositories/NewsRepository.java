package com.example.newsappweb.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.newsappweb.common.Resource;
import com.example.newsappweb.data.model.MainResponce;

public interface NewsRepository {
    MutableLiveData<Resource<MainResponce>> getTopNews();

    MutableLiveData<Resource<MainResponce>> getBusinessNews();

    MutableLiveData<Resource<MainResponce>> getEntertainmentNews();

    MutableLiveData<Resource<MainResponce>> getGeneralNews();

    MutableLiveData<Resource<MainResponce>> getHealthNews();

    MutableLiveData<Resource<MainResponce>> getScienceNews();

    MutableLiveData<Resource<MainResponce>> getSportNews();

    MutableLiveData<Resource<MainResponce>> getTechnologyNews();
}
