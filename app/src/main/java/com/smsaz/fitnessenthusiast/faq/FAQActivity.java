package com.smsaz.fitnessenthusiast.faq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.smsaz.fitnessenthusiast.R;

import java.util.LinkedList;

public class FAQActivity extends AppCompatActivity {

    private LinkedList<String> questions;

    private RecyclerView faqRecyclerView;
    private RecyclerView.Adapter faqAdapter;
    private RecyclerView.LayoutManager faqLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        questions = new LinkedList<String>();

        for (int i = 0;i<5; i++){
            questions.add(new String ("Q " + (i + 1) + ": Which is More Productive: Less Weight/More Reps or More Weight/Less Reps?" +
                    "\n\nA: Both lifting methods offer their own distinct set of benefits. " +
                    "Less weight and more reps leads to better endurance and faster lean muscle growth." +
                    " More weight and less reps causes larger muscles and overall higher strength." +
                    " A combination of both techniques may be the most productive strategy."));
        }

        faqRecyclerView = findViewById(R.id.faqRecyclerView);
// Create an adapter and supply the data to be displayed.
        faqAdapter = new FAQAdapter(this, questions);
// Connect the adapter with the RecyclerView.
        faqRecyclerView.setAdapter(faqAdapter);
// Give the RecyclerView a default layout manager.
        faqRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
