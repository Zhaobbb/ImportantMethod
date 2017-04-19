package com.example.joker.importantmethod.Fragments;

import android.os.Handler;

import com.example.joker.importantmethod.Data.Community_firstData;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

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

    private int images[] = {
            R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt,R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt
    };
    private String[] titles={"赵镜博","石岳松","李鑫","王乐","邓威","马一凡","雷亚强","高博"};
    private int[] nums={100,210,45,15,48,96,36,75};
    private String[] texts={"最帅的人","狗狗狗汪汪汪","安达市大所多","上的撒打算","第三大十多个","合格后风格","以后就卡一会","温如言亦如此不能"};

    private RefreshableView refreshableView;
    @Override
    protected void initView() {
        init();



        for(int i=0;i<8;i++){
            Community_firstData community_firstData=new Community_firstData();
            community_firstData.setCommunity_first_head(images[i]);
            community_firstData.setCommunity_first_num(nums[i]);
            community_firstData.setCommunity_first_title(titles[i]);
            community_firstData.setCommunity_first_text(texts[i]);
            baselist.add(community_firstData);
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


        // 设置刷新和加载更多数据的监听，分别在onRefresh()和onLoadMore()方法中执行刷新和加载更多操作
//        rv.setLoadDataListener(new AnimRFRecyclerView.LoadDataListener() {
//            @Override
//            public void onRefresh() {
//                new Thread(new MyRunnable(true)).start();
//            }
//
//            @Override
//            public void onLoadMore() {
//                new Thread(new MyRunnable(false)).start();
//            }
//        });
    }

    private Handler mHandler = new Handler();

//    class MyRunnable implements Runnable {
//
//        boolean isRefresh;
//
//        public MyRunnable(boolean isRefresh) {
//            this.isRefresh = isRefresh;
//        }
//
//        @Override
//        public void run() {
//            mHandler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    if (isRefresh) {
//                        newData();
//                        refreshComplate();
//                        // 刷新完成后调用，必须在UI线程中
//                        rv.refreshComplate();
//                    } else {
//                        addData();
//                        loadMoreComplate();
//                        // 加载更多完成后调用，必须在UI线程中
//                        rv.loadMoreComplate();
//                    }
//                }
//            }, 2000);
//        }
//    }

//    private void addData() {
//
//            for(int j=0;j<8;j++){
//                Community_firstData community_firstData=new Community_firstData();
//                community_firstData.setCommunity_first_head(images[j]);
//                community_firstData.setCommunity_first_num(nums[j]);
//                community_firstData.setCommunity_first_title("加载架在记载咋加载加载");
//                community_firstData.setCommunity_first_text("加载架在记载咋加载加载");
//                baselist.add(community_firstData);
//            }
//
//
//    }
//
//    public void newData() {
//        baselist.clear();
//        for(int j=0;j<8;j++){
//            Community_firstData community_firstData=new Community_firstData();
//            community_firstData.setCommunity_first_head(images[j]);
//            community_firstData.setCommunity_first_num(nums[j]);
//            community_firstData.setCommunity_first_title("刷新刷新刷新刷新刷新刷新刷新");
//            community_firstData.setCommunity_first_text("刷新刷新刷新刷新刷新刷新刷新");
//            baselist.add(community_firstData);
//        }
//    }
}
