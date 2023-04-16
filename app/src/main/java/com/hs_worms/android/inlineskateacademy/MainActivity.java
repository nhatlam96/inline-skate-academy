package com.hs_worms.android.inlineskateacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_main);
        setTitle("Choose category");
        findIDs();
        setupIDs();
        Toast.makeText(MainActivity.this, "Welcome to Inline Skate Academy!", Toast.LENGTH_SHORT).show();
    }

    // find IDs
    private CardView noviceCardView, regularCardView, expertCardView, theoryCardView;

    private void findIDs() {
        noviceCardView = findViewById(R.id.novice_cardview);
        regularCardView = findViewById(R.id.regular_cardview);
        expertCardView = findViewById(R.id.expert_cardview);
        theoryCardView = findViewById(R.id.theory_cardview);
    }

    // setup IDs
    private void setupIDs() {
        noviceCardView.setOnClickListener(view -> {
            Intent switchToNoviceCategory = new Intent(MainActivity.this, NoviceCategoryActivity.class);
            startActivity(switchToNoviceCategory);
        });
        regularCardView.setOnClickListener(view -> {
            Intent switchToRegularCategory = new Intent(MainActivity.this, RegularCategoryActivity.class);
            startActivity(switchToRegularCategory);
        });
        expertCardView.setOnClickListener(view -> {
            Intent switchToExpertCategory = new Intent(MainActivity.this, ExpertCategoryActivity.class);
            startActivity(switchToExpertCategory);
        });
        theoryCardView.setOnClickListener(view -> {
            Intent switchToTheoryCategory = new Intent(MainActivity.this, TheoryCategoryActivity.class);
            startActivity(switchToTheoryCategory);
        });
    }
}