package com.example.galax.simplemovieapp.screens.auth.login;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.App;
import com.example.galax.simplemovieapp.data.repositories.LoginLocalRepositoryImpl;
import com.example.galax.simplemovieapp.services.Navigator;
import com.example.galax.simplemovieapp.services.navigation.Screen;
import com.example.galax.simplemovieapp.services.navigation.ScreenType;
import com.example.galax.simplemovieapp.utils.Constants;

import io.paperdb.Paper;
import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private Navigator navigator;
    private CompositeDisposable subscriptions;
    private LoginLocalRepositoryImpl localRepository;

    @Override
    public void start(LoginContract.View view) {
        this.view = view;
        subscriptions = new CompositeDisposable();
        localRepository = new LoginLocalRepositoryImpl();
        initActions();

    }

    private void initActions() {
        subscriptions.add(view.confirmBtnAction().subscribe(
                o -> {
                    if (validateLogin(view.getLoginText()) && validatePassword(view.getPasswordText())) {
                        subscriptions.add(localRepository.getExistUser(view.getLoginText()).subscribe(
                                loginEntity -> {
                                    Paper.book().write(Constants.USER_EMAIL, view.getLoginText());
                                    navigator.navigateTo(Screen.MOVIE, ScreenType.ACTIVITY);
                                },
                                throwable -> {
                                    view.showUserNotExistError();

                                }
                        ));

                    } else {
                        view.showLoginError();
                    }
                }
        ));
        subscriptions.add(view.signUpAction().subscribe(
                o -> {
                    navigator.navigateTo(Screen.REGISTER, ScreenType.FRAGMENT);
                }
        ));

    }


    private boolean validatePassword(String password) {
        if (password.length() < 4 || password.length() > 20) {
            view.setPasswordInputError(App.getInstance().getApplicationContext().getString(R.string.password_include));
            return false;
        } else {
            view.setPasswordInputError(null);
            return true;
        }
    }

    private boolean validateLogin(String loginText) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(loginText).matches()) {
            view.setLoginInputError(null);
            return true;
        } else {
            view.setLoginInputError(App.getInstance().getApplicationContext().getString(R.string.invalid_email));
            return false;
        }

    }

    @Override
    public void stop() {
        view = null;
        subscriptions.dispose();
        subscriptions = null;
    }

    @Override
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
