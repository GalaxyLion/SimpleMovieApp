package com.example.galax.simplemovieapp.services.navigation.factories;

import android.app.Activity;
import android.content.Intent;

import com.example.galax.simplemovieapp.screens.auth.AuthActivity;
import com.example.galax.simplemovieapp.screens.movie.MovieActivity;
import com.example.galax.simplemovieapp.screens.movie.movie_details.MovieDetailsActivity;
import com.example.galax.simplemovieapp.base.App;
import com.example.galax.simplemovieapp.screens.profile.ProfileActivity;
import com.example.galax.simplemovieapp.services.navigation.Screen;


public class ScreenActivityFactory {

    public Intent getActivityByType(Screen screen){
        return new Intent(App.getInstance(),getActivityClassByType(screen));
    }

    private Class<? extends Activity> getActivityClassByType(Screen screen){
        switch (screen){
            case AUTH:
                return AuthActivity.class;
            case MOVIE:
                return MovieActivity.class;
            case MOVIE_DETAILS:
                return MovieDetailsActivity.class;
            case PROFILE:
                return ProfileActivity.class;

                default:return AuthActivity.class;
        }
    }

}
