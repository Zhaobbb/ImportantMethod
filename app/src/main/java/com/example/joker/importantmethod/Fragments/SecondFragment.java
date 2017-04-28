package com.example.joker.importantmethod.Fragments;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.joker.importantmethod.Data.MethodData;
import com.example.joker.importantmethod.Listener.CustomRequest;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/12.
 */

public class SecondFragment extends BaseFragment {
    @Override
    protected int getFragmentView() {
        return R.layout.firstfragments;
    }

    @Override
    protected int getRecyclerview() {
        return R.id.baserecyclerview;
    }

    String[] titles={"吉泽简单英语小故事","我来帮你搬走杨瓦路上的绊脚石！","放假啦！带着娃来旅行吧","和宝宝在一起就要创作","教小朋友画画发愁？我有宝库"};
    String[] imgs=new String[5];
//            { R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt,R.drawable.ytytyt};
    private ArrayList<String> title_list=new ArrayList<>();
    private ArrayList<Integer> sawnum_list=new ArrayList<>();
    private ArrayList<Integer> likenum_list=new ArrayList<>();
    private ArrayList<String> background_list=new ArrayList<>();

    private RefreshableView refreshableView;
    private RequestQueue mRequestQueue;
    String methodPath="http://169.254.217.200:8989/getmethodpage";
    @Override
    protected void initView() {
        init();


        mRequestQueue= Volley.newRequestQueue(getContext());
        CustomRequest methodrequest=new CustomRequest(methodPath, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray imgarr=jsonObject.getJSONArray("methodcard_background");
                    for(int i=0;i<imgarr.length();i++){
                        background_list.add(imgarr.getString(i));
                    }
                    JSONArray titlearr=jsonObject.getJSONArray("methodcard_title");
                    for(int i=0;i<titlearr.length();i++){
                        title_list.add(titlearr.getString(i));
                    }

                    JSONArray sawarr=jsonObject.getJSONArray("methodcard_sawnum");
                    for(int i=0;i<sawarr.length();i++){
                        sawnum_list.add(sawarr.getInt(i));
                    }

                    JSONArray likearr=jsonObject.getJSONArray("methodcard_likenum");
                    for(int i=0;i<likearr.length();i++){
                        likenum_list.add(likearr.getInt(i));
                    }



                    for(int i=0;i<5;i++) {
                        MethodData methodData = new MethodData();
                        methodData.setMethodcard_background(background_list.get(i));
                        methodData.setMethodcard_title(title_list.get(i));
                        methodData.setMethodcard_likenum(likenum_list.get(i));
                        methodData.setMethodcard_sawnum(sawnum_list.get(i));
                        baselist.add(methodData);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "失败失败失败失败失败失败失败失败");
            }
        });

        mRequestQueue.add(methodrequest);



//        for (int i=0;i<5;i++){
//            int q= (int) (Math.random()*500);
//            int w= (int) (Math.random()*500);
//            title_list.add(titles[i]);
//            sawnum_list.add(q);
//            likenum_list.add(w);
//            background_list.add(imgs[i]);
//        }
//


        refreshableView= (RefreshableView) view.findViewById(R.id.refreshableview);
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
