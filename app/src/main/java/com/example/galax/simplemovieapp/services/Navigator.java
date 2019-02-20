package com.example.galax.simplemovieapp.services;

import android.os.Bundle;

import com.example.galax.simplemovieapp.services.navigation.Screen;
import com.example.galax.simplemovieapp.services.navigation.ScreenType;


public interface Navigator {
    void navigateTo(Screen screen, ScreenType type);
    void navigateTo(Screen screen, ScreenType type, Bundle args);
}
