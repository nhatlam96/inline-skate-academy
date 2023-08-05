package com.hs_worms.android.inlineskateacademy;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {LessonNote.class}, version = 1)
@SuppressWarnings("all")
public abstract class LessonNoteDatabase extends RoomDatabase {

    public abstract LessonNoteDAO getLessonNoteDAO();
}