package com.example.newsappweb.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.example.newsappweb.base.BaseFragment;
import com.example.newsappweb.databinding.FragmentNewsBinding;
import com.example.newsappweb.tab.Tabs;
import com.example.newsappweb.tab.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment<FragmentNewsBinding> {
    private ArrayList<Tabs> fragments;
    private ViewPagerAdapter adapter;
    private NewsViewModel viewModel;

    @Override
    protected FragmentNewsBinding bind() {
        return FragmentNewsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity())
                .get(NewsViewModel.class);
        adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);
    }

    @Override
    protected void callRequests() {
        viewModel.getNews();
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        fragments = new ArrayList<>();
        fragments.add(new Tabs(new BusinessFragment(), "Business News"));
        fragments.add(new Tabs(new EntertainmentFragment(), "Entertainment News"));
        fragments.add(new Tabs(new GeneralFragment(), "General News"));
        fragments.add(new Tabs(new HealthFragment(), "Health News"));
        fragments.add(new Tabs(new ScienceFragment(), "Science News"));
        fragments.add(new Tabs(new SportFragment(), "Sport News"));
        fragments.add(new Tabs(new TechnologyFragment(), "Technology News"));
        fragments.add(new Tabs(new TopFragment(), "Top News"));
        adapter = new ViewPagerAdapter(this);
        adapter.setFragments(fragments);
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tab, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(fragments.get(position).getNews());
            }
        }).attach();
    }
}
