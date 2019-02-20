package com.example.galax.simplemovieapp.data.repositories;

import com.example.galax.simplemovieapp.data.models.Movie;
import com.example.galax.simplemovieapp.services.login_db.entities.LoginEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface MovieRepository {
    Observable<List<Movie>> search();

}
