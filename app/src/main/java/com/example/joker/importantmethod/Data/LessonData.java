package com.example.joker.importantmethod.Data;

/**
 * Created by joker on 2017/4/14.
 */

public class LessonData extends BaseData {
    int lesson_img;
    String lesson_title;
    String lesson_date;
    String lesson_price;
    String lesson_provider;
    int lesson_looker;

    public int getLesson_img() {
        return lesson_img;
    }

    public void setLesson_img(int lesson_img) {
        this.lesson_img = lesson_img;
    }

    public String getLesson_title() {
        return lesson_title;
    }

    public void setLesson_title(String lesson_title) {
        this.lesson_title = lesson_title;
    }

    public String getLesson_date() {
        return lesson_date;
    }

    public void setLesson_date(String lesson_date) {
        this.lesson_date = lesson_date;
    }

    public String getLesson_price() {
        return lesson_price;
    }

    public void setLesson_price(String lesson_price) {
        this.lesson_price = lesson_price;
    }

    public String getLesson_provider() {
        return lesson_provider;
    }

    public void setLesson_provider(String lesson_provider) {
        this.lesson_provider = lesson_provider;
    }

    public int getLesson_looker() {
        return lesson_looker;
    }

    public void setLesson_looker(int lesson_looker) {
        this.lesson_looker = lesson_looker;
    }
}
