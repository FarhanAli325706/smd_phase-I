package com.smsaz.fitnessenthusiast.login.model;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.smsaz.fitnessenthusiast.login.presenter.ILoginPresenter;
import com.smsaz.fitnessenthusiast.login.view.LoginActivity;
import com.smsaz.store_in_shared_preferences_and_cache.SharedPreferencesAndCacheHandler;

public class LoginModel {

    private FirebaseAuth firebaseAuth;
    private ILoginPresenter loginPresenter;

    public void addPresenter(ILoginPresenter iLoginPresenter) {
        this.loginPresenter = iLoginPresenter;
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void authenticate(String username, String password) {

        firebaseAuth.signInWithEmailAndPassword(username, password).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            loginPresenter.validated(true,"Welcome to Fitness Enthusiast");
                        } else {
                            if (task.getException() != null)
                                loginPresenter.validated(false,"Error While Logging In\n" + task.getException().getMessage());
                        }
                    }
                });


    }

}
