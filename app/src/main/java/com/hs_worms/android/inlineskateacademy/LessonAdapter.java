package com.hs_worms.android.inlineskateacademy;

import android.content.Context;
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
    private OnItemClickListener listener;

    public LessonAdapter(Lesson[] lessons) {
        this.lessons = lessons;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_lesson, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        holder.bindViewHolder(lessons[position]);
        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemClick(lessons[position]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessons.length;
    }

    public interface OnItemClickListener {
        void onItemClick(Lesson lesson);
    }

    class LessonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            itemView.setOnClickListener(this);
        }

        public void bindViewHolder(Lesson lesson) {
            lessonTitle.setText(lesson.title);
            lessonDescription.setText(lesson.description);
            lessonImage.setImageResource(lesson.image);
            lessonImage.setBackgroundColor(lesson.backgroundColor);
            lessonBackgroundColor.setCardBackgroundColor(lesson.backgroundColor);
        }

        @Override
        public void onClick(View view) {
            int position = getAbsoluteAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                Lesson lesson = lessons[position];
                listener.onItemClick(lesson);
            }
        }
    }
}