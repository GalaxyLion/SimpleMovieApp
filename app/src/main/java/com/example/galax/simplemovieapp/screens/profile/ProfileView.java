package com.example.galax.simplemovieapp.screens.profile;

import android.view.View;
import android.widget.TextView;

import com.example.galax.simplemovieapp.R;

public class ProfileView implements ProfileContract.View {

    private View root;
    private TextView email;

    public ProfileView(View root) {
        this.root = root;
        initView();
    }

    private void initView() {
        email = root.findViewById(R.id.email);
    }

    @Override
    public void setEmail(String userEmail) {
        email.setText(userEmail);
    }
}
