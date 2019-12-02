package com.smsaz.fitnessenthusiast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.example.notificationmodule.SetReminder;
import com.facebook.login.LoginManager;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smsaz.fitnessenthusiast.faq.FAQActivity;

import java.util.LinkedList;
import java.util.List;

public class ExercieList extends AppCompatActivity {

    // TODO: 12/1/2019 put onClickListener on exercise layout
    // TODO: 12/1/2019 put current user in shared preferences and cache and check for already signed in user in onStart of app

    private FirebaseAuth firebaseAuth;

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private final LinkedList<dataValues> exerciseList = new LinkedList<>();
    private RecyclerView ExerciseRecyclerView;
    private ExerciseAdapter exercise_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercie_list);
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();

        // TODO: 12/1/2019 LOGOUT BUTTON IMPLEMENTATION if their is a user logged in

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent = null;
                switch (id) {
                    case R.id.guideline:
                        intent = new Intent(ExercieList.this, NutritionGuidelines.class);
                        startActivity(intent);
                        break;
                    case R.id.faqs:
                        intent = new Intent(ExercieList.this, FAQActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.reminder:
                        intent=new Intent(ExercieList.this, SetReminder.class);
                        startActivity(intent);
                        break;
                    case R.id.crashButton:
                        Crashlytics.getInstance().crash();
                        break;
                    default:
                        return true;
                }


                return true;

            }
        });

        String[] names = {"ARMS", "CHEST", "SHOULDERS", "COLLARS", "LEGS", "WINGS", "ABS"};
        int[] images = {R.drawable.arms, R.drawable.chest, R.drawable.shoulders, R.drawable.collars, R.drawable.legs, R.drawable.wings, R.drawable.abs};
        for (int i = 0; i < 7; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.exercise_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null)
            getMenuInflater().inflate(R.menu.signout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
//        if(id == R.id.sign)
        if (t.onOptionsItemSelected(item))
            return true;
        if (id == R.id.sign_out) {
            FirebaseAuth.getInstance().signOut();
            LoginManager.getInstance().logOut();
            startActivity(new Intent(ExercieList.this, MainScreen.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
