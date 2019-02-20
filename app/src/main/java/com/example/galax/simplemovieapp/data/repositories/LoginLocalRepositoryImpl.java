package com.example.galax.simplemovieapp.data.repositories;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.example.galax.simplemovieapp.base.App;
import com.example.galax.simplemovieapp.services.login_db.LoginDB;
import com.example.galax.simplemovieapp.services.login_db.entities.LoginEntity;
import com.example.galax.simplemovieapp.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class LoginLocalRepositoryImpl implements LoginRepository {
    private LoginDB loginDB;

    public LoginLocalRepositoryImpl() {
        this.loginDB = Room.databaseBuilder(App.getInstance().getApplicationContext(),
                LoginDB.class, Constants.DATABASE_NAME).build();
    }

    @Override
    public Completable saveUser(LoginEntity loginEntity) {
        return Completable.fromAction(
                () -> {
                    loginDB.daoAcces().insertUser(loginEntity);
                }
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Maybe<List<LoginEntity>> getUsers() {
        return loginDB.daoAcces().getUsers()
                .map(
                        it -> {
                            List<LoginEntity> loginEntities = new ArrayList<>();
                            for (LoginEntity login : it) {
                                loginEntities.add(login);
                            }
                            return loginEntities;
                        }
                ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<LoginEntity> getExistUser(String login) {
        return loginDB.daoAcces().getExistUser(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn(throwable -> null)
               /* .doOnSuccess(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        return;
                    }
                })*/;
    }
}
