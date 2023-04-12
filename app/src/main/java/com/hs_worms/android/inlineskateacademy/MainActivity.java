package com.hs_worms.android.inlineskateacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define buttons
        findButtons();
        setupButtons();
    }

    // find buttons
    private Button basicButton, intermediateButton, advancedButton;

    private void findButtons() {
        basicButton = findViewById(R.id.basic_button);
        intermediateButton = findViewById(R.id.intermediate_button);
        advancedButton = findViewById(R.id.advanced_button);
    }

    // setup buttons
    private void setupButtons() {
        basicButton.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "You can do it!", Toast.LENGTH_SHORT).show();
            Intent switchToBasicCategory = new Intent(MainActivity.this, BasicCategoryActivity.class);
            startActivity(switchToBasicCategory);
        });
        intermediateButton.setOnClickListener(view -> Toast.makeText(getBaseContext(), "The work has paid off :D", Toast.LENGTH_SHORT).show());
        advancedButton.setOnClickListener(view -> Toast.makeText(getBaseContext(), "Very impressive my friend!!", Toast.LENGTH_SHORT).show());
    }
}