package com.example.galax.simplemovieapp.screens.movie.list_movie;

import android.os.Bundle;

import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.screens.movie.base_movie.BaseMovieContract;
import com.example.galax.simplemovieapp.screens.movie.base_movie.BaseMoviePresenter;
import com.example.galax.simplemovieapp.screens.movie.list_movie.event.ClickListEvent;
import com.example.galax.simplemovieapp.services.Navigator;

import com.squareup.otto.Subscribe;


public class ListMoviePresenter extends BaseMoviePresenter{

    @Override
    public void start(BaseMovieContract.BaseView view) {
        super.start(view);
    }

    @Subscribe
    public void onEvent(ClickListEvent clickListEvent) {
        openDetailsMovie(clickListEvent.getMovie());
    }

    @Override
    protected void openDetailsMovie(Movie movie) {
        super.openDetailsMovie(movie);
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void setNavigator(Navigator navigator) {
        super.setNavigator(navigator);
    }
}
