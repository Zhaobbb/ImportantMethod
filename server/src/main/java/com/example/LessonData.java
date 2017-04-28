package com.example;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/14.
 */

public class LessonData extends BaseData {
    private ArrayList<String> lesson_img;
    private  ArrayList<String> lesson_title;
    private ArrayList<String> lesson_date;
    private  ArrayList<String> lesson_price;
    private ArrayList<String> lesson_provider;
    private ArrayList<Integer> lesson_looker;

    public LessonData(ArrayList<String> lesson_img,
                      ArrayList<String> lesson_title,
                      ArrayList<String> lesson_date,
                      ArrayList<String> lesson_price,
                      ArrayList<String> lesson_provider,
                      ArrayList<Integer> lesson_looker) {
        this.lesson_img = lesson_img;
        this.lesson_title = lesson_title;
        this.lesson_date = lesson_date;
        this.lesson_price = lesson_price;
        this.lesson_provider = lesson_provider;
        this.lesson_looker = lesson_looker;
    }
}
