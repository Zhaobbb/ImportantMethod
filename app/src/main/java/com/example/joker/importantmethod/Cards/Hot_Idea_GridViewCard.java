package com.example.joker.importantmethod.Cards;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.joker.importantmethod.Data.BaseData;
import com.example.joker.importantmethod.Data.Hot_idea_Data;
import com.example.joker.importantmethod.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by joker on 2017/4/14.
 */

public class Hot_Idea_GridViewCard extends BaseCard {
    public Hot_Idea_GridViewCard(@NonNull Context context) {
        super(context);
    }

    public Hot_Idea_GridViewCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Hot_Idea_GridViewCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Hot_Idea_GridViewCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getCardView() {
        return R.layout.hotgoodidea;
    }

    @Override
    protected void Viewcreate() {

    }

    private ArrayList<Integer> hot_idea_img;
    private ArrayList<String> hot_idea_title;
    private ArrayList<String> hot_idea_provider;
    private ArrayList<Integer> hot_idea_interestnum;
    @Override
    public void BindData(BaseData basedata) {
        if(basedata==null){
            return;
        }
        Hot_idea_Data hot_idea_data=(Hot_idea_Data)basedata;

        hot_idea_img=new ArrayList<>();
        hot_idea_img.addAll(hot_idea_data.getHot_idea_img());
        hot_idea_title=new ArrayList<>();
        hot_idea_title.addAll(hot_idea_data.getHot_idea_text());
        hot_idea_provider=new ArrayList<>();
        hot_idea_provider.addAll(hot_idea_data.getHot_idea_provider());
        hot_idea_interestnum=new ArrayList<>();
        hot_idea_interestnum.addAll(hot_idea_data.getHot_idea_interestnum());

        GridView gridview = (GridView) mview.findViewById(R.id.hot_idea_gridview);
        ArrayList<HashMap<String, Object>> gridlist = new ArrayList<>();
        // 使用HashMap将图片添加到一个数组中，注意一定要是HashMap<String,Object>类型的，因为装到map中的图片要是资源ID，而不是图片本身
        // 如果是用findViewById(R.drawable.image)这样把真正的图片取出来了，放到map中是无法正常显示的

        for (int i = 0; i < hot_idea_img.size(); i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
//            map.put("iii","赵镜博");
//            Log.e("sss",imgs[0].length+"");
            map.put("image", hot_idea_img.get(i));
            map.put("text", hot_idea_title.get(i));
            map.put("provider", hot_idea_provider.get(i));
            map.put("interestNum", hot_idea_interestnum.get(i));
            gridlist.add(map);

        }
        // 使用simpleAdapter封装数据，将图片显示出来
        // 参数一是当前上下文Context对象
        // 参数二是图片数据列表，要显示数据都在其中
        // 参数三是界面的XML文件，注意，不是整体界面，而是要显示在GridView中的单个Item的界面XML
        // 参数四是动态数组中与map中图片对应的项，也就是map中存储进去的相对应于图片value的key
        // 参数五是单个Item界面XML中的图片ID
        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), gridlist,
                R.layout.hot_idea_item, new String[] { "image", "text" ,"provider","interestNum"}, new int[] {
                R.id.hot_idea_img, R.id.hot_idea_title,R.id.hot_idea_provider,R.id.hot_idea_interestnum });
        // 设置GridView的适配器为新建的simpleAdapter
        gridview.setAdapter(simpleAdapter);
    }
}
