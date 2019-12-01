package com.smsaz.fitnessenthusiast.login.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smsaz.fitnessenthusiast.ExercieList;
import com.smsaz.fitnessenthusiast.R;
import com.smsaz.fitnessenthusiast.login.model.LoginModel;
import com.smsaz.fitnessenthusiast.login.presenter.LoginPresenter;
import com.smsaz.fitnessenthusiast.signup.SignupActivity;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {

    //TODO: Implement Back Button in Login Activity

    private Intent exerciesIntent;
    private LoginPresenter loginPresenter;
    private LoginModel loginModel;

    EditText emailView, passwordView;
    FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        emailView = findViewById(R.id.edit_email);
        passwordView = findViewById(R.id.edit_password);

        exerciesIntent = new Intent(this, ExercieList.class);

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "You are already logged in", Toast.LENGTH_SHORT).show();
                    startActivity(exerciesIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Please Login to Continue", Toast.LENGTH_SHORT).show();
                }
            }
        };


    }

    public void toExercises(View view) {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        if (email.matches("") || password.matches("")) {
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
        } else if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            Toast.makeText(this, "Enter a valid email.", Toast.LENGTH_SHORT).show();
        } else {
            //Calling Presenter's methods
            loginModel = new LoginModel();
            loginPresenter = new LoginPresenter(this, loginModel);
            loginPresenter.validate(email, password);
        }

    }

    public void toSignup(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToExercises() {
        Toast.makeText(this, "Welcome to Fitness Enthusiast", Toast.LENGTH_SHORT).show();
        startActivity(exerciesIntent);
        //Put current user in cache
    }

    @Override
    public void showErrorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
