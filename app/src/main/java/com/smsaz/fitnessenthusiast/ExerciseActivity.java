package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        VideoView exerciseVideo = findViewById(R.id.exerciseVideo);

        Uri uri = Uri.parse("android.resource://com.smsaz.fitnessenthusiast/"+R.raw.vid);

        exerciseVideo.setVideoURI(uri);
        exerciseVideo.start();

        exerciseVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }

    String checkVideo(){
        String path = null;

        //TODO: Check which video path should be returned

        //        if(getIntent().hasExtra(""))
//        {
//
//        }

        return path;
    }
}
