package com.hs_worms.android.inlineskateacademy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class RegularCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular_category);
        setTitle(R.string.regular_title);

        RecyclerView list = findViewById(R.id.recycler_view_regular_category);
        Lesson[] lessons = {
                new Lesson("Lesson 1 Title", "Lesson 1 Desc", R.drawable.baseline_filter_1_24, ContextCompat.getColor(this, R.color.regular)),
                new Lesson("Lesson 2 Title", "Lesson 2 Desc", R.drawable.baseline_filter_2_24, ContextCompat.getColor(this, R.color.regular)),
                new Lesson("Lesson 3 Title", "Lesson 3 Desc", R.drawable.baseline_filter_3_24, ContextCompat.getColor(this, R.color.regular)),
                new Lesson("Lesson 4 Title", "Lesson 4 Desc", R.drawable.baseline_filter_4_24, ContextCompat.getColor(this, R.color.regular)),
                new Lesson("Lesson 5 Title", "Lesson 5 Desc", R.drawable.baseline_filter_5_24, ContextCompat.getColor(this, R.color.regular))
        };

        LessonAdapter adapter = new LessonAdapter(lessons);
        list.setAdapter(adapter);
    }
}