package com.example.joker.importantmethod.Fragments;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.joker.importantmethod.Data.LessonData;
import com.example.joker.importantmethod.Data.ViewpagerData;
import com.example.joker.importantmethod.Listener.CustomRequest;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    private String[] vimages = new String[4];
//            {
//            "http://d.5857.com/fmsn_170307/desk_014.jpg","http://d.5857.com/jxxg_170309/desk_002.jpg"
//            , "http://d.5857.com/xgs_150428/desk_005.jpg", "http://d.5857.com/ctmn_170307/desk_008.jpg"
//    };
    private int images[] = {
            R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt,R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt
    };
    private String[] titles={"只要一场游戏，解决你的遇而烦恼","销售时挡住大脾气，做个不发货妈妈","如何在家红牌饼干","父母适当放手让孩子","宝宝吃饭的是，不再是难事","带给孩子温暖的同年与手的共鸣","你有房吗你有车吗你有钱吗你就生孩子","你买得起孩子的奶粉钱吗？"};
    private int[] lookers={100,210,45,15,48,96,36,75};
    private String[] dates={"2016-12-21 20:00","2016-12.20 20:00","2011-11.20 10:00","2016-12.22 22:22","2012-12.12 18:00","2017-12.27 07:00","2016-12.26 22:40","2016-12.20 20:00"};
    private String[] prices={"¥15","免费","¥5","免费","免费","免费","¥6","免费"};
    private String[] providers={"Tony","Jerry","Jack","Tom","Talor","Peter","Ann","Ken"};


    private RefreshableView refreshableView;

    private RequestQueue mRequestQueue;
    String LessonPath="http://169.254.217.200:8989/getlesson";
    @Override
    protected void initView() {
        init();

        mRequestQueue= Volley.newRequestQueue(getContext());
        CustomRequest lessonrequest=new CustomRequest(LessonPath, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);

                    //添加头部轮播
                    JSONObject viewpagerob=jsonObject.getJSONObject("viewpagerData");
                    JSONArray jsonArray11=viewpagerob.getJSONArray("imgs");
                    for(int i=0;i<jsonArray11.length();i++){
                        vimages[i]=jsonArray11.getString(i);
                    }
                    ViewpagerData viewpagerData=new ViewpagerData();
                    viewpagerData.setImgs(vimages);

                    baselist.add(viewpagerData);

                    //添加Lesson数据
                    JSONObject lessonob=jsonObject.getJSONObject("lessonData");
                    JSONArray lessonimg=lessonob.getJSONArray("lesson_img");
                    JSONArray lessontitle=lessonob.getJSONArray("lesson_title");
                    JSONArray lessondate=lessonob.getJSONArray("lesson_date");
                    JSONArray lessonprice=lessonob.getJSONArray("lesson_price");
                    JSONArray lessonprovider=lessonob.getJSONArray("lesson_provider");
                    JSONArray lessonlooker=lessonob.getJSONArray("lesson_looker");


                    for(int i=0;i<prices.length;i++){
                        LessonData lessonData=new LessonData();
                        lessonData.setLesson_img(lessonimg.getString(i));
                        lessonData.setLesson_date(lessondate.getString(i));
                        lessonData.setLesson_looker(lessonlooker.getInt(i));
                        lessonData.setLesson_price(lessonprice.getString(i));
                        lessonData.setLesson_provider(lessonprovider.getString(i));
                        lessonData.setLesson_title(lessontitle.getString(i));
                        baselist.add(lessonData);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(lessonrequest);





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
