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

import androidx.appcompat.app.AppCompatActivity;

public class ExpertLesson1Activity extends AppCompatActivity {

    private static final String TAG = ExpertLesson1Activity.class.getSimpleName();
    private static String NOTE_ID;
    private EditText editLessonNote;
    private LessonNoteRepository lessonNoteRepository;

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_lesson_1);
        NOTE_ID = getString(R.string.expert_lesson_1_note_id);

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
        lessonNoteRepository = new LessonNoteRepository(this);
    }

    private void updateLessonNoteBackground() {
        String note = editLessonNote.getText().toString();
        lessonNoteRepository.updateLessonNoteBackground(NOTE_ID, note);
        showToast(getString(R.string.note_updated));
    }

    private void loadLessonNote() {
        lessonNoteRepository.loadLessonNoteBackground(NOTE_ID, new LessonNoteRepository.LessonNoteLoadCallback() {
            @Override
            public void onLessonNoteLoaded(LessonNote lessonNote) {
                handler.post(() -> editLessonNote.setText(lessonNote.getNote()));
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, String.format("Error loading lesson note: %s", errorMessage));
                showToast(getString(R.string.error_load_note));
            }
        });
    }

    private void showToast(String message) {
        handler.post(() -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());
    }
}