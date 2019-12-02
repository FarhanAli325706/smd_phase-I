package com.example.notificationmodule;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class SetReminder extends AppCompatActivity {
    EditText hrs;
    EditText mins;
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);
        hrs=findViewById(R.id.hours);
        mins=findViewById(R.id.minutes);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent notifyIntent = new Intent(this, AlaramReceiver.class);
        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Button button = (Button) findViewById(R.id.notification);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar calendar=Calendar.getInstance();
                int hours= Integer.parseInt(hrs.getText().toString());
                int min=Integer.parseInt(mins.getText().toString());
                int totalTime=(hours*3600)+(min*60);
                calendar.add(Calendar.SECOND,totalTime);
                alarmManager.setExact(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),notifyPendingIntent);

                Toast.makeText(SetReminder.this, "Reminder Set Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        createNotificationChannel();
    }
    public void createNotificationChannel() {

        // Create a notification manager object.
        mNotificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID,
                            "Stand up notification",
                            NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);

            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
