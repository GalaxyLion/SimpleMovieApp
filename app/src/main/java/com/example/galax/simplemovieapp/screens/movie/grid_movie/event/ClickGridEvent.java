package com.example.galax.simplemovieapp.screens.movie.grid_movie.event;

import com.example.galax.simplemovieapp.data.models.Movie;

public class ClickGridEvent {
    private Movie movie;

    public ClickGridEvent(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
