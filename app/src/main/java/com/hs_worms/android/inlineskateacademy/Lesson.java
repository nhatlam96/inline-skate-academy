package com.hs_worms.android.inlineskateacademy;

public class Lesson {

    String title;
    String description;
    int image;
    int backgroundColor;

    public Lesson(String title, String description, int image, int backgroundColor) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }
}
