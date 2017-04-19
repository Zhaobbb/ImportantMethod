package com.example.joker.importantmethod.Fragments;

import com.example.joker.importantmethod.Data.LessonData;
import com.example.joker.importantmethod.Data.ViewpagerData;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

/**
 * Created by joker on 2017/4/14.
 */

public class Lesson_Fragment extends BaseFragment {
    @Override
    protected int getFragmentView() {
        return R.layout.lesson_fragment;
    }

    @Override
    protected int getRecyclerview() {
        return R.id.lesson_recyclerview;
    }
    private int vimages[] = {
            R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt
    };
    private int images[] = {
            R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt,R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt
    };
    private String[] titles={"只要一场游戏，解决你的遇而烦恼","销售时挡住大脾气，做个不发货妈妈","如何在家红牌饼干","父母适当放手让孩子","宝宝吃饭的是，不再是难事","带给孩子温暖的同年与手的共鸣","你有房吗你有车吗你有钱吗你就生孩子","你买得起孩子的奶粉钱吗？"};
    private int[] lookers={100,210,45,15,48,96,36,75};
    private String[] dates={"2016-12-21 20:00","2016-12.20 20:00","2011-11.20 10:00","2016-12.22 22:22","2012-12.12 18:00","2017-12.27 07:00","2016-12.26 22:40","2016-12.20 20:00"};
    private String[] prices={"¥15","免费","¥5","免费","免费","免费","¥6","免费"};
    private String[] providers={"Tony","Jerry","Jack","Tom","Talor","Peter","Ann","Ken"};


    private RefreshableView refreshableView;
    @Override
    protected void initView() {
        init();

        ViewpagerData viewpagerData=new ViewpagerData();
        viewpagerData.setImgs(images);

        baselist.add(viewpagerData);

        for(int i=0;i<prices.length;i++){
            LessonData lessonData=new LessonData();
            lessonData.setLesson_img(images[i]);
                    lessonData.setLesson_date(dates[i]);
            lessonData.setLesson_looker(lookers[i]);
                    lessonData.setLesson_price(prices[i]);
            lessonData.setLesson_provider(providers[i]);
                    lessonData.setLesson_title(titles[i]);
            baselist.add(lessonData);
        }

        refreshableView= (RefreshableView) view.findViewById(R.id.refreshableview2);
        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }

        },0);

        adapter.notifyDataSetChanged();
    }
}
