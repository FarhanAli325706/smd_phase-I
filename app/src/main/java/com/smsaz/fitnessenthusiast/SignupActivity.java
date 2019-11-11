package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);

        EditText usernameView = findViewById(R.id.usernameSignup);
        EditText emailView = findViewById(R.id.emailSignup);
        EditText passwordView = findViewById(R.id.passwordSignup);
        EditText confirmPasswordView = findViewById(R.id.confirmPasswordSignup);

        String username = usernameView.getText().toString();
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();
        String confirmPassword = confirmPasswordView.getText().toString();

        if (username.matches("") || email.matches("") ||
                password.matches("") || confirmPassword.matches("")) {
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid Email", Toast.LENGTH_SHORT).show();
        } else if (!password.matches(confirmPassword)){
            Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(intent);
        }
    }

}
