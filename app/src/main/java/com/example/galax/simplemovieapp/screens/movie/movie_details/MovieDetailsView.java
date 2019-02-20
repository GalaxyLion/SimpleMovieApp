package com.example.galax.simplemovieapp.screens.movie.movie_details;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.data.models.Movie;
import com.squareup.picasso.Picasso;

public class MovieDetailsView implements MovieDetailsContract.View{

    private View root;

    private ImageView poster;
    private TextView title;
    private RatingBar rating;
    private TextView releaseDate;
    private TextView synopsis;
    private TextView language;
    private TextView popularity;
    private TextView networkError;

    public MovieDetailsView(View root) {
        this.root = root;
        initView();
    }

    private void initView() {
        poster = root.findViewById(R.id.poster);
        title = root.findViewById(R.id.title);
        rating = root.findViewById(R.id.rating);
        releaseDate = root.findViewById(R.id.release_date);
        synopsis = root.findViewById(R.id.description);
        language = root.findViewById(R.id.language);
        popularity = root.findViewById(R.id.popularity_average);
        networkError = root.findViewById(R.id.network_error);
    }

    @Override
    public void setMovie(Movie movie) {
        Picasso.get()
                .load(movie.getPosterPath())
                .into(poster);
        title.setText(movie.getTitle());
        rating.setRating((float) movie.getVoteAverage());
        releaseDate.setText(movie.getReleaseDate());
        synopsis.setText(movie.getOverview());
        language.setText(movie.getOriginalLanguage());
        popularity.setText(Double.toString(movie.getPopularity()));

    }

    @Override
    public void showNetworkError(boolean show) {
        networkError.setVisibility(show?View.VISIBLE:View.GONE);
    }

    @Override
    public void showMovie(boolean show) {
        root.setVisibility(show?View.VISIBLE:View.GONE);
    }
}
