package com.example.galax.simplemovieapp.screens.movie.movie_details;

import com.example.galax.simplemovieapp.data.models.Movie;

import java.util.List;

public interface MovieDetailsContract {
    interface View{
        void setMovie(Movie movie);
        void showNetworkError(boolean show);
        void showMovie(boolean show);
    }
    interface Presenter{
        void start(View view, Movie movie);
        void stop();
    }
}
