package com.example.galax.simplemovieapp.screens.auth;

import android.os.Bundle;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.BaseActivity;
import com.example.galax.simplemovieapp.services.navigation.Screen;
import com.example.galax.simplemovieapp.services.navigation.ScreenType;
import com.example.galax.simplemovieapp.utils.Constants;

import io.paperdb.Paper;

public class AuthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        if (Paper.book().read(Constants.USER_EMAIL) != null) {
            getNavigator().navigateTo(Screen.MOVIE, ScreenType.ACTIVITY);
        } else {
            getNavigator().navigateTo(Screen.LOGIN, ScreenType.FRAGMENT);
        }
    }
}
