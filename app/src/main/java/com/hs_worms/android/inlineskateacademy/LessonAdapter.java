package com.hs_worms.android.inlineskateacademy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {

    private final Lesson[] lessons;

    public LessonAdapter(Lesson[] lessons) {
        this.lessons = lessons;
    }

    @Override
    public int getItemCount() {
        return lessons.length;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lesson, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        holder.bindViewHolder(lessons[position]);
    }


    static class LessonViewHolder extends RecyclerView.ViewHolder {

        private final ImageView lessonImage;
        private final TextView lessonTitle;
        private final TextView lessonDescription;
        private final CardView lessonBackgroundColor;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            lessonImage = itemView.findViewById(R.id.lesson_image);
            lessonTitle = itemView.findViewById(R.id.lesson_title);
            lessonDescription = itemView.findViewById(R.id.lesson_description);
            lessonBackgroundColor = itemView.findViewById(R.id.card_view_lesson);
        }

        public void bindViewHolder(Lesson lesson) {
            lessonTitle.setText(lesson.title);
            lessonDescription.setText(lesson.description);
            lessonImage.setImageResource(lesson.image);
            lessonImage.setBackgroundColor(lesson.backgroundColor);
            lessonBackgroundColor.setCardBackgroundColor(lesson.backgroundColor);
        }
    }
}