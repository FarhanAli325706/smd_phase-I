package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

public class ExercieList extends AppCompatActivity {

    private final LinkedList<dataValues> exerciseList = new LinkedList<>();
    private RecyclerView ExerciseRecyclerView;
    private ExerciseAdapter exercise_Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercie_list);
        String[] names={"ARMS","CHEST","SHOULDERS","COLLARS","LEGS","WINGS","ABS"};
        int[] images={R.drawable.arms,R.drawable.chest,R.drawable.shoulders,R.drawable.collars,R.drawable.legs,R.drawable.wings,R.drawable.abs};
        for(int i=0;i<7;i++)
            this.exerciseList.add(new dataValues(names[i],images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.exercise_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
