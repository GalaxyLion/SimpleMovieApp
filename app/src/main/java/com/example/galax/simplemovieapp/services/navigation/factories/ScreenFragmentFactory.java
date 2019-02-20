package com.example.galax.simplemovieapp.services.navigation.factories;


import android.support.v4.app.Fragment;

import com.example.galax.simplemovieapp.screens.auth.login.LoginFragment;
import com.example.galax.simplemovieapp.screens.auth.register.RegisterFragment;
import com.example.galax.simplemovieapp.base.App;
import com.example.galax.simplemovieapp.services.navigation.Screen;


public class ScreenFragmentFactory {

    public Fragment getFragmentByType(Screen screen){
        Class<? extends Fragment> clazz = getFragmentClassByType(screen);
        return Fragment.instantiate(App.getInstance(),clazz.getName());
    }

    public Class<? extends Fragment> getFragmentClassByType(Screen screen) {
        switch (screen){
            case LOGIN:
                return LoginFragment.class;
            case REGISTER:
                return RegisterFragment.class;

                default: return  LoginFragment.class;
        }
    }
}
