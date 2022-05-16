package com.example.newsappweb.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsappweb.common.Resource;
import com.example.newsappweb.data.model.MainResponce;
import com.example.newsappweb.data.repository.NewsRepositoryImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class Sport extends ViewModel {
    private NewsRepositoryImpl repositories;
    public LiveData<Resource<MainResponce>> liveData;

    @Inject
    public Sport(NewsRepositoryImpl repositories) {
        this.repositories = repositories;
    }

    public  void getSport() {
        liveData = repositories.getSportNews();
    }
}
