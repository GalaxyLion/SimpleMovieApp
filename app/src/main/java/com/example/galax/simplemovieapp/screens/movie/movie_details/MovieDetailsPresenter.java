package com.example.galax.simplemovieapp.screens.movie.movie_details;

import com.example.galax.simplemovieapp.data.models.Movie;

public class MovieDetailsPresenter implements MovieDetailsContract.Presenter {

    private MovieDetailsContract.View view;
    private Movie movie;



    @Override
    public void start(MovieDetailsContract.View view, Movie movie) {
        this.view = view;
        this.movie = movie;
        showMovieDetails();
    }

    private void showMovieDetails() {
        if(movie != null ){
            view.showNetworkError(false);
            view.setMovie(movie);
            view.showMovie(true);
        }else{
            view.showNetworkError(true);
            view.showMovie(false);
        }

    }

    @Override
    public void stop() {
        view = null;
    }
}
