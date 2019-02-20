package com.example.galax.simplemovieapp.screens.auth.login;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.BaseActivity;
import com.example.galax.simplemovieapp.base.BaseFragment;


public class LoginFragment extends BaseFragment {

    private LoginContract.View view;
    private LoginContract.Presenter presenter;
    private BaseActivity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        view = new LoginView(root);
        activity = (BaseActivity) getActivity();
        presenter = new LoginPresenter();
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.setNavigator(activity.getNavigator());
        presenter.start(view);
        getBus().register(presenter);
        Log.d("OnStart", "OnStart created");
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
        getBus().unregister(presenter);
    }
}
