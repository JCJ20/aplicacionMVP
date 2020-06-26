package com.example.seqrity.Interfaces.Login;

public interface LoginInteractor {
    void validarUsuario(String user, String pass, LoginListener listener);

}
