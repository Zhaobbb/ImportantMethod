package com.example.joker.importantmethod.Fragments;

import com.example.joker.importantmethod.Data.MethodData;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

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
    int[] imgs={ R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt,R.drawable.ytytyt};
    private ArrayList<String> title_list=new ArrayList<>();
    private ArrayList<Integer> sawnum_list=new ArrayList<>();
    private ArrayList<Integer> likenum_list=new ArrayList<>();
    private ArrayList<Integer> background_list=new ArrayList<>();

    private RefreshableView refreshableView;
    @Override
    protected void initView() {
        init();

        for (int i=0;i<5;i++){
            int q= (int) (Math.random()*500);
            int w= (int) (Math.random()*500);
            title_list.add(titles[i]);
            sawnum_list.add(q);
            likenum_list.add(w);
            background_list.add(imgs[i]);
        }
        for(int i=0;i<5;i++) {
            MethodData methodData = new MethodData();
            methodData.setMethodcard_background(background_list.get(i));
            methodData.setMethodcard_title(title_list.get(i));
            methodData.setMethodcard_likenum(likenum_list.get(i));
            methodData.setMethodcard_sawnum(sawnum_list.get(i));
            baselist.add(methodData);
        }


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
