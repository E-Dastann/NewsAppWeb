package com.example.newsappweb.tab;

import androidx.fragment.app.Fragment;

import com.example.newsappweb.ui.BusinessFragment;

public class Tabs  extends Fragment {
    private Fragment fragments;
    private String news;

    public Tabs (Fragment fragments, String news){
        this.fragments=fragments;
        this.news=news;
    }

    public Fragment getFragments() {
        return fragments;
    }

    public void setFragments(Fragment fragments) {
        this.fragments = fragments;
    }
    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
