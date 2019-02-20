package com.example.galax.simplemovieapp.screens.auth.login;

import com.example.galax.simplemovieapp.services.Navigator;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;

public interface LoginContract {
    interface View{
        String getLoginText();
        void setLoginInputError(@Nullable String error);
        String getPasswordText();
        void setPasswordInputError(@Nullable String error);
        Observable<Object> confirmBtnAction();
        Observable<Object> signUpAction();
        void showLoginError();
        void showUserNotExistError();

    }
    interface Presenter{
        void start(View view);
        void stop();
        void setNavigator(Navigator navigator);
    }
}
