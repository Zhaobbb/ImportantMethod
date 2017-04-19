package com.example.joker.importantmethod.Data;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/14.
 */

public class Hot_idea_Data extends BaseData {
    ArrayList<Integer> hot_idea_img;
    ArrayList<String> hot_idea_text;
    ArrayList<String> hot_idea_provider;
    ArrayList<Integer> hot_idea_interestnum;

    public ArrayList<Integer> getHot_idea_img() {
        return hot_idea_img;
    }

    public void setHot_idea_img(ArrayList<Integer> hot_idea_img) {
        this.hot_idea_img = hot_idea_img;
    }

    public ArrayList<String> getHot_idea_text() {
        return hot_idea_text;
    }

    public void setHot_idea_text(ArrayList<String> hot_idea_text) {
        this.hot_idea_text = hot_idea_text;
    }

    public ArrayList<String> getHot_idea_provider() {
        return hot_idea_provider;
    }

    public void setHot_idea_provider(ArrayList<String> hot_idea_provider) {
        this.hot_idea_provider = hot_idea_provider;
    }

    public ArrayList<Integer> getHot_idea_interestnum() {
        return hot_idea_interestnum;
    }

    public void setHot_idea_interestnum(ArrayList<Integer> hot_idea_interestnum) {
        this.hot_idea_interestnum = hot_idea_interestnum;
    }
}
