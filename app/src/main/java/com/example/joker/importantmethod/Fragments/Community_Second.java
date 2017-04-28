package com.example.joker.importantmethod.Fragments;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.joker.importantmethod.Data.Community_secondData;
import com.example.joker.importantmethod.Listener.CustomRequest;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by joker on 2017/4/14.
 */

public class Community_Second extends BaseFragment {
    @Override
    protected int getFragmentView() {
        return R.layout.huodongfragment;
    }

    @Override
    protected int getRecyclerview() {
        return R.id.huodong_recyclerview;
    }

    private RefreshableView refreshableView;

    String secondpath="http://169.254.217.200:8989/getmethodsecond";
    private RequestQueue mRequestQueue;
    @Override
    protected void initView() {
        init();

        mRequestQueue = Volley.newRequestQueue(getContext());
        CustomRequest secondRequest=new CustomRequest(secondpath, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray secondimg=jsonObject.getJSONArray("community_second_img");
                    JSONArray secondtitle=jsonObject.getJSONArray("community_second_title");
                    JSONArray seconddate=jsonObject.getJSONArray("community_second_date");
                    JSONArray secondaddress=jsonObject.getJSONArray("community_second_address");
                    JSONArray secondprice=jsonObject.getJSONArray("community_second_price");
                    JSONArray secondtaker=jsonObject.getJSONArray("community_second_taker");
                    for(int i=0;i<secondimg.length();i++){
                        Community_secondData community_secondData2=new Community_secondData();
                        community_secondData2.setCommunity_second_img(secondimg.getString(i));
                        community_secondData2.setCommunity_second_title(secondtitle.getString(i));

                        community_secondData2.setCommunity_second_date(seconddate.getString(i));
                        community_secondData2.setCommunity_second_address(secondaddress.getString(i));
                        community_secondData2.setCommunity_second_price(secondprice.getString(i));
                        community_secondData2.setCommunity_second_taker(secondtaker.getInt(i));


                        baselist.add(community_secondData2);
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
        mRequestQueue.add(secondRequest);

//        Community_secondData community_secondData=new Community_secondData();
//        community_secondData.setCommunity_second_img(R.drawable.eee);
//        community_secondData.setCommunity_second_title("卢拉鲁拉鲁");
//        community_secondData.setCommunity_second_address("上地七街环岛西");
//        community_secondData.setCommunity_second_date("2018-10-56  8:30");
//        community_secondData.setCommunity_second_price("¥"+(int)( Math.random()*100));
//        community_secondData.setCommunity_second_taker((int)( Math.random()*30));




        refreshableView= (RefreshableView) view.findViewById(R.id.refreshableview3);
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
