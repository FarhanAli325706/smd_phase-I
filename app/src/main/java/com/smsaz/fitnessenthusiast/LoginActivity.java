package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void toExercises(View view) {
        Intent intent=new Intent(this,ExercieList.class);
        EditText emailView=findViewById(R.id.edit_email);
        EditText passwordView=findViewById(R.id.edit_password);
        String email=emailView.getText().toString();
        String password=passwordView.getText().toString();
        if(email.matches("") || password.matches("")) {
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
        }
        else if(!(Patterns.EMAIL_ADDRESS.matcher(email).matches()))
        {
            Toast.makeText(this, "Enter a valid email.", Toast.LENGTH_SHORT).show();
        }
        else
            startActivity(intent);
    }

    public void toSignup(View view) {
        Intent intent=new Intent(this,SignupActivity.class);
        startActivity(intent);
    }
}
