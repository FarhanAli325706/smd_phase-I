package com.smsaz.fitnessenthusiast.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void toExercises(View view) {
        exerciesIntent = new Intent(this, ExercieList.class);

        EditText emailView = findViewById(R.id.edit_email);
        EditText passwordView = findViewById(R.id.edit_password);

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
        startActivity(exerciesIntent);
        //Put current user in cache
    }

    @Override
    public void showErrorToast() {
        Toast.makeText(this, "WRONG ID OR PASSWORD", Toast.LENGTH_SHORT).show();
    }
}
