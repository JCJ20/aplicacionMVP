package com.example.seqrity.Presenter;

import com.example.seqrity.Interactor.LoginInteractorImpl;
import com.example.seqrity.Interfaces.Login.LoginInteractor;
import com.example.seqrity.Interfaces.Login.LoginListener;
import com.example.seqrity.Interfaces.Login.LoginPresenter;
import com.example.seqrity.Interfaces.Login.LoginView;

public class LoginPresenterImpl implements LoginPresenter, LoginListener {
    private LoginView loginview;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginview) {
        this.loginview = loginview;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validarUsuario(String user, String password) {
        if(loginview != null){
            loginview.showProgress();
        }
        loginInteractor.validarUsuario(user,password,this);
    }

    @Override
    public void usernameError() {
        if(loginview!=null){
            loginview.hideProgress();
            loginview.setErrorUser();
        }
    }

    @Override
    public void passwordnameError() {
        if(loginview != null){
            loginview.hideProgress();
            loginview.setErrorPassword();
        }
    }

    @Override
    public void login() {
        if(loginview != null){
            loginview.hideProgress();
            loginview.navigateToHome();
        }
    }
}
