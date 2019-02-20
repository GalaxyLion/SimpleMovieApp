package com.example.galax.simplemovieapp.screens.movie;

import com.example.galax.simplemovieapp.services.Navigator;
import com.example.galax.simplemovieapp.services.navigation.Screen;
import com.example.galax.simplemovieapp.services.navigation.ScreenType;
import com.example.galax.simplemovieapp.utils.Constants;

import io.paperdb.Paper;
import io.reactivex.disposables.CompositeDisposable;

public class MoviePresenter implements MovieContract.Presenter {
    private MovieContract.View view;
    private CompositeDisposable subscriptions;
    private Navigator navigator;


    @Override
    public void start(MovieContract.View view) {
        this.view = view;
        subscriptions = new CompositeDisposable();

        initActions();
    }

    private void initActions() {
        subscriptions.add(view.profileBtnAction().subscribe(
                o ->  navigator.navigateTo(Screen.PROFILE, ScreenType.ACTIVITY)
        ));
        subscriptions.add(view.logoutBtnAction().subscribe(
                o-> {
                    Paper.book().delete(Constants.USER_EMAIL);
                    navigator.navigateTo(Screen.AUTH, ScreenType.ACTIVITY);

                }
        ));
    }

    @Override
    public void stop() {
        view = null;
        subscriptions.dispose();
        subscriptions = null;
    }
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
