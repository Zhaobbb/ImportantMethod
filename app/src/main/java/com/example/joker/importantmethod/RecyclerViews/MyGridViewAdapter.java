package com.example.joker.importantmethod.RecyclerViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.joker.importantmethod.R;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/28.
 */

public class MyGridViewAdapter extends BaseAdapter {


    private ArrayList<String> gridadapter_img;
    private ArrayList<String> gridadapter_title;
    private ArrayList<String> gridadapter_provider;
    private ArrayList<Integer> gridadapter_interestnum;


    private LayoutInflater mInflater;
    private Context mContext;

    public MyGridViewAdapter(ArrayList<String> gridadapter_img,
                             ArrayList<String> gridadapter_title,
                             ArrayList<String> gridadapter_provider,
                             ArrayList<Integer> gridadapter_interestnum,
                             Context mContext) {
        this.gridadapter_img = gridadapter_img;
        this.gridadapter_title = gridadapter_title;
        this.gridadapter_provider = gridadapter_provider;
        this.gridadapter_interestnum = gridadapter_interestnum;
        this.mContext = mContext;
        mInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        if(gridadapter_img!=null){
            return gridadapter_img.size();
        }

        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        if(gridadapter_img!=null){
            return i;
        }
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ImageView hot_idea_img;
        TextView hot_idea_title;
        TextView hot_idea_provider;
        TextView hot_idea_interestnum;

        View gridview = mInflater.inflate(R.layout.hot_idea_item,null);

        hot_idea_img= (ImageView) gridview.findViewById(R.id.hot_idea_img);
        hot_idea_title = (TextView) gridview.findViewById(R.id.hot_idea_title);
        hot_idea_provider= (TextView) gridview.findViewById(R.id.hot_idea_provider);
        hot_idea_interestnum= (TextView) gridview.findViewById(R.id.hot_idea_interestnum);

        Glide.with(mContext)
                .load(gridadapter_img.get(i))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(hot_idea_img);

        hot_idea_title.setText(gridadapter_title.get(i));

        hot_idea_provider.setText(gridadapter_provider.get(i));

                hot_idea_interestnum.setText(gridadapter_interestnum.get(i)+"");

        return gridview;
    }
}
