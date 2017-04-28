package com.example.joker.importantmethod.Fragments;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.joker.importantmethod.Data.Community_firstData;
import com.example.joker.importantmethod.Listener.CustomRequest;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by joker on 2017/4/14.
 */

public class Community_First extends BaseFragment {
    @Override
    protected int getFragmentView() {
        return R.layout.firstfragments;
    }

    @Override
    protected int getRecyclerview() {
        return R.id.baserecyclerview;
    }



    private RefreshableView refreshableView;

    String firstpath="http://169.254.217.200:8989/getmethodfirst";
    private RequestQueue mRequestQueue;
    @Override
    protected void initView() {
        init();

        mRequestQueue = Volley.newRequestQueue(getContext());
        CustomRequest firstRequest = new CustomRequest(firstpath, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject=new JSONObject(response);

                    JSONArray headarr=jsonObject.getJSONArray("community_first_head");

                    JSONArray titlearr=jsonObject.getJSONArray("community_first_title");

                    JSONArray numarr=jsonObject.getJSONArray("community_first_num");

                    JSONArray textarr=jsonObject.getJSONArray("community_first_text");

                for(int i=0;i<textarr.length();i++) {
                    Community_firstData community_firstData = new Community_firstData();

                    community_firstData.setCommunity_first_head(headarr.getString(i));

                    community_firstData.setCommunity_first_num(numarr.getInt(i));

                    community_firstData.setCommunity_first_title(titlearr.getString(i));
                    community_firstData.setCommunity_first_text(textarr.getString(i));
                    baselist.add(community_firstData);

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
        mRequestQueue.add(firstRequest);

//        for(int i=0;i<8;i++){
//            Community_firstData community_firstData=new Community_firstData();
//            community_firstData.setCommunity_first_head(images[i]);
//            community_firstData.setCommunity_first_num(nums[i]);
//            community_firstData.setCommunity_first_title(titles[i]);
//            community_firstData.setCommunity_first_text(texts[i]);
//            baselist.add(community_firstData);
//        }

        refreshableView = (RefreshableView) view.findViewById(R.id.refreshableview);
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

        }, 0);

        adapter.notifyDataSetChanged();


    }
}
