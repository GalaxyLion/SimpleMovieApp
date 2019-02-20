package com.example.galax.simplemovieapp.data.mappers;

import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.services.rest.dto.ResultsItem;

public class MovieDtoMapper implements Mapper<ResultsItem, Movie> {

    @Override
    public Movie from(ResultsItem data) {
        return new Movie(
                data.getOverview(),
                data.getOriginalLanguage(),
                data.getTitle(),
                data.getPosterPath(),
                data.getReleaseDate(),
                data.getVoteAverage(),
                data.getPopularity()
                );
    }

    @Override
    public ResultsItem to(Movie model) {
        return null;
    }
}
