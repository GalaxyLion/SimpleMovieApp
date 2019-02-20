package com.example.galax.simplemovieapp.screens.movie.base_movie;

import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.services.Navigator;

import java.util.List;

public interface BaseMovieContract {
    interface BaseView{
        void setMovieList(List<Movie> movies);
        void showNetworkError(boolean show);
        void showMovies(boolean show);
    }
    interface BasePresenter{
        void start(BaseMovieContract.BaseView view);
        void setNavigator(Navigator navigator);
        void stop();
    }
}
