package com.example.seqrity.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.seqrity.Interfaces.Login.LoginPresenter;
import com.example.seqrity.Interfaces.Login.LoginView;
import com.example.seqrity.Presenter.LoginPresenterImpl;
import com.example.seqrity.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private EditText et_1,et_2;
    private ProgressBar progressBar;
    private LoginPresenter loginPresenter;
    FirebaseAuth firebaseAuth;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();


        et_1 = (EditText) findViewById(R.id.editText);
        et_2 = (EditText) findViewById(R.id.editText2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        loginPresenter = new LoginPresenterImpl(this);

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setErrorUser() {
        et_1.setError("user vacio");

    }

    @Override
    public void setErrorPassword() {
        et_2.setError("password vacio");

    }

    @Override
    public void navigateToHome() {
        user = et_1.getText().toString();
        startActivity(new Intent(this,PrincipalActivity.class).putExtra("user",user));

    }

    public void validate(View view){
        loginPresenter.validarUsuario(et_1.getText().toString(),et_2.getText().toString());

    }

}
