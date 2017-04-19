package com.example.joker.importantmethod.Fragments;

import com.example.joker.importantmethod.Data.Community_secondData;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

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
    @Override
    protected void initView() {
        init();

        Community_secondData community_secondData=new Community_secondData();
        community_secondData.setCommunity_second_img(R.drawable.eee);
        community_secondData.setCommunity_second_title("卢拉鲁拉鲁");
        community_secondData.setCommunity_second_address("上地七街环岛西");
        community_secondData.setCommunity_second_date("2018-10-56  8:30");
        community_secondData.setCommunity_second_price("¥"+(int)( Math.random()*100));
        community_secondData.setCommunity_second_taker((int)( Math.random()*30));


        Community_secondData community_secondData2=new Community_secondData();
        community_secondData2.setCommunity_second_img(R.drawable.qwqwq);
        community_secondData2.setCommunity_second_title("这肯定是个女的");
        community_secondData2.setCommunity_second_address("黄土高坡第二沙漠第八课白杨树旁边");
        community_secondData2.setCommunity_second_date("2017-08-15  10:30");
        community_secondData2.setCommunity_second_price("¥"+(int)( Math.random()*100));
        community_secondData2.setCommunity_second_taker((int)( Math.random()*30));

        baselist.add(community_secondData);
        baselist.add(community_secondData2);

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
