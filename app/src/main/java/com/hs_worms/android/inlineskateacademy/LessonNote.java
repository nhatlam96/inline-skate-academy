package com.hs_worms.android.inlineskateacademy;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lesson_note")
public class LessonNote {

    @ColumnInfo(name = "id")
    @PrimaryKey
    private final int id;
    @ColumnInfo(name = "note")
    private final String note;

    public LessonNote(int id, String note) {
        this.id = id;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }
}