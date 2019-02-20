package com.example.galax.simplemovieapp.screens.movie.list_movie;

import android.support.v7.widget.LinearLayoutManager;

import android.view.View;



import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.screens.movie.base_movie.BaseMovieView;
import com.squareup.otto.Bus;

import java.util.List;

public class ListMovieView extends BaseMovieView {


    private ListMovieAdapter adapter;

    public ListMovieView(View root, Bus bus) {
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
        LinearLayoutManager llm = new LinearLayoutManager(getRoot().getContext(),LinearLayoutManager.VERTICAL,false);
        adapter = new ListMovieAdapter(movies, getBus());
        getSearchResult().setLayoutManager(llm);
        getSearchResult().setAdapter(adapter);
    }
}
