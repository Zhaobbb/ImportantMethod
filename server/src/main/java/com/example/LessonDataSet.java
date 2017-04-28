package com.example;

import java.io.Serializable;

/**
 * Created by joker on 2017/4/28.
 */

public class LessonDataSet implements Serializable {
    private ViewpagerData viewpagerData;
    private LessonData lessonData;

    public LessonDataSet(ViewpagerData viewpagerData, LessonData lessonData) {
        this.viewpagerData = viewpagerData;
        this.lessonData = lessonData;
    }
}
