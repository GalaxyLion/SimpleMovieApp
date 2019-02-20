package com.example.galax.simplemovieapp.screens.movie.base_movie;

import android.os.Bundle;

import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.data.repositories.MovieNetworkRepositoryImpl;
import com.example.galax.simplemovieapp.data.repositories.MovieRepository;
import com.example.galax.simplemovieapp.services.Navigator;
import com.example.galax.simplemovieapp.services.navigation.Screen;
import com.example.galax.simplemovieapp.services.navigation.ScreenType;
import com.example.galax.simplemovieapp.utils.Constants;

import io.reactivex.disposables.CompositeDisposable;

public class BaseMoviePresenter implements BaseMovieContract.BasePresenter {
    private BaseMovieContract.BaseView view;
    private MovieRepository movieRepository;
    private CompositeDisposable subscriptions;
    private Navigator navigator;

    @Override
    public void start(BaseMovieContract.BaseView view) {
        this.view = view;
        movieRepository = new MovieNetworkRepositoryImpl();
        subscriptions = new CompositeDisposable();
        showSearch();

    }


    protected void openDetailsMovie(Movie movie) {
        Bundle args = new Bundle();
        args.putParcelable(Constants.MOVIE, movie);
        navigator.navigateTo(Screen.MOVIE_DETAILS, ScreenType.ACTIVITY, args);
    }

    private void showSearch() {
        subscriptions.add(movieRepository.search().subscribe(
                movies -> {
                    if (movies != null && !movies.isEmpty()) {
                        view.showNetworkError(false);
                        view.setMovieList(movies);
                        view.showMovies(true);
                    } else {
                        view.showNetworkError(true);
                        view.showMovies(false);
                    }
                },
                e->{
                    view.showMovies(false);
                    view.showNetworkError(true);
                }
        ));
    }

    @Override
    public void stop() {
        view = null;
        subscriptions.dispose();
        subscriptions = null;
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
