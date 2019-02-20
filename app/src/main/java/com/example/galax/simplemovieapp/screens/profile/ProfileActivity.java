package com.example.galax.simplemovieapp.screens.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.galax.simplemovieapp.R;

public class ProfileActivity extends AppCompatActivity {

    private ProfileContract.View view;
    private ProfileContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        view = new ProfileView(findViewById(R.id.content_frame));
        presenter = new ProfilePresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start(view);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
    }
}
