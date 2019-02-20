package com.example.galax.simplemovieapp.screens.movie.list_movie.event;

import com.example.galax.simplemovieapp.data.models.Movie;

public class ClickListEvent {
    private Movie movie;

    public ClickListEvent(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
