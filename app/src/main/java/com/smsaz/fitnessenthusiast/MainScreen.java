package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.smsaz.fitnessenthusiast.login.view.LoginActivity;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        this.getSupportActionBar().hide();
    }

    public void toLogin(View view) {
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void toExercises(View view) {
        Intent intent=new Intent(this,ExercieList.class);
        startActivity(intent);
    }
}
