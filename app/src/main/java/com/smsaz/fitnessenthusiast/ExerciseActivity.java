package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class ExerciseActivity extends AppCompatActivity {

    Uri uri;
    TextView name;
    TextView description;
    //Added for Back button implementation
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // In `OnCreate();`

        name = findViewById(R.id.exerciseTitle);
        description = findViewById(R.id.description);
        VideoView exerciseVideo = findViewById(R.id.exerciseVideo);
        if (getIntent().hasExtra("e_name")) {
            String exercise_name = getIntent().getStringExtra("e_name");
            String exercise_description = getIntent().getStringExtra("e_description");
            int exercise_video = getIntent().getIntExtra("e_video", 0);
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

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            onBackPressed();
            onBackPressed();
        }
        return true;
    }
}
