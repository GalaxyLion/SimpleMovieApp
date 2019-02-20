package com.example.galax.simplemovieapp.screens.profile;

import com.example.galax.simplemovieapp.utils.Constants;

import io.paperdb.Paper;

public class ProfilePresenter implements ProfileContract.Presenter {

    private ProfileContract.View view;

    @Override
    public void start(ProfileContract.View view) {
        this.view = view;
        initActions();
    }

    private void initActions() {
        String email = Paper.book().read(Constants.USER_EMAIL);
        view.setEmail(email);
    }

    @Override
    public void stop() {
        view = null;
    }
}
