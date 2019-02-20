package com.example.galax.simplemovieapp.screens.movie.movie_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.BaseActivity;
import com.example.galax.simplemovieapp.base.BaseFragment;
import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.screens.movie.movie_details.MovieDetailsContract;
import com.example.galax.simplemovieapp.screens.movie.movie_details.MovieDetailsPresenter;
import com.example.galax.simplemovieapp.screens.movie.movie_details.MovieDetailsView;
import com.example.galax.simplemovieapp.utils.Constants;


public class MovieDetailsActivity extends BaseActivity {

    private MovieDetailsContract.View view;
    private MovieDetailsContract.Presenter presenter;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Bundle args = getIntent().getExtras();

        if(args.getParcelable(Constants.MOVIE)!=null){
            movie = args.getParcelable(Constants.MOVIE);
        }
        view = new MovieDetailsView(findViewById(R.id.content_frame));
        presenter = new MovieDetailsPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start(view, movie);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
    }
}
