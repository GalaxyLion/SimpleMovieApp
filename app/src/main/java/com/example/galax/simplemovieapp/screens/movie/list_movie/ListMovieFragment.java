package com.example.galax.simplemovieapp.screens.movie.list_movie;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.BaseActivity;
import com.example.galax.simplemovieapp.base.BaseFragment;
import com.example.galax.simplemovieapp.screens.movie.base_movie.BaseMovieContract;
import com.example.galax.simplemovieapp.screens.movie.list_movie.ListMoviePresenter;
import com.example.galax.simplemovieapp.screens.movie.list_movie.ListMovieView;


public class ListMovieFragment extends BaseFragment {

    private BaseMovieContract.BaseView view;
    private BaseMovieContract.BasePresenter presenter;
    private BaseActivity activity;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_movie, container, false);
        view = new ListMovieView(root, getBus());
        activity = (BaseActivity) getActivity();
        presenter = new ListMoviePresenter();
        return root;

    }

    @Override
    public void onStart() {
        super.onStart();
        getBus().register(presenter);
        presenter.setNavigator(activity.getNavigator());
        presenter.start(view);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
        getBus().unregister(presenter);
    }
}
