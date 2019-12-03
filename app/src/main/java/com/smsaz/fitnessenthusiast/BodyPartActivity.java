package com.smsaz.fitnessenthusiast;
//TODO implement back button in exercise activity and solve white screen bug

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
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
    private LinkedList<dataValues> foreArms = new LinkedList<>();
    private LinkedList<dataValues> upperChest = new LinkedList<>();
    private LinkedList<dataValues> middleChest = new LinkedList<>();
    private LinkedList<dataValues> lowerChest = new LinkedList<>();
    private LinkedList<dataValues> frontShoulders = new LinkedList<>();
    private LinkedList<dataValues> backShoulders = new LinkedList<>();
    private LinkedList<dataValues> lateralDeltoid = new LinkedList<>();
    private LinkedList<dataValues> upperAbs = new LinkedList<>();
    private LinkedList<dataValues> lowerAbs = new LinkedList<>();
    private LinkedList<dataValues> obliques = new LinkedList<>();
    private LinkedList<dataValues> loveHandles = new LinkedList<>();
    private RecyclerView ExerciseRecyclerView;
    private ExerciseAdapter exercise_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_part);

        //Added for Back button implementation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // In `OnCreate();`

        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        t.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Intent intent = null;
                switch (id) {
                    case R.id.guideline:
                        intent = new Intent(BodyPartActivity.this, NutritionGuidelines.class);
                        startActivity(intent);
                        break;
                    case R.id.faqs:
                        intent = new Intent(BodyPartActivity.this, FAQActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.reminder:
                        intent = new Intent(BodyPartActivity.this, SetReminder.class);
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

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void getIncomingIntent() {
        if (getIntent().hasExtra("e_name")) {
            String exercise_name = getIntent().getStringExtra("e_name");

            if (exercise_name.equals("ARMS")) {
                Arms();
            }
            if (exercise_name.equals("DUMBBELL BICEP CURL")) {
                dumbbellBicepCurl();
            }
            if (exercise_name.equals("HAMER CURL")) {
                hamerCurl();
            }
            if (exercise_name.equals("STANDING BARBELL CURL")) {
                standingBarbellCurl();
            }
            if (exercise_name.equals("OVERHEAD CABLE CURL")) {
                overHeadCableCurl();
            }
            if (exercise_name.equals("DUMBBELL PREACHER CURL")) {
                dumbbellPreacherCurl();
            }

            if (exercise_name.equals("CLOSE-GRIP BENCH PRESS")) {
                closeGripBenchPress();
            }
            if (exercise_name.equals("SKULL CRUSHERS")) {
                skullCrushers();
            }
            if (exercise_name.equals("ROPE TRICEPS PUSH DOWN")) {
                ropeTricepsPushDown();
            }
            if (exercise_name.equals("DUMBBELL OVERHEAD TRICEPS EXTENSION")) {
                dumbbellOverheadTricepsExtension();
            }
            if (exercise_name.equals("UNDERHAND KICKBACK")) {
                underhandKickback();
            }
            if (exercise_name.equals("REVERSE CURL")) {
                reverseCurl();
            }
            if (exercise_name.equals("WRIST CURL")) {
                wristCurl();
            }
            if (exercise_name.equals("REVERSE WRIST CURL")) {
                reverseWristCurl();
            }

            if (exercise_name.equals("INCLINE BARBELL BENCH PRESS")) {
                inclineBarbellBenchPress();
            }
            if (exercise_name.equals("INCLINE DUMBBELL BENCH PRESS")) {
                inclineDumbbellBenchPress();
            }
            if (exercise_name.equals("UPPER CABLE CROSSOVER")) {
                upperCableCrossover();
            }
            if (exercise_name.equals("INCLINE DUMBBELL FLY")) {
                inclineDumbbellFly();
            }
            if (exercise_name.equals("UPPER CHEST PRESS MACHINE")) {
                upperChestPressMachine();
            }
            if (exercise_name.equals("BARBELL BENCH PRESS")) {
                barbellBechPress();
            }
            if (exercise_name.equals("DUMBBELL BENCH PRESS")) {
                dumbbleBenchPress();
            }
            if (exercise_name.equals("CABLE CROSSOVER")) {
                cableCrossover();
            }
            if (exercise_name.equals("DUMBBELL FLY")) {
                dumbbellFly();
            }
            if (exercise_name.equals("CHEST PRESS MACHINE")) {
                chestPressMachine();
            }

            if (exercise_name.equals("DECLINE BARBELL BENCH PRESS")) {
                declineBarbellBenchPress();
            }
            if (exercise_name.equals("DECLINE DUMBBELL BENCH PRESS")) {
                declineDumbbellBenchPress();
            }
            if (exercise_name.equals("PULL OVER")) {
                pullOver();
            }
            if (exercise_name.equals("LOWER CABLE CROSSOVER")) {
                lowerCableCrossover();
            }
            if (exercise_name.equals("LOW DUMBBELL CROSOVER")) {
                lowDumbbellCrossover();
            }

            if (exercise_name.equals("BARBELL OVERHEAD PRESS")) {
                barbellOverheadPress();
            }
            if (exercise_name.equals("FACE PULL")) {
                facePull();
            }
            if (exercise_name.equals("SEATED DUMBBELL CLEAN")) {
                seatedDumbbellClean();
            }
            if (exercise_name.equals("MACHINE FRONT SHOULDER PRESS")) {
                machineFrontShoulderPress();
            }


            if (exercise_name.equals("DUMBBELL RAISE COMPLEX")) {
                dumbbellRaiseComplex();
            }
            if (exercise_name.equals("DUMBBELL BENT-OVER LATERAL RAISE")) {
                dumbbellBentoverLateralRaise();
            }
            if (exercise_name.equals("MACHINE BACK SHOULDER PRESS")) {
                machineBackShoulderPress();
            }
            if (exercise_name.equals("SEATED DUMBBELL FLY")) {
                seatedDumbbleFly();
            }
            if (exercise_name.equals("SINGLE ARM LEANING AWAY LATERAL RAISE")) {
                singleArmLeaningAwayLateralRaise();
            }
            if (exercise_name.equals("BARBELL SHRUGS")) {
                barbellShrugs();
            }
            if (exercise_name.equals("DUMBBELL SHRUGS")) {
                dumbbellShrugs();
            }
            if (exercise_name.equals("COLLARS UPRIGHT ROW")) {
                collarsUprightRow();
            }

            if (exercise_name.equals("FRONT SQUAT")) {
                frontSquat();
            }
            if (exercise_name.equals("BACK SQUAT")) {
                backSquat();
            }
            if (exercise_name.equals("CLOSE LEG PRESS")) {
                closeLegPress();
            }
            if (exercise_name.equals("WIDE LEG PRESS")) {
                wideLegPress();
            }
            if (exercise_name.equals("BODYWEIGHT CALF RAISE")) {
                bodyweightCalfRaise();
            }
            if (exercise_name.equals("STANDING CALF RAISE")) {
                standingCalfRaise();
            }
            if (exercise_name.equals("FRONT LAT PULL DOWN")) {
                frontLatPullDown();
            }
            if (exercise_name.equals("T-BAR ROW")) {
                tBarRow();
            }
            if (exercise_name.equals("UNDER HAND BARBELL ROW")) {
                underHandBarbellRow();
            }
            if (exercise_name.equals("V-BAR SEATED ROWS")) {
                vBarSeatedRows();
            }
            if (exercise_name.equals("WIDE PULL OVER")) {
                widePullOver();
            }
            if (exercise_name.equals("DEAD LIFT")) {
                deadLift();
            }
            if (exercise_name.equals("BACK LAT PULL DOWN")) {
                backLatPullDown();
            }
            if (exercise_name.equals("KNEELING CABLE PULL DOWN")) {
                kneelingCablePullDown();
            }

            if (exercise_name.equals("CABLE CRUNCHES")) {
                cableCRUNCHES();
            }
            if (exercise_name.equals("BODYWEIGHT LEG RAISES")) {
                bodyweightLegRaises();
            }
            if (exercise_name.equals("DECLINE CRUNCHES")) {
                declineCrunches();
            }
            if (exercise_name.equals("BENCH LEG RAISES")) {
                benchLegRaises();
            }
            if (exercise_name.equals("BODYWEIGHT LEG RAISES")) {
                bodyweightLegRaises();
            }
            if (exercise_name.equals("INCLINE LEG RAISES")) {
                inclineLegRaises();
            }
            if (exercise_name.equals("SUPPORTED LEG RAISES")) {
                supportedLegRaises();
            }
            if (exercise_name.equals("BICYCLE CRUNCHES")) {
                bicycleCrunches();
            }
            if (exercise_name.equals("PLANKS")) {
                planks();
            }
            if (exercise_name.equals("OBLIQUE TWIST")) {
                obliqeTwist();
            }
            if (exercise_name.equals("INCLINE SIDE CRUNCH")) {
                inclineSideCrunch();
            }
            if (exercise_name.equals("SIDE CRUNCH")) {
                sideCrunch();
            }
            if (exercise_name.equals("CHEST")) {
                Chest();
            }
            if (exercise_name.equals("SHOULDERS")) {
                Shoulders();
            }
            if (exercise_name.equals("LEGS")) {
                Legs();
            }
            if (exercise_name.equals("WINGS")) {
                Wings();
            }
            if (exercise_name.equals("ABS")) {
                Abs();
            }
            if (exercise_name.equals("BICEPS")) {
                Biceps();
            }
            if (exercise_name.equals("TRICEPS")) {
                Triceps();
            }
            if (exercise_name.equals("FOREARMS")) {
                Forearms();
            }
            if (exercise_name.equals("UPPER CHEST")) {
                upperChest();
            }
            if (exercise_name.equals("LOWER CHEST")) {
                lowerChest();
            }
            if (exercise_name.equals("MIDDLE CHEST")) {
                middleChest();
            }
            if (exercise_name.equals("FRONT SHOULDERS")) {
                frontShoulders();
            }
            if (exercise_name.equals("BACK SHOULDERS")) {
                backShoulders();
            }
            if (exercise_name.equals("LATERAL DELTOID")) {
                lateralDeltoid();
            }
            if (exercise_name.equals("COLLARS")) {
                collars();
            }
            if (exercise_name.equals("THIGHS")) {
                thighs();
            }
            if (exercise_name.equals("CALVES")) {
                calves();
            }
            if (exercise_name.equals("FRONT")) {
                front();
            }
            if (exercise_name.equals("BACK")) {
                back();
            }
            if (exercise_name.equals("UPPER ABS")) {
                upperAbs();
            }
            if (exercise_name.equals("LOWER ABS")) {
                lowerAbs();
            }
            if (exercise_name.equals("OBLIQUES AND LOVEHANDLES")) {
                obliquesAndLoveHandles();
            }
        }
    }

    private void sideCrunch() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "SIDE CRUNCH");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.side_crunches);
        startActivity(intent);
    }

    private void inclineSideCrunch() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "INCLINE SIDE CRUNCH");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.incline_side_crunches);
        startActivity(intent);
    }

    private void obliqeTwist() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "OBLIQUE TWIST");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.oblique_twists);
        startActivity(intent);
    }

    private void planks() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "PLANKS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.planks);
        startActivity(intent);
    }

    private void bicycleCrunches() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "BICYCLE CRUNCHES");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.bicycle_crunches);
        startActivity(intent);
    }

    private void supportedLegRaises() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "SUPPORTED LEG RAISES");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.supported_leg_raises);
        startActivity(intent);
    }

    private void inclineLegRaises() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "INCLINE LEG RAISES");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.incline_leg_raises);
        startActivity(intent);
    }

    private void benchLegRaises() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "BENCH LEG RAISES");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.bench_leg_raises);
        startActivity(intent);
    }

    private void declineCrunches() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DECLINE CRUNCHES");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.decline_crunches);
        startActivity(intent);
    }

    private void bodyweightLegRaises() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "BODYWEIGHT LEG RAISES");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.body_weight_leg_raises);
        startActivity(intent);
    }

    private void cableCRUNCHES() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "CABLE CRUNCHES");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.cable_crunches);
        startActivity(intent);
    }

    private void kneelingCablePullDown() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "KNEELING CABLE PULL DOWN");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.back_lat_pull_down);
        startActivity(intent);
    }

    private void backLatPullDown() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "LAT PULL DOWN");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.back_lat_pull_down);
        startActivity(intent);
    }

    private void deadLift() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DEAD LIFT");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dead_lift);
        startActivity(intent);
    }

    private void widePullOver() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "WIDE PULL OVER");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.wide_pullover);
        startActivity(intent);
    }

    private void vBarSeatedRows() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "V-BAR SEATED ROWS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.v_bar_seated_row);
        startActivity(intent);
    }

    private void underHandBarbellRow() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "underHandBarbellRow");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.underhand_barbell_row);
        startActivity(intent);
    }

    private void tBarRow() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "T-BAR ROW");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.t_bar_row);
        startActivity(intent);
    }

    private void frontLatPullDown() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "FRONT LAT PULL DOWN");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.front_lat_pulldown);
        startActivity(intent);
    }

    private void standingCalfRaise() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "STANDING CALF RAISE");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.standing_calf_raise);
        startActivity(intent);
    }

    private void bodyweightCalfRaise() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "BODYWEIGHT CALF RAISE");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.body_weight_calf_raises);
        startActivity(intent);
    }

    private void wideLegPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "WIDE LEG PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.wide_leg_press);
        startActivity(intent);
    }

    private void closeLegPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "CLOSE LEG PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.close_leg_press);
        startActivity(intent);
    }

    private void backSquat() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "BACK SQUAT");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.back_squat);
        startActivity(intent);
    }

    private void frontSquat() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "FRONT SQUAT");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.front_squat);
        startActivity(intent);
    }

    private void collarsUprightRow() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "COLLARS UPRIGHT ROW");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.upright_row);
        startActivity(intent);
    }

    private void dumbbellShrugs() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DUMBBELL SHRUGS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dumbell_shrugs);
        startActivity(intent);
    }

    private void barbellShrugs() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "BARBELL SHRUGS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.barbell_shrugs);
        startActivity(intent);
    }

    private void singleArmLeaningAwayLateralRaise() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "SINGLE ARM LEANING AWAYA LATERAL RAISE");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.single_arm_leaning_away_lateral_raise);
        startActivity(intent);
    }

    private void seatedDumbbleFly() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "SEATED DUMBBELL FLY");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.seated_dumbell_fly);
        startActivity(intent);
    }

    private void machineBackShoulderPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "MACHINE BACK SHOULDER PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.machine_back_shoulder_press);
        startActivity(intent);
    }

    private void dumbbellBentoverLateralRaise() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DUMBBELL BENTOVER LATERAL RAISE");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dumbell_bent_over_lateral_raise);
        startActivity(intent);
    }

    private void dumbbellRaiseComplex() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DUMBBELL RAISE COMPLEX");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dumbell_bent_over_lateral_raise);
        startActivity(intent);
    }

    private void machineFrontShoulderPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "MACHINE FRONT SHOULDER PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.machine_front_shoulder_press);
        startActivity(intent);
    }

    private void seatedDumbbellClean() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "SEATED DUMBBELL CLEAN");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.seated_dumbell_clean);
        startActivity(intent);
    }

    private void facePull() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "FACE PULL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.face_pull);
        startActivity(intent);
    }

    private void barbellOverheadPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "BARBELL OVERHEAD PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.barbell_overhead_press);
        startActivity(intent);
    }

    private void lowDumbbellCrossover() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "LOW DUMBBELL CROSSOVER");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.low_dumbell_crossover);
        startActivity(intent);
    }

    private void lowerCableCrossover() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "LOWER CABLE CROSSOVER");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.lower_cable_crossover);
        startActivity(intent);
    }

    private void pullOver() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "PULL OVER");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.pull_over);
        startActivity(intent);
    }

    private void declineDumbbellBenchPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DECLINE DUMBBELL BENCH PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.decline_dumbell_bench_press);
        startActivity(intent);
    }

    private void declineBarbellBenchPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DECLINE BARBELL BENCH PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.decline_barbell_bench_press);
        startActivity(intent);
    }

    private void chestPressMachine() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "CHEST PRESS MACHINE");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.chest_press_machine);
        startActivity(intent);
    }

    private void dumbbellFly() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DUMBBLE FLY");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dumbell_fly);
        startActivity(intent);
    }

    private void cableCrossover() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "CABLE CROSSOVER");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.cable_crossover);
        startActivity(intent);
    }

    private void dumbbleBenchPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DUMBBLE BENCH PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dumbell_bench_press);
        startActivity(intent);
    }

    private void barbellBechPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "BARBELL BENCH PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.barbell_bench_press);
        startActivity(intent);
    }

    private void upperChestPressMachine() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "UPPER CHEST PRESS MACHINE");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.upper_chest_press_machine);
        startActivity(intent);
    }

    private void inclineDumbbellFly() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "INCLINE DUMBBELL FLY");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.incline_dumbell_fly);
        startActivity(intent);
    }

    private void upperCableCrossover() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "UPPER CABLE CROSSOVER");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.upper_cable_crossover);
        startActivity(intent);
    }

    private void inclineBarbellBenchPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "INCLINE BARBELL BENCH PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.incline_barbell_bench_press);
        startActivity(intent);
    }

    private void inclineDumbbellBenchPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "INCLINE DUMBELL BENCH PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.incline_dumbell_bench_press);
        startActivity(intent);
    }

    private void reverseWristCurl() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "REVERSE WRIST CURL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.reverse_wrist_curl);
        startActivity(intent);
    }

    private void wristCurl() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "WRIST CURL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.wrist_curl);
        startActivity(intent);
    }

    private void reverseCurl() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "REVERSE CURL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.reverse_curl);
        startActivity(intent);
    }

    private void underhandKickback() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "UNDERHAND KICKBACK");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.underhand_kickback);
        startActivity(intent);
    }

    private void dumbbellOverheadTricepsExtension() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DUMBBELL OVERHEAD TRICEPS EXTENSION");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dumbell_overhead_triceps_extension);
        startActivity(intent);
    }

    private void ropeTricepsPushDown() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "ROPE TRICEPS PUSHDOWN");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.rope_triceps_pushdown);
        startActivity(intent);
    }

    private void skullCrushers() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "SKULL CRUSHERS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.skull_crushers);
        startActivity(intent);
    }

    private void closeGripBenchPress() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "CLOSE-GRIP BENCH PRESS");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.close_grip_bench_press);
        startActivity(intent);
    }

    private void dumbbellPreacherCurl() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DUMBBELL PREACHER CURL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dumbell_preacher_curl);
        startActivity(intent);
    }

    private void overHeadCableCurl() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "OVERHEAD CURL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.overhead_cable_curl);
        startActivity(intent);
    }

    private void standingBarbellCurl() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "STANDING BARBELL CURL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.standing_barbell_curl);
        startActivity(intent);
    }

    private void hamerCurl() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "HAMER CURL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.hammer_curl);
        startActivity(intent);
    }

    private void dumbbellBicepCurl() {
        Intent intent = new Intent(this, ExerciseActivity.class);
        intent.putExtra("e_name", "DUMBBELL BICEP CURL");
        intent.putExtra("e_description", "hold the dummbbell and start doing it");
        intent.putExtra("e_video", R.raw.dumbell_bicep_curl);
        startActivity(intent);
    }

    private void upperAbs() {
        String[] names = {"CABLE CRUNCHES", "BODYWEIGHT LEG RAISES", "DECLINE CRUNCHES"};
        int[] images = {R.drawable.cable_crunches, R.drawable.body_weight_leg_raises, R.drawable.decline_crunches};
        for (int i = 0; i < 3; i++)
            this.upperAbs.add(new dataValues(names[i], images[i]));
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
        String[] names = {"BENCH LEG RAISES", "INCLINE LEG RAISES", "BODYWEIGHT LEG RAISES", "SUPPORTED LEG RAISES"};
        int[] images = {R.drawable.bench_leg_raises, R.drawable.incline_leg_raises, R.drawable.body_weight_leg_raises, R.drawable.supported_leg_raises};
        for (int i = 0; i < 4; i++)
            this.lowerAbs.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, lowerAbs);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void obliquesAndLoveHandles() {
        String[] names = {"BICYCLE CRUNCHES", "PLANKS", "OBLIQUE TWIST", "INCLINE SIDE CRUNCH", "SIDE CRUNCH"};
        int[] images = {R.drawable.bicycle_crunches, R.drawable.planks, R.drawable.oblique_twists, R.drawable.incline_side_crunches, R.drawable.side_crunches};
        for (int i = 0; i < 5; i++)
            this.loveHandles.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, loveHandles);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void back() {
        String[] names = {"DEAD LIFT", "BACK LAT PULL DOWN", "KNEELING CABLE PULL DOWN"};
        int[] images = {R.drawable.dead_lift, R.drawable.back_lat_pull_down, R.drawable.back_lat_pull_down};
        for (int i = 0; i < 3; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
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
        String[] names = {"FRONT LAT PULL DOWN", "T-BAR ROW", "UNDER HAND BARBELL ROW", "V-BAR SEATED ROWS", "WIDE PULL OVER"};
        int[] images = {R.drawable.front_lat_pulldown, R.drawable.t_bar_row, R.drawable.underhand_barbell_row, R.drawable.v_bar_seated_row, R.drawable.wide_pullover};
        for (int i = 0; i < 5; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
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
        String[] names = {"BODYWEIGHT CALF RAISE", "STANDING CALF RAISE"};
        int[] images = {R.drawable.body_weight_calf_raise, R.drawable.standing_calf_raise};
        for (int i = 0; i < 2; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
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
        String[] names = {"FRONT SQUAT", "BACK SQUAT", "CLOSE LEG PRESS", "WIDE LEG PRESS"};
        int[] images = {R.drawable.front_squat, R.drawable.back_squat, R.drawable.close_leg_press, R.drawable.wide_leg_press};
        for (int i = 0; i < 4; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
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
        String[] names = {"BARBELL SHRUGS", "DUMBBELL SHRUGS", "COLLARS UPRIGHT ROW"};
        int[] images = {R.drawable.barbell_shrugs, R.drawable.dumbell_shrugs, R.drawable.upright_row};
        for (int i = 0; i < 3; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
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
        String[] names = {"SEATED DUMBBELL FLY", "SEATED DUMBBELL CLEAN", "SINGLE ARM LEANING AWAY LATERAL RAISE"};
        int[] images = {R.drawable.seated_dumbell_fly, R.drawable.seated_dumbell_clean, R.drawable.single_arm_leaning_away_lateral_raise};
        for (int i = 0; i < 3; i++)
            this.lateralDeltoid.add(new dataValues(names[i], images[i]));
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
        String[] names = {"SEATED DUMBBELL CLEAN", "DUMBBELL RAISE COMPLEX", "DUMBBELL BENT-OVER LATERAL RAISE", "MACHINE BACK SHOULDER PRESS"};
        int[] images = {R.drawable.seated_dumbell_clean, R.drawable.seated_dumbell_clean, R.drawable.dumbell_bent_over_lateral_raise, R.drawable.machine_back_shoulder_press};
        for (int i = 0; i < 4; i++)
            this.backShoulders.add(new dataValues(names[i], images[i]));
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
        String[] names = {"BARBELL OVERHEAD PRESS", "FACE PULL", "SEATED DUMBBELL CLEAN", "MACHINE FRONT SHOULDER PRESS"};
        int[] images = {R.drawable.barbell_overhead_press, R.drawable.face_pull, R.drawable.seated_dumbell_clean, R.drawable.machine_front_shoulder_press};
        for (int i = 0; i < 4; i++)
            this.frontShoulders.add(new dataValues(names[i], images[i]));
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
        String[] names = {"BARBELL BENCH PRESS", "DUMBBELL BENCH PRESS", "CABLE CROSSOVER", "DUMBBELL FLY", "CHEST PRESS MACHINE"};
        int[] images = {R.drawable.barbell_bench_press, R.drawable.dumbell_bench_press, R.drawable.cable_crossover, R.drawable.dumbell_fly, R.drawable.chest_press_machine};
        for (int i = 0; i < 5; i++)
            this.middleChest.add(new dataValues(names[i], images[i]));
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
        String[] names = {"DECLINE BARBELL BENCH PRESS", "DECLINE DUMBBELL BENCH PRESS", "PULL OVER", "LOWER CABLE CROSSOVER", "LOW DUMBBELL CROSSOVER"};
        int[] images = {R.drawable.decline_barbell_bench_press, R.drawable.decline_dumbell_bench_press, R.drawable.pull_over, R.drawable.lower_cable_crossover, R.drawable.low_dumbell_crossover};
        for (int i = 0; i < 5; i++)
            this.lowerChest.add(new dataValues(names[i], images[i]));
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
        String[] names = {"INCLINE BARBELL BENCH PRESS", "INCLINE DUMBBELL BENCH PRESS", "UPPER CABLE CROSSOVER", "INCLINE DUMBBELL FLY", "UPPER CHEST PRESS MACHINE"};
        int[] images = {R.drawable.incline_barbell_bench_press, R.drawable.incline_dumbell_bench_press, R.drawable.upper_cable_crossover, R.drawable.incline_dumbell_fly, R.drawable.upper_chest_press_machine};
        for (int i = 0; i < 5; i++)
            this.upperChest.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, upperChest);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Arms() {
        String[] names = {"BICEPS", "TRICEPS", "FOREARMS"};
        int[] images = {R.drawable.biceps, R.drawable.triceps, R.drawable.forearms};
        for (int i = 0; i < 3; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Chest() {
        String[] names = {"UPPER CHEST", "MIDDLE CHEST", "LOWER CHEST"};
        int[] images = {R.drawable.chest_upper, R.drawable.chest_middle, R.drawable.chest_lower};
        for (int i = 0; i < 3; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Shoulders() {
        String[] names = {"FRONT SHOULDERS", "BACK SHOULDERS", "LATERAL DELTOID"};
        int[] images = {R.drawable.shoulders_front, R.drawable.back_shoulders, R.drawable.shoulders_deltoid};
        for (int i = 0; i < 3; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Legs() {
        String[] names = {"THIGHS", "CALVES"};
        int[] images = {R.drawable.legs, R.drawable.calves};
        for (int i = 0; i < 2; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Wings() {
        String[] names = {"FRONT", "BACK"};
        int[] images = {R.drawable.front_wings, R.drawable.back_wings};
        for (int i = 0; i < 2; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Abs() {
        String[] names = {"UPPER ABS", "LOWER ABS", "OBLIQUES AND LOVEHANDLES"};
        int[] images = {R.drawable.upper_abs, R.drawable.lower_abs, R.drawable.lovehandles};
        for (int i = 0; i < 3; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Biceps() {
        String[] names = {"DUMBBELL BICEP CURL", "HAMER CURL", "STANDING BARBELL CURL", "OVERHEAD CABLE CURL", "DUMBBELL PREACHER CURL"};
        int[] images = {R.drawable.dumbell_bicep_curl, R.drawable.hammer_curl, R.drawable.standing_barbell_curl, R.drawable.overhead_cable_curl, R.drawable.dumbell_preacher_curl};
        for (int i = 0; i < 5; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Triceps() {
        String[] names = {"CLOSE-GRIP BENCH PRESS", "SKULL CRUSHERS", "ROPE TRICEPS PUSH DOWN", "DUMBBELL OVERHEAD TRICEPS EXTENSION", "UNDERHAND KICKBACK"};
        int[] images = {R.drawable.close_grip_bench_press, R.drawable.skull_crushers, R.drawable.rope_triceps_pushdown, R.drawable.dumbell_overhead_triceps_extension, R.drawable.underhand_kickback};
        for (int i = 0; i < 5; i++)
            this.exerciseList.add(new dataValues(names[i], images[i]));
        // Get a handle to the RecyclerView.
        ExerciseRecyclerView = findViewById(R.id.body_part_list);
        // Create an adapter and supply the data to be displayed.
        exercise_Adapter = new ExerciseAdapter(this, exerciseList);
        // Connect the adapter with the RecyclerView.
        ExerciseRecyclerView.setAdapter(exercise_Adapter);
        // Give the RecyclerView a default layout manager.
        ExerciseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void Forearms() {
        String[] names = {"REVERSE CURL", "WRIST CURL", "REVERSE WRIST CURL"};
        int[] images = {R.drawable.reverse_curl, R.drawable.wrist_curl, R.drawable.reverse_wrist_curl};
        for (int i = 0; i < 3; i++)
            this.foreArms.add(new dataValues(names[i], images[i]));
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

        if (t.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
