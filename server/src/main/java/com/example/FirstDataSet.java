package com.example;

import java.io.Serializable;

/**
 * Created by joker on 2017/4/27.
 */

public class FirstDataSet implements Serializable {
    ViewpagerData viewpagerData;
    ContentData contentData;
    Hot_idea_Data hot_idea_data;

    public FirstDataSet(ViewpagerData viewpagerData, ContentData contentData, Hot_idea_Data hot_idea_data) {
        this.viewpagerData = viewpagerData;
        this.contentData = contentData;
        this.hot_idea_data = hot_idea_data;
    }
}
