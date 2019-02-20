package com.example.galax.simplemovieapp.screens.auth.login;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.galax.simplemovieapp.R;
import com.example.galax.simplemovieapp.base.App;
import com.jakewharton.rxbinding2.view.RxView;

import io.reactivex.Observable;

public class LoginView implements LoginContract.View {

    private View root;
    private EditText loginInput;
    private EditText passwordInput;
    private View confirmBtn;
    private TextView signUpState;

    public LoginView(View root) {
        this.root = root;
        initView();
    }

    private void initView() {
        loginInput = root.findViewById(R.id.login);
        passwordInput = root.findViewById(R.id.password);
        confirmBtn = root.findViewById(R.id.confirm_btn);
        signUpState = root.findViewById(R.id.sign_up_state);

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
        return  RxView.clicks(confirmBtn);
    }

    @Override
    public Observable<Object> signUpAction() {
        return RxView.clicks(signUpState);
    }

    @Override
    public void showLoginError() {
        Toast.makeText(App.getInstance().getApplicationContext(), R.string.login_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserNotExistError() {
        Toast.makeText(App.getInstance().getApplicationContext(),
                App.getInstance().getApplicationContext().getString(R.string.user) + " " +
                        App.getInstance().getApplicationContext().getString(R.string.user_not_exist),
                Toast.LENGTH_SHORT).show();
    }
}
