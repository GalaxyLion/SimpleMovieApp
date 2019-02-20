package com.example.galax.simplemovieapp.data.repositories;

import com.example.galax.simplemovieapp.data.mappers.MovieDtoMapper;
import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.services.login_db.entities.LoginEntity;
import com.example.galax.simplemovieapp.services.rest.RestAPI;
import com.example.galax.simplemovieapp.services.rest.RestClien;
import com.example.galax.simplemovieapp.services.rest.dto.ResultsItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieNetworkRepositoryImpl implements MovieRepository {

    private RestAPI restApi;
    private MovieDtoMapper movieDtoMapper;
    private String lang;

    public MovieNetworkRepositoryImpl() {
        restApi = RestClien.createApi();
        movieDtoMapper = new MovieDtoMapper();
        lang = Locale.getDefault().getLanguage();
    }

    @Override
    public Observable<List<Movie>> search() {
        return restApi.search(lang)
                .map(
                        it->{
                            List<Movie> movies = new ArrayList<>();
                            if(it.getResults()!=null){
                                for (ResultsItem item: it.getResults()) {
                                    movies.add(movieDtoMapper.from(item));
                                }
                            }
                            return movies;
                        }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
