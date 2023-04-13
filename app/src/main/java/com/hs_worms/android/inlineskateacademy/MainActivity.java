package com.hs_worms.android.inlineskateacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Choose category");
        findIDs();
        setupIDs();
    }

    // find IDs
    private CardView noviceCardView, regularCardView, expertCardView, theoryCardView;

    private void findIDs() {
        noviceCardView = findViewById(R.id.novice_cardview);
        regularCardView = findViewById(R.id.regular_cardview);
        expertCardView = findViewById(R.id.expert_cardview);
        theoryCardView = findViewById(R.id.theory_cardview);
    }

    // setup buttons
    private void setupIDs() {
        noviceCardView.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "You can do it!", Toast.LENGTH_SHORT).show();
            Intent switchToNoviceCategory = new Intent(MainActivity.this, NoviceCategoryActivity.class);
            startActivity(switchToNoviceCategory);
        });
        regularCardView.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Don't get your hopes up", Toast.LENGTH_SHORT).show();
            Intent switchToRegularCategory = new Intent(MainActivity.this, RegularCategoryActivity.class);
            startActivity(switchToRegularCategory);
        });
        expertCardView.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "A true chad :D", Toast.LENGTH_SHORT).show();
            Intent switchToExpertCategory = new Intent(MainActivity.this, ExpertCategoryActivity.class);
            startActivity(switchToExpertCategory);
        });
        theoryCardView.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "You nerd", Toast.LENGTH_SHORT).show();
            Intent switchToTheoryCategory = new Intent(MainActivity.this, TheoryCategoryActivity.class);
            startActivity(switchToTheoryCategory);
        });
    }
}