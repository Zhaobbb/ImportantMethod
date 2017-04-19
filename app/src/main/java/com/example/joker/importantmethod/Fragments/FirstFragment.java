package com.example.joker.importantmethod.Fragments;

import com.example.joker.importantmethod.Data.ContentData;
import com.example.joker.importantmethod.Data.GridViewData;
import com.example.joker.importantmethod.Data.Hot_idea_Data;
import com.example.joker.importantmethod.Data.ViewpagerData;
import com.example.joker.importantmethod.R;
import com.example.joker.importantmethod.View.RefreshableView;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/12.
 */

public class FirstFragment extends BaseFragment {
    @Override
    protected int getFragmentView() {

        return R.layout.firstfragments;
    }

    @Override
    protected int getRecyclerview() {
        return R.id.baserecyclerview;
    }
    private int images[] = {
            R.drawable.eee,R.drawable.ytytyt,R.drawable.qwqwq,R.drawable.ttt
    };
    private String strs[]={
            "教育","艺术","英语","故事","自然","美食","健康","乐途","乐途","更多"
    };
    private int imgs[]= {
                R.drawable.icon_podcast_education, R.drawable.icon_podcast_art, R.drawable.icon_podcast_english,
           R.drawable.icon_podcast_food, R.drawable.icon_podcast_happytrip, R.drawable.icon_podcast_nature,
           R.drawable.icon_podcast_more, R.drawable.icon_podcast_story, R.drawable.icon_podcast_story, R.drawable.icon_podcast_more
   };
   private ArrayList<Integer> imglist;
    private ArrayList<String> textlist;

    private ArrayList<Integer> hot_idea_img;
    private ArrayList<String> hot_idea_text;
    private ArrayList<String> hot_idea_provider;
    private ArrayList<Integer> hot_idea_interestnum;

    private RefreshableView refreshableView;
    @Override
    protected void initView() {
        init();

//        contentdata1.setText("FirstFragment1111");
//        NoData noData=new NoData();
//        noData.setNodata("没有数据哦");
//        ContentData contentdata3=new ContentData();
//        contentdata3.setText("FirstFragment3333");
        ViewpagerData viewpagerData=new ViewpagerData();
        viewpagerData.setImgs(images);

        imglist=new ArrayList<>();
        textlist=new ArrayList<>();
        for(int i=0;i<imgs.length;i++){
            imglist.add(imgs[i]);
            textlist.add(strs[i]);
        }
        GridViewData gridViewData=new GridViewData();
        gridViewData.setGridimgs(imglist);
        gridViewData.setGridtexts(textlist);

        ContentData contentdata=new ContentData();
        contentdata.setHead_img(R.drawable.touxiang);
        contentdata.setSuper_name("我是名字");
        contentdata.setSuper_describe("这里是描述这里是描述这里是描述");

        Hot_idea_Data hot_idea_data=new Hot_idea_Data();
        hot_idea_img=new ArrayList<>();
          hot_idea_text=new ArrayList<>();
       hot_idea_provider=new ArrayList<>();
         hot_idea_interestnum=new ArrayList<>();
        for(int i=0;i<10;i++){
            hot_idea_img.add(R.drawable.aaaa);
            hot_idea_text.add("汪汪汪汪");
            hot_idea_provider.add("一只狗");
            hot_idea_interestnum.add(65656);
        }
        hot_idea_data.setHot_idea_img(hot_idea_img);
        hot_idea_data.setHot_idea_text(hot_idea_text);
        hot_idea_data.setHot_idea_provider(hot_idea_provider);
                hot_idea_data.setHot_idea_interestnum(hot_idea_interestnum);



//        baselist.add(noData);
//        baselist.add(contentdata3);
        baselist.add(viewpagerData);
        baselist.add(gridViewData);
        baselist.add(contentdata);
        baselist.add(hot_idea_data);

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
