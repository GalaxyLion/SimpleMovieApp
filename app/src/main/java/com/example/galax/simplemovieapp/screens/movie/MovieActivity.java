package com.example.galax.simplemovieapp.screens.movie;


import android.os.Bundle;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.BaseActivity;
import com.example.galax.simplemovieapp.screens.movie.MovieContract;
import com.example.galax.simplemovieapp.screens.movie.MoviePresenter;
import com.example.galax.simplemovieapp.screens.movie.MovieView;


public class MovieActivity extends BaseActivity {

    private MovieContract.View view;
    private MovieContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        view = new MovieView(findViewById(R.id.movie_content),findViewById(R.id.drawer),this);
        presenter = new MoviePresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setNavigator(getNavigator());
        presenter.start(view);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }


}
