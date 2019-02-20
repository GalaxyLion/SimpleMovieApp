package com.example.galax.simplemovieapp.screens.auth.register;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.BaseActivity;
import com.example.galax.simplemovieapp.base.BaseFragment;

public class RegisterFragment extends BaseFragment {

    private RegisterContract.View view;
    private RegisterContract.Presenter presenter;
    private BaseActivity activity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_register, container, false);
        view = new RegisterView(root);
        presenter = new RegisterPresenter();
        activity = (BaseActivity) getActivity();
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        getBus().register(presenter);
        presenter.setNavigator(activity.getNavigator());
        presenter.start(view);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stop();
        getBus().unregister(presenter);
    }
}
