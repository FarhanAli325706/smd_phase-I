package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.servicemusicplayer.MusicPlayerService;
import com.facebook.stetho.Stetho;
import com.smsaz.fitnessenthusiast.login.view.LoginActivity;
import com.smsaz.retrofit_communication.RetrofitCommunicator;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        this.getSupportActionBar().hide();
        // TODO: 12/2/2019 Change title name of each activity

        Stetho.initializeWithDefaults(this);

        RetrofitCommunicator retrofitCommunicator = new RetrofitCommunicator();
        retrofitCommunicator.startCommunication(getBaseContext());
    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, MusicPlayerService.class));
    }

    public void toLogin(View view) {
        stopService(new Intent(this, MusicPlayerService.class));
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void toExercises(View view) {
        stopService(new Intent(this, MusicPlayerService.class));
        Intent intent=new Intent(this,ExercieList.class);
        startActivity(intent);
    }
}
