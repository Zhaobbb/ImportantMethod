package com.example;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/14.
 */

public class MethodData extends BaseData {
    ArrayList<String> methodcard_background;
    ArrayList<String> methodcard_title;
    ArrayList<Integer> methodcard_sawnum;
    ArrayList<Integer> methodcard_likenum;

    public MethodData(ArrayList<String> methodcard_background,
                      ArrayList<String> methodcard_title,
                      ArrayList<Integer> methodcard_sawnum,
                      ArrayList<Integer> methodcard_likenum)
    {
        this.methodcard_background = methodcard_background;
        this.methodcard_title = methodcard_title;
        this.methodcard_sawnum = methodcard_sawnum;
        this.methodcard_likenum = methodcard_likenum;
    }
}
