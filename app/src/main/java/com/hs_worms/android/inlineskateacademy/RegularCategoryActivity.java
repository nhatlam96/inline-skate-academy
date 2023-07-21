package com.hs_worms.android.inlineskateacademy;

import android.content.Intent;
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
                new Lesson(getString(R.string.regular_lesson_1_title), getString(R.string.regular_lesson_1_description), R.drawable.baseline_filter_1_24, ContextCompat.getColor(this, R.color.regular)),
                new Lesson(getString(R.string.regular_lesson_2_title), getString(R.string.regular_lesson_2_description), R.drawable.baseline_filter_2_24, ContextCompat.getColor(this, R.color.regular)),
                new Lesson(getString(R.string.regular_lesson_3_title), getString(R.string.regular_lesson_3_description), R.drawable.baseline_filter_3_24, ContextCompat.getColor(this, R.color.regular)),
                new Lesson(getString(R.string.regular_lesson_4_title), getString(R.string.regular_lesson_4_description), R.drawable.baseline_filter_4_24, ContextCompat.getColor(this, R.color.regular)),
                new Lesson(getString(R.string.regular_lesson_5_title), getString(R.string.regular_lesson_5_description), R.drawable.baseline_filter_5_24, ContextCompat.getColor(this, R.color.regular))
        };

        LessonAdapter adapter = new LessonAdapter(lessons);
        adapter.setOnItemClickListener(lesson -> {
            Intent intent = getIntentForLesson(lesson);
            if (intent != null) {
                startActivity(intent);
            }
        });
        list.setAdapter(adapter);
    }

    private Intent getIntentForLesson(Lesson lesson) {
        Intent intent;
        if (getString(R.string.regular_lesson_1_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson1Activity.class);
        } else if (getString(R.string.regular_lesson_2_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson2Activity.class);
        } else if (getString(R.string.regular_lesson_3_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson3Activity.class);
        } else if (getString(R.string.regular_lesson_4_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson4Activity.class);
        } else if (getString(R.string.regular_lesson_5_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson5Activity.class);
        } else {
            intent = null;
        }
        return intent;
    }
}