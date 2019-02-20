package com.example.galax.simplemovieapp.screens.movie.base_movie;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.screens.movie.grid_movie.GridMovieAdapter;
import com.squareup.otto.Bus;

import java.util.List;

public class BaseMovieView implements BaseMovieContract.BaseView {

    private View root;
    private RecyclerView searchResult;
    private TextView networkError;
    private Bus bus;


    public BaseMovieView(View root, Bus bus) {
        this.root = root;
        this.bus = bus;
        initView();
    }

    private void initView() {
        searchResult = root.findViewById(R.id.movie_list);
        networkError = root.findViewById(R.id.network_error);
    }

    @Override
    public void showNetworkError(boolean show) {
        networkError.setVisibility(show?View.VISIBLE:View.GONE);
    }

    @Override
    public void showMovies(boolean show) {
        searchResult.setVisibility(show?View.VISIBLE:View.GONE);
    }

    @Override
    public void setMovieList(List<Movie> movies) {

    }

    public View getRoot() {
        return root;
    }

    public RecyclerView getSearchResult() {
        return searchResult;
    }

    public Bus getBus() {
        return bus;
    }
}
