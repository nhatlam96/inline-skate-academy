package com.hs_worms.android.inlineskateacademy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExpertLesson1Activity extends AppCompatActivity {

    private EditText editLessonNote;

    private LessonNoteDatabase lessonNoteDatabase;
    private final int lessonNoteId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_lesson_1);

        setupViews();
        setupDatabase();
        loadLessonNote();
        initializeWebView();
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void initializeWebView() {
        WebView webView = findViewById(R.id.expert_lesson_1_yt_view);
        String video = getString(R.string.expert_lesson_1_yt_video);
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
    }

    private void setupViews() {
        editLessonNote = findViewById(R.id.expert_lesson_1_edit_note);
        Button updateLessonNote = findViewById(R.id.expert_lesson_1_update_note);

        updateLessonNote.setOnClickListener(v -> updateLessonNote());
    }

    private void setupDatabase() {
        RoomDatabase.Callback callback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        lessonNoteDatabase = Room.databaseBuilder(getApplicationContext(), LessonNoteDatabase.class, "lessonNoteDatabase")
                .addCallback(callback)
                .build();
    }

    private void updateLessonNote() {
        String note = editLessonNote.getText().toString();
        LessonNote lessonNote = new LessonNote(lessonNoteId, note);
        executeInBackground(() -> lessonNoteDatabase.getLessonNoteDAO().updateLessonNote(lessonNote)
        );
    }

    private void loadLessonNote() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            LessonNote existingLessonNote = lessonNoteDatabase.getLessonNoteDAO().getLessonNote(lessonNoteId);
            LessonNote newLessonNote = new LessonNote(lessonNoteId, "");

            // Check if a lesson note already exists
            if (existingLessonNote == null) {
                // Initialize an empty lesson note
                lessonNoteDatabase.getLessonNoteDAO().addLessonNote(newLessonNote);
            }

            // Load the existing lesson note or the newly initialized one, on the UI thread
            runOnUiThread(() -> {
                LessonNote lessonNoteToDisplay = existingLessonNote != null ? existingLessonNote : newLessonNote;
                editLessonNote.setText(lessonNoteToDisplay.getNote());
            });
        });
    }

    private void executeInBackground(Runnable task) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {
            task.run();
            handler.post(() -> Toast.makeText(ExpertLesson1Activity.this, "Lesson Note Saved", Toast.LENGTH_SHORT).show());
        });
    }
}