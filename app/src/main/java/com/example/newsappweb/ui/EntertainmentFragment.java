package com.example.newsappweb.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.newsappweb.base.BaseFragment;
import com.example.newsappweb.common.Resource;
import com.example.newsappweb.data.model.MainResponce;
import com.example.newsappweb.databinding.FragmentEntertainmentBinding;
import com.example.newsappweb.viewmodel.Entertainment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class EntertainmentFragment extends BaseFragment<FragmentEntertainmentBinding> {
    private Entertainment viewModel;
    private NewsAdapter adapter;

    @Override
    protected FragmentEntertainmentBinding bind() {
        return FragmentEntertainmentBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity())
                .get(Entertainment.class);
        adapter = new NewsAdapter();
        binding.recycler.setAdapter(adapter);
    }

    @Override
    protected void callRequests() {
        viewModel.getEntertain();
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        viewModel.liveData.observe(getViewLifecycleOwner(), new Observer<Resource<MainResponce>>() {
            @Override
            public void onChanged(Resource<MainResponce> resource) {
                switch (resource.status) {
                    case LOADING: {
                        //TODO Add progress
                        break;
                    }
                    case SUCCESS: {
                        adapter.setNewsList(resource.data.getArticles());
                        break;
                    }
                    case ERROR: {
                        Snackbar.make(binding.getRoot(),
                                resource.msg,
                                BaseTransientBottomBar.LENGTH_LONG);
                        break;
                    }
                }
            }
        });
    }
}