package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class ExerciseActivity extends AppCompatActivity {

    Uri uri;
    TextView name;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        name=findViewById(R.id.exerciseTitle);
        description=findViewById(R.id.description);
        VideoView exerciseVideo = findViewById(R.id.exerciseVideo);
        if(getIntent().hasExtra("e_name"))
        {
            String exercise_name=getIntent().getStringExtra("e_name");
            String exercise_description=getIntent().getStringExtra("e_description");
            int exercise_video=getIntent().getIntExtra("e_video",0);
            name.setText(exercise_name);
            description.setText(exercise_description);
            uri = Uri.parse("android.resource://com.smsaz.fitnessenthusiast/" + exercise_video);
        }


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
