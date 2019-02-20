package com.example.galax.simplemovieapp.screens.movie.grid_movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.BaseActivity;
import com.example.galax.simplemovieapp.base.BaseFragment;
import com.example.galax.simplemovieapp.screens.movie.base_movie.BaseMovieContract;
import com.example.galax.simplemovieapp.screens.movie.grid_movie.GridMoviePresenter;
import com.example.galax.simplemovieapp.screens.movie.grid_movie.GridMovieView;


public class GridMovieFragment extends BaseFragment {

    private BaseMovieContract.BaseView view;
    private BaseMovieContract.BasePresenter presenter;
    private BaseActivity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_grid_movie, container, false);
        activity = (BaseActivity) getActivity();
        view = new GridMovieView(root, getBus());
        presenter = new GridMoviePresenter();
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.setNavigator(activity.getNavigator());
        presenter.start(view);
        getBus().register(presenter);
    }

    @Override
    public void onStop() {
        super.onStop();
        getBus().unregister(presenter);
        presenter.stop();
    }
}
