package com.example.galax.simplemovieapp.data.repositories;

import com.example.galax.simplemovieapp.services.login_db.entities.LoginEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface LoginRepository {
    Completable saveUser(LoginEntity loginEntity);
    Maybe<List<LoginEntity>> getUsers();
    Single<LoginEntity> getExistUser(String login);
}
