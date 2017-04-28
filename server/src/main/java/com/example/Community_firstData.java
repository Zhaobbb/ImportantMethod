package com.example;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/14.
 */

public class Community_firstData extends BaseData {
    ArrayList<String> community_first_head;
    ArrayList<String> community_first_title;
    ArrayList<Integer> community_first_num;
    ArrayList<String> community_first_text;

    public Community_firstData(ArrayList<String> community_first_head,
                               ArrayList<String> community_first_title,
                               ArrayList<Integer> community_first_num,
                               ArrayList<String> community_first_text) {
        this.community_first_head = community_first_head;
        this.community_first_title = community_first_title;
        this.community_first_num = community_first_num;
        this.community_first_text = community_first_text;
    }
}
