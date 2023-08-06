package com.hs_worms.android.inlineskateacademy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

public class UIHelper {

    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static void showToast(Context context, int resId) {
        showToast(context, context.getString(resId));
    }

    public static void showToast(Context context, String message) {
        handler.post(() -> Toast.makeText(context, message, Toast.LENGTH_SHORT).show());
    }

    public static void setupRecyclerView(RecyclerView recyclerView, Lesson[] lessons, LessonAdapter.OnItemClickListener listener) {
        LessonAdapter adapter = new LessonAdapter(lessons);
        adapter.setOnItemClickListener(listener);
        recyclerView.setAdapter(adapter);
    }
}