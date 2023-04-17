package com.hs_worms.android.inlineskateacademy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegularCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular_category);
        setTitle(R.string.regular_title);
    }
}