package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void toExercises(View view) {
        Intent intent=new Intent(this,ExercieList.class);
        startActivity(intent);
    }

    public void toSignup(View view) {
        Intent intent=new Intent(this,SignupActivity.class);
        startActivity(intent);
    }
}
