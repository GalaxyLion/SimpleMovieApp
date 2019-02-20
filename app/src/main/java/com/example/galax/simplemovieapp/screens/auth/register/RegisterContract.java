package com.example.galax.simplemovieapp.screens.auth.register;

import com.example.galax.simplemovieapp.screens.auth.login.LoginContract;
import com.example.galax.simplemovieapp.services.Navigator;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;

public interface RegisterContract {
    interface View{
        String getLoginText();
        void setLoginInputError(@Nullable String error);
        String getPasswordText();
        void setPasswordInputError(@Nullable String error);
        void setConfirmPasswordError(@Nullable String error);
        String getConfirmPasswordText();
        Observable<Object> confirmBtnAction();
        void showRegisterError();
        void showExistUserError(String login);

    }
    interface Presenter{
        void start(RegisterContract.View view);
        void stop();
        void setNavigator(Navigator navigator);
    }
}
