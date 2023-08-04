package com.hs_worms.android.inlineskateacademy;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class NoviceCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novice_category);
        setTitle(R.string.novice_title);

        RecyclerView list = findViewById(R.id.recycler_view_novice_category);
        Lesson[] lessons = {
                new Lesson(getString(R.string.novice_lesson_1_title), getString(R.string.novice_lesson_1_description), R.drawable.baseline_filter_1_24, ContextCompat.getColor(this, R.color.novice), ""),
                new Lesson(getString(R.string.novice_lesson_2_title), getString(R.string.novice_lesson_2_description), R.drawable.baseline_filter_2_24, ContextCompat.getColor(this, R.color.novice), ""),
                new Lesson(getString(R.string.novice_lesson_3_title), getString(R.string.novice_lesson_3_description), R.drawable.baseline_filter_3_24, ContextCompat.getColor(this, R.color.novice), ""),
                new Lesson(getString(R.string.novice_lesson_4_title), getString(R.string.novice_lesson_4_description), R.drawable.baseline_filter_4_24, ContextCompat.getColor(this, R.color.novice), ""),
                new Lesson(getString(R.string.novice_lesson_5_title), getString(R.string.novice_lesson_5_description), R.drawable.baseline_filter_5_24, ContextCompat.getColor(this, R.color.novice), "")
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
        if (getString(R.string.novice_lesson_1_title).equals(lesson.getTitle())) {
            intent = new Intent(this, NoviceLesson1Activity.class);
        } else if (getString(R.string.novice_lesson_2_title).equals(lesson.getTitle())) {
            intent = new Intent(this, NoviceLesson2Activity.class);
        } else if (getString(R.string.novice_lesson_3_title).equals(lesson.getTitle())) {
            intent = new Intent(this, NoviceLesson3Activity.class);
        } else if (getString(R.string.novice_lesson_4_title).equals(lesson.getTitle())) {
            intent = new Intent(this, NoviceLesson4Activity.class);
        } else if (getString(R.string.novice_lesson_5_title).equals(lesson.getTitle())) {
            intent = new Intent(this, NoviceLesson5Activity.class);
        } else {
            intent = null;
        }
        return intent;
    }
}