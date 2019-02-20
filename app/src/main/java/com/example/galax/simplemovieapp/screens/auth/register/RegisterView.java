package com.example.galax.simplemovieapp.screens.auth.register;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.App;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;

public class RegisterView implements RegisterContract.View {

    private View root;

    private EditText loginInput;
    private EditText passwordInput;
    private View confirmBtn;

    private EditText confirmPassword;

    public RegisterView(View root) {
        this.root = root;
        initView();
    }

    private void initView() {
        loginInput = root.findViewById(R.id.login);
        passwordInput = root.findViewById(R.id.password);
        confirmBtn = root.findViewById(R.id.confirm_btn);
        confirmPassword = root.findViewById(R.id.confirm_password);

    }

    @Override
    public String getLoginText() {
        return loginInput.getText().toString().trim();
    }

    @Override
    public void setLoginInputError(String error) {
        loginInput.setError(error);
    }

    @Override
    public String getPasswordText() {
        return passwordInput.getText().toString().trim();
    }

    @Override
    public void setPasswordInputError(String error) {
        passwordInput.setError(error);
    }

    @Override
    public Observable<Object> confirmBtnAction() {
        return RxView.clicks(confirmBtn);
    }


    @Override
    public void showRegisterError() {
        Toast.makeText(App.getInstance().getApplicationContext(), R.string.register_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getConfirmPasswordText() {
        return confirmPassword.getText().toString().trim();
    }

    @Override
    public void setConfirmPasswordError(String error) {
        confirmPassword.setError(error);
    }

    @Override
    public void showExistUserError(String login) {
        Toast.makeText(App.getInstance().getApplicationContext(),
                App.getInstance().getApplicationContext().getString(R.string.user) + " " + login + " " +
                        App.getInstance().getApplicationContext().getString(R.string.user_exist),
                Toast.LENGTH_SHORT).show();
    }
}
