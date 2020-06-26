package com.example.seqrity.Interactor;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.seqrity.Interfaces.Login.LoginInteractor;
import com.example.seqrity.Interfaces.Login.LoginListener;
import com.example.seqrity.Interfaces.Login.LoginView;
import com.example.seqrity.View.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginInteractorImpl implements LoginInteractor {

    FirebaseAuth firebaseAuth;

    @Override
    public void validarUsuario(String user, String pass, final LoginListener listener) {
        firebaseAuth = FirebaseAuth.getInstance();

        if(!user.equals("")&&!pass.equals("")){
            firebaseAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){
                        listener.login();

                    }else{
                        listener.usernameError();
                        listener.passwordnameError();
                    }
                }
            });
//            listener.login();

        }else{
            if(user.equals("")){
                listener.usernameError();
            }
            if(pass.equals("")){
                listener.passwordnameError();
            }
        }
    }


}
