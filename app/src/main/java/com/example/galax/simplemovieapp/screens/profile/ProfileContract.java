package com.example.galax.simplemovieapp.screens.profile;

import android.widget.TextView;

public interface ProfileContract {
    interface View{
        void setEmail(String email);
    }
    interface  Presenter{
        void start(View view);
        void stop();
    }
}
