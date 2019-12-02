package com.smsaz.fitnessenthusiast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.notificationmodule.SetReminder;
import com.google.android.material.navigation.NavigationView;
import com.smsaz.fitnessenthusiast.faq.FAQActivity;

import java.util.LinkedList;

public class BodyPartActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private LinkedList<dataValues> exerciseList = new LinkedList<>();
    private LinkedList<dataValues> foreArms=new LinkedList<>();
    private LinkedList<dataValues> upperChest=new LinkedList<>();
    private LinkedList<dataValues> middleChest=new LinkedList<>();
    private LinkedList<dataValues> lowerChest=new LinkedList<>();
    private LinkedList<dataValues> frontShoulders=new LinkedList<>();
    private LinkedList<dataValues> backShoulders=new LinkedList<>();
    private LinkedList<dataValues> lateralDeltoid=new LinkedList<>();
    private LinkedList<dataValues> upperAbs=new LinkedList<>();
    private LinkedList<dataValues> lowerAbs=new LinkedList<>();
    private LinkedList<dataValues> obliques=new LinkedList<>();
    private LinkedList<dataValues> loveHandles=new LinkedList<>();
    private RecyclerView ExerciseRecyclerView;
    private ExerciseAdapter exercise_Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_part);
        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent=null;
                switch(id)
                {
                    case R.id.guideline:
                        intent=new Intent(BodyPartActivity.this,NutritionGuidelines.class);
                        startActivity(intent);
                        break;
                    case R.id.faqs:
                        intent=new Intent(BodyPartActivity.this, FAQActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.reminder:
                        intent=new Intent(BodyPartActivity.this, SetReminder.class);
                        startActivity(intent);
                        break;
                    default:
                        return true;
                }


                return true;

            }
        });
        getIncomingIntent();
    }
    private void getIncomingIntent()
    {
        if(getIntent().hasExtra("e_name"))
        {
            String exercise_name=getIntent().getStringExtra("e_name");

            if(exercise_name.equals("ARMS"))
            {
                Arms();
            }
            if(exercise_name.equals("CHEST"))
            {
                Chest();
            }
            if(exercise_name.equals("SHOULDERS"))
            {
                Shoulders();
            }
            if(exercise_name.equals("LEGS"))
            {
                Legs();
            }
            if(exercise_name.equals("WINGS"))
            {
                Wings();
            }
            if(exercise_name.equals("ABS"))
            {
                Abs();
            }
            if(exercise_name.equals("BICEPS"))
            {
                Biceps();
            }
            if(exercise_name.equals("TRICEPS"))
            {
                Triceps();
            }
            if(exercise_name.equals("FOREARMS"))
            {
                Forearms();
            }
            if(exercise_name.equals("UPPER CHEST"))
            {
                upperChest();
            }
            if(exercise_name.equals("LOWER CHEST"))
            {
                lowerChest();
            }
            if(exercise_name.equals("MIDDLE CHEST"))
            {
                middleChest();
            }
            if(exercise_name.equals("FRONT SHOULDERS"))
            {
                frontShoulders();
            }
            if(exercise_name.equals("BACK SHOULDERS"))
            {
                backShoulders();
            }
            if(exercise_name.equals("LATERAL DELTOID"))
            {
                lateralDeltoid();
            }
            if(exercise_name.equals("COLLARS"))
            {
                collars();
            }
            if(exercise_name.equals("THIGHS"))
            {
                thighs();
            }
            if(exercise_name.equals("CALVES"))
            {
                calves();
            }
            if(exercise_name.equals("FRONT"))
            {
                front();
            }
            if(exercise_name.equals("BACK"))
            {
                back();
            }
            if(exercise_name.equals("UPPER ABS"))
            {
                upperAbs();
            }
            if(exercise_name.equals("LOWER ABS"))
            {
                lowerAbs();
            }
            if(exercise_name.equals("OBLIQUES"))
            {
                Obliques();
            }
            if(exercise_name.equals("LOVE HANDLES"))
            {
                loveHandles();
            }
        }
    }

    private void upperAbs() {
        String[] names={"90 DEGREES SIT UP TO TOES","CRUNCHES","DECLINE CRUNCHES"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<3;i++)
            this.upperAbs.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, upperAbs);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void lowerAbs() {
        String[] names={"MOUNTAIN CLIMBER","LYING LEG RAISES","SCISSORS","REVERSE CRUNCH"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<4;i++)
            this.lowerAbs.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, lowerAbs);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void loveHandles() {
        String[] names={"BICYCLE CRUNCHES","SIDE PLANKS","RUSSIAN TWISTS","DUMBBELL WOODCHOPPERS","MOUNTAIN CLIMBERS"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.loveHandles.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, loveHandles);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void Obliques() {
        String[] names={"OBLIQUE CRUNCHES","EXTENDED OBLIQUE CRUNCHES","BICYCLE CRUNCHES","HANGING OBLIQUE LEG RAISES","SPIDERMAN PUSHUPS"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.obliques.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, obliques);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void back() {
        String[] names={"DEAD LIFT","BACK LAT PULL DOWN","KNEELING CABLE PULL DOWN"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<3;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void front() {
        String[] names={"Front Lat Pull Down","T-BAR ROW","UNDER HAND BARBELL ROW","V-BAR SEATED ROWS","WIDE PULL OVER"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void calves() {
        String[] names={"BODYWEIGHT CALF RAISE","STANDING CALF RAISE"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<2;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void thighs() {
        String[] names={"FRONT SQUAT","BULGARIAN SPLIT SQUAT","BACK SQUAT","CLOSE LEG PRESS","WIDE LEG PRESS"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void collars() {
        String[] names={"BARBELL SHRUGS","DUMBBELL SHRUGS","COLLARS UPRIGHT ROW"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<3;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void lateralDeltoid() {
        String[] names={"STANDING DUMBBELL FLY","SEATED DUMBBELL CLEAN","SINGLE ARM LEANING AWAY LATERAL RAISE"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<3;i++)
            this.lateralDeltoid.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, lateralDeltoid);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void backShoulders() {
        String[] names={"SEATED DUMBBELL CLEAN","DUMBBELL RAISE COMPLEX","DUMBBELL BENT-OVER LATERAL RAISE","MACHINE BACK SHOULDER PRESS"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<4;i++)
            this.backShoulders.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, backShoulders);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void frontShoulders() {
        String[] names={"Barbell Overhead Press","Face Pull","SEATED DUMBBELL CLEAN","MACHINE FRONT SHOULDER PRESS"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<4;i++)
            this.frontShoulders.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, frontShoulders);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void middleChest() {
        String[] names={"BARBELL BENCH PRESS","DUMBBELL BENCH PRESS","CABLE CROSSOVER","DUMBBELL FLY","CHEST PRESS MACHINE"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.middleChest.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, middleChest);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void lowerChest() {
        String[] names={"DECLINE BARBELL BENCH PRESS","DECLINE DUMBBELL BENCH PRESS","PULL OVER","LOWER CABLE CROSSOVER","LOW DUMBBELL CROSSOVER"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.lowerChest.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, lowerChest);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void upperChest() {
        String[] names={"INCLINE BARBELL BENCH PRESS","INCLINE DUMBBELL BENCH PRESS","UPPER CABLE CROSSOVER","INCLINE DUMBBELL FLY","UPPER CHEST PRESS MACHINE"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.upperChest.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, upperChest);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Arms()
    {
        String[] names={"BICEPS","TRICEPS","FOREARMS"};
        int[] images={R.drawable.biceps,R.drawable.triceps,R.drawable.forearms};
        for(int i=0;i<3;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Chest()
    {
        String[] names={"UPPER CHEST","MIDDLE CHEST","LOWER CHEST"};
        int[] images={R.drawable.chest_upper,R.drawable.chest_middle,R.drawable.chest_lower};
        for(int i=0;i<3;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Shoulders()
    {
        String[] names={"FRONT SHOULDERS","BACK SHOULDERS","LATERAL DELTOID"};
        int[] images={R.drawable.shoulders_front,R.drawable.back_shoulders,R.drawable.shoulders_deltoid};
        for(int i=0;i<3;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Legs()
    {
        String[] names={"THIGHS","CALVES"};
        int[] images={R.drawable.legs,R.drawable.calves};
        for(int i=0;i<2;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Wings()
    {
        String[] names={"FRONT","BACK"};
        int[] images={R.drawable.front_wings,R.drawable.back_wings};
        for(int i=0;i<2;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Abs()
    {
        String[] names={"UPPER ABS","LOWER ABS","OBLIQUES","LOVE HANDLES"};
        int[] images={R.drawable.upper_abs,R.drawable.lower_abs,R.drawable.obliques,R.drawable.lovehandles};
        for(int i=0;i<4;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Biceps()
    {
        String[] names={"DUMBBELL BICEP CURL","HAMER CURL","STANDING BARBELL CURL","OVERHEAD CABLE CURL","EX-BAR PREACHER CURL"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Triceps()
    {
        String[] names={"CLOSE-GRIP BENCH PRESS","SKULL CRUSHERS","ROPE TRICEPS PUSH DOWN","DUMBBELL OVERHEAD TRICEPS EXTENSION","UNDERHAND KICKBACK"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<5;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void Forearms()
    {
        String[] names={"REVERSE CURL","WRIST CURL","REVERSE WRIST CURL"};
        int[] images={R.drawable.demo_pic,R.drawable.demo_pic,R.drawable.demo_pic};
        for(int i=0;i<3;i++)
            this.foreArms.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, foreArms);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
