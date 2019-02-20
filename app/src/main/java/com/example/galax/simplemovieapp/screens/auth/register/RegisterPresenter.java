package com.example.galax.simplemovieapp.screens.auth.register;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.App;
import com.example.galax.simplemovieapp.data.repositories.LoginLocalRepositoryImpl;
import com.example.galax.simplemovieapp.services.Navigator;
import com.example.galax.simplemovieapp.services.login_db.entities.LoginEntity;
import com.example.galax.simplemovieapp.services.navigation.Screen;
import com.example.galax.simplemovieapp.services.navigation.ScreenType;
import com.example.galax.simplemovieapp.utils.Constants;

import io.paperdb.Paper;
import io.reactivex.disposables.CompositeDisposable;

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;
    private Navigator navigator;
    private CompositeDisposable subscriptions;
    private LoginLocalRepositoryImpl loginLocalRepository;
    private LoginEntity login;

    @Override
    public void start(RegisterContract.View view) {
        this.view = view;
        subscriptions = new CompositeDisposable();
        loginLocalRepository = new LoginLocalRepositoryImpl();
        login = new LoginEntity();
        initActions();

    }

    private void initActions() {
        subscriptions.add(view.confirmBtnAction().subscribe(
                o -> {
                    if (validateLogin(view.getLoginText()) && validatePassword(view.getPasswordText())
                            && validateConfirmPassword(view.getConfirmPasswordText(), view.getPasswordText())) {
                        subscriptions.add(loginLocalRepository.getExistUser(view.getLoginText()).subscribe(
                                loginEntity -> {
                                    view.showExistUserError(loginEntity.getLogin());
                                },
                                throwable -> {
                                    login.setLogin(view.getLoginText());
                                    login.setPassword(view.getPasswordText());
                                    loginLocalRepository.saveUser(login).subscribe();
                                    Paper.book().write(Constants.USER_EMAIL, view.getLoginText());
                                    navigator.navigateTo(Screen.MOVIE, ScreenType.ACTIVITY);
                                }
                        ));

                    } else {
                        view.showRegisterError();
                    }
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

    private boolean validateConfirmPassword(String confirmPassword, String password) {
        if (!confirmPassword.equals(password)) {
            view.setConfirmPasswordError(App.getInstance().getApplicationContext().getString(R.string.not_match_password));
            return false;
        } else {
            view.setConfirmPasswordError(null);
            return true;
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
