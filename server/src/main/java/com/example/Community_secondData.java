package com.example;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/14.
 */

public class Community_secondData extends BaseData {
    ArrayList<String> community_second_img;
    ArrayList<String> community_second_title;
    ArrayList<String> community_second_date;
    ArrayList<String> community_second_address;
    ArrayList<String> community_second_price;
    ArrayList<Integer> community_second_taker;

    public Community_secondData(ArrayList<String> community_second_img,
                                ArrayList<String> community_second_title,
                                ArrayList<String> community_second_date,
                                ArrayList<String> community_second_address,
                                ArrayList<String> community_second_price,
                                ArrayList<Integer> community_second_taker) {
        this.community_second_img = community_second_img;
        this.community_second_title = community_second_title;
        this.community_second_date = community_second_date;
        this.community_second_address = community_second_address;
        this.community_second_price = community_second_price;
        this.community_second_taker = community_second_taker;
    }
}
