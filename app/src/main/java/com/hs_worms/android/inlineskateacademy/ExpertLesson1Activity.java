package com.hs_worms.android.inlineskateacademy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
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

    private static final String TAG = ExpertLesson1Activity.class.getSimpleName();

    private EditText editLessonNote;
    private LessonNoteDatabase lessonNoteDatabase;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

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

        updateLessonNote.setOnClickListener(v -> updateLessonNoteBackground());
    }

    private void setupDatabase() {
        lessonNoteDatabase = Room.databaseBuilder(getApplicationContext(), LessonNoteDatabase.class, "lessonNoteDatabase")
                .addCallback(roomCallback)
                .build();
    }

    private final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private void updateLessonNoteBackground() {
        String note = editLessonNote.getText().toString();
        LessonNote lessonNote = new LessonNote(getString(R.string.novice_lesson_1_note_id), note);

        executorService.execute(() -> {
            try {
                lessonNoteDatabase.getLessonNoteDAO().updateLessonNote(lessonNote);
                handler.post(() -> showToast(getString(R.string.note_updated)));
            } catch (Exception e) {
                Log.e(TAG, "Error updating lesson note: " + e.getMessage());
                handler.post(() -> showToast(getString(R.string.error_update_note)));
            }
        });
    }

    private void loadLessonNote() {
        executorService.execute(() -> {
            try {
                LessonNote lessonNote = lessonNoteDatabase.getLessonNoteDAO().getLessonNote(getString(R.string.novice_lesson_1_note_id));

                if (lessonNote == null) {
                    lessonNote = new LessonNote(getString(R.string.novice_lesson_1_note_id), getString(R.string.empty_note));
                    lessonNoteDatabase.getLessonNoteDAO().addLessonNote(lessonNote);
                }

                final String note = lessonNote.getNote();
                handler.post(() -> editLessonNote.setText(note));
            } catch (Exception e) {
                Log.e(TAG, "Error loading lesson note: " + e.getMessage());
                handler.post(() -> showToast(getString(R.string.error_load_note)));
            }
        });
    }

    private void showToast(String message) {
        handler.post(() -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown(); // Shut down the executor service to prevent memory leaks
    }
}