package com.example.seqrity.Interfaces.Login;

public interface LoginView {
    void showProgress();
    void hideProgress();

    void setErrorUser();
    void setErrorPassword();

    void navigateToHome();
}
