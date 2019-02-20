package com.example.galax.simplemovieapp.screens.movie.grid_movie;

import android.support.v7.widget.GridLayoutManager;

import android.view.View;

import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.screens.movie.base_movie.BaseMovieView;
import com.squareup.otto.Bus;


import java.util.List;

public class GridMovieView extends BaseMovieView{


    private GridMovieAdapter adapter;

    public GridMovieView(View root, Bus bus) {
        super(root, bus);
    }

    @Override
    public void showNetworkError(boolean show) {
        super.showNetworkError(show);
    }

    @Override
    public void showMovies(boolean show) {
        super.showMovies(show);
    }

    @Override
    public void setMovieList(List<Movie> movies) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getRoot().getContext(), 3, GridLayoutManager.VERTICAL,false);
        adapter = new GridMovieAdapter(movies, getBus());
        getSearchResult().setLayoutManager(gridLayoutManager);
        getSearchResult().setAdapter(adapter);
    }
}
