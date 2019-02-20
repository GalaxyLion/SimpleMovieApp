package com.example.galax.simplemovieapp.services.login_db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.galax.simplemovieapp.services.login_db.entities.LoginEntity;

@Database(entities = {LoginEntity.class}, version = 1, exportSchema = false)
public abstract class LoginDB extends RoomDatabase{
    public abstract DaoAccess daoAcces();

}
