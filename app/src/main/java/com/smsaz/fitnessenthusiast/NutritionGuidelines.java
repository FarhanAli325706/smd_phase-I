package com.smsaz.fitnessenthusiast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.MenuItem;

public class NutritionGuidelines extends AppCompatActivity {

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
        setContentView(R.layout.activity_nutrition_guidelines);

        //Added for Back button implementation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // In `OnCreate();`
    }
}
