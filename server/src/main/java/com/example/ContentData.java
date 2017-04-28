package com.example;

/**
 * Created by joker on 2017/4/12.
 */

public class ContentData extends BaseData {
    String head_img;
    String super_name;
    String super_describe;

    public ContentData(String head_img, String super_name, String super_describe) {
        this.head_img = head_img;
        this.super_name = super_name;
        this.super_describe = super_describe;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getSuper_name() {
        return super_name;
    }

    public void setSuper_name(String super_name) {
        this.super_name = super_name;
    }

    public String getSuper_describe() {
        return super_describe;
    }

    public void setSuper_describe(String super_describe) {
        this.super_describe = super_describe;
    }
}
