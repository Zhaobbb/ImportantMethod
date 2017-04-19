package com.example.joker.importantmethod.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.importantmethod.Data.BaseData;
import com.example.joker.importantmethod.Manager.AnimRFLinearLayoutManager;
import com.example.joker.importantmethod.RecyclerViews.RecyclerViewAdapter;
import com.example.joker.importantmethod.View.RefreshableView;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/11.
 */

public abstract class BaseFragment extends Fragment {



    protected View view;
    protected RecyclerView rv;
    protected ArrayList<BaseData> baselist;
    protected RecyclerViewAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(getFragmentView(),null);

        initView();
        return view;
    }

    protected void init() {

        // 头部

        rv= (RecyclerView) view.findViewById(getRecyclerview());

        baselist=new ArrayList<>();
//        ContentData contentdata=new ContentData();

//        contentdata.setText("这里有数据哦");
//
//        baselist.add(contentdata);

        adapter=new RecyclerViewAdapter(baselist,getContext());

        LinearLayoutManager ma=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        AnimRFLinearLayoutManager manager = new AnimRFLinearLayoutManager(getActivity());
        rv.setLayoutManager(ma);
//        rv.addItemDecoration(new DividerItemDecoration(getActivity(), manager.getOrientation(), true));
//        rv.setColor(Color.BLACK, Color.WHITE);
//        rv.addHeaderView(headerView);
//        rv.setHeaderImage((ImageView) headerView.findViewById(R.id.refresh_img));


        rv.setAdapter(adapter);
    }

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
////                        newData();
//                        refreshComplate();
//                        // 刷新完成后调用，必须在UI线程中
//                        rv.refreshComplate();
//                    } else {
////                        addData();
//                        loadMoreComplate();
//                        // 加载更多完成后调用，必须在UI线程中
//                        rv.loadMoreComplate();
//                    }
//                }
//            }, 2000);
//        }
//    }




    public void refreshComplate() {
        rv.getAdapter().notifyDataSetChanged();
    }

    public void loadMoreComplate() {
        rv.getAdapter().notifyDataSetChanged();
    }

    protected abstract int getFragmentView();
    protected abstract int getRecyclerview();
    protected abstract void initView();
}
