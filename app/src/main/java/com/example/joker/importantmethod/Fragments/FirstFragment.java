package com.example.joker.importantmethod.Fragments;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.joker.importantmethod.Data.ContentData;
import com.example.joker.importantmethod.Data.GridViewData;
import com.example.joker.importantmethod.Data.Hot_idea_Data;
import com.example.joker.importantmethod.Data.ViewpagerData;
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

public class FirstFragment extends BaseFragment {
    @Override
    protected int getFragmentView() {

        return R.layout.firstfragments;
    }

    @Override
    protected int getRecyclerview() {
        return R.id.baserecyclerview;
    }
    private String[] vpimages =
            new String[4];
//            {
//            "http://d.5857.com/fmsn_170307/desk_014.jpg","http://d.5857.com/jxxg_170309/desk_002.jpg"
//            , "http://d.5857.com/xgs_150428/desk_005.jpg", "http://d.5857.com/ctmn_170307/desk_008.jpg"
//    };

    private String gstrs[]={
            "教育","艺术","英语","故事","自然","美食","健康","乐途","乐途","更多"
    };
    private int gimgs[]= {
                R.drawable.icon_podcast_education, R.drawable.icon_podcast_art, R.drawable.icon_podcast_english,
           R.drawable.icon_podcast_food, R.drawable.icon_podcast_happytrip, R.drawable.icon_podcast_nature,
           R.drawable.icon_podcast_more, R.drawable.icon_podcast_story, R.drawable.icon_podcast_story, R.drawable.icon_podcast_more
   };
   private ArrayList<Integer> imglist;
    private ArrayList<String> textlist;

    private ArrayList<String> hot_idea_img;
    private ArrayList<String> hot_idea_text;
    private ArrayList<String> hot_idea_provider;
    private ArrayList<Integer> hot_idea_interestnum;

    private RefreshableView refreshableView;
    private String superman_img=null;
    private String superman_name=null;
    private String superman_describe=null;

    String path="http://169.254.217.200:8989/getfirstpage";
    private RequestQueue mRequestQueue;
    @Override
    protected void initView() {
        init();

        hot_idea_img=new ArrayList<>();
        hot_idea_text=new ArrayList<>();
        hot_idea_provider=new ArrayList<>();
        hot_idea_interestnum=new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getContext());
        CustomRequest stringRequest = new CustomRequest(path,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject=new JSONObject(response);

                            //顶部轮播
                            JSONObject jsonviewpagerdata=jsonObject.getJSONObject("viewpagerData");
                            JSONArray ja1=jsonviewpagerdata.getJSONArray("imgs");


                            for(int i=0;i<ja1.length();i++){
                                String jj=ja1.getString(i);
                                vpimages[i]=jj;

                            }
                            ViewpagerData viewpagerData=new ViewpagerData();
                            viewpagerData.setImgs(vpimages);
                            baselist.add(viewpagerData);

                            //GridView
                            imglist=new ArrayList<>();
                            textlist=new ArrayList<>();
                            for(int i=0;i<gimgs.length;i++){
                                imglist.add(gimgs[i]);
                                textlist.add(gstrs[i]);
                            }
                            GridViewData gridViewData=new GridViewData();
                            gridViewData.setGridimgs(imglist);
                            gridViewData.setGridtexts(textlist);
                            baselist.add(gridViewData);

                            //推荐达人
                            JSONObject jsoncontentdata=jsonObject.getJSONObject("contentData");
                            superman_img=jsoncontentdata.getString("head_img");
                            superman_name=jsoncontentdata.getString("super_name");
                            superman_describe=jsoncontentdata.getString("super_describe");


                            ContentData contentdata=new ContentData();
                            contentdata.setHead_img(superman_img);
                            contentdata.setSuper_name(superman_name);
                            contentdata.setSuper_describe(superman_describe);
                            baselist.add(contentdata);


                            //热门妙招
                            JSONObject jsonhot_idea_data=jsonObject.getJSONObject("hot_idea_data");
                            JSONArray imgarray=jsonhot_idea_data.getJSONArray("hot_idea_img");

                            for(int i=0;i<imgarray.length();i++){
                                hot_idea_img.add(imgarray.getString(i));
                            }
                            JSONArray textarray=jsonhot_idea_data.getJSONArray("hot_idea_text");
                            for(int i=0;i<textarray.length();i++){
                                hot_idea_text.add(textarray.getString(i));
                            }
                            JSONArray providerarray=jsonhot_idea_data.getJSONArray("hot_idea_provider");
                            for(int i=0;i<textarray.length();i++){
                                hot_idea_provider.add(providerarray.getString(i));
                            }
                            JSONArray interestnumarray=jsonhot_idea_data.getJSONArray("hot_idea_interestnum");
                            for(int i=0;i<textarray.length();i++){
                                hot_idea_interestnum.add(interestnumarray.getInt(i));
                            }
                            Hot_idea_Data hot_idea_data=new Hot_idea_Data();

//        for(int i=0;i<10;i++){
//            hot_idea_img.add(R.drawable.aaaa);
//            hot_idea_text.add("汪汪汪汪");
//            hot_idea_provider.add("一只狗");
//            hot_idea_interestnum.add(65656);
//        }
                            hot_idea_data.setHot_idea_img(hot_idea_img);
                            hot_idea_data.setHot_idea_text(hot_idea_text);
                            hot_idea_data.setHot_idea_provider(hot_idea_provider);
                            hot_idea_data.setHot_idea_interestnum(hot_idea_interestnum);


                            baselist.add(hot_idea_data);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);

            }
        });
        mRequestQueue.add(stringRequest);





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
