package com.example.galax.simplemovieapp.screens.movie;

import com.example.galax.simplemovieapp.services.Navigator;

import java.util.List;

import io.reactivex.Observable;

public interface MovieContract {
    interface View{
        Observable <Object> profileBtnAction();
        Observable <Object> logoutBtnAction();
        void showToast();
    }
    interface Presenter{
        void start(View view);
        void stop();
        void setNavigator(Navigator navigator);
    }
}
