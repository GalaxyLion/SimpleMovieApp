package com.example.galax.simplemovieapp.services.login_db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.galax.simplemovieapp.services.login_db.entities.LoginEntity;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface DaoAccess {

    @Insert
    void insertUser(LoginEntity loginEntity);

    @Query("SELECT * FROM LoginEntity")
    Maybe<List<LoginEntity>> getUsers();

    @Query("SELECT * FROM LoginEntity WHERE login = :login LIMIT 1")
    Single<LoginEntity> getExistUser(String login);
}
