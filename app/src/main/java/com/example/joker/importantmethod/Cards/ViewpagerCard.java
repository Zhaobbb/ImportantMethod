package com.example.joker.importantmethod.Cards;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.joker.importantmethod.Data.BaseData;
import com.example.joker.importantmethod.Data.ViewpagerData;
import com.example.joker.importantmethod.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * Created by joker on 2017/4/12.
 */

public class ViewpagerCard extends BaseCard {
    private RollPagerView rollpagerview;

    public ViewpagerCard(@NonNull Context context) {
        super(context);
    }

    public ViewpagerCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewpagerCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewpagerCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getCardView() {
        return R.layout.viewpagerfragment;
    }

    @Override
    protected void Viewcreate() {
        rollpagerview= (RollPagerView) mview.findViewById(R.id.main_rollpagerView);
        rollpagerview.setPlayDelay(2000);
        rollpagerview.setAnimationDurtion(500);
        rollpagerview.setHintView(new ColorPointHintView(getContext(),getResources().getColor(R.color.colorAccent), Color.WHITE));
        rollpagerview.setAdapter(new RollpagerAdapter());
    }

    private int images[][];


    private class RollpagerAdapter extends StaticPagerAdapter {

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView imgview=new ImageView(container.getContext());
            //设置图片资源
            imgview.setImageResource(images[0][position]);
            imgview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imgview.setScaleType(ImageView.ScaleType.CENTER);


            return imgview;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


    @Override
    public void BindData(BaseData basedata) {
        if(basedata==null){
            return;
        }
        ViewpagerData viewpagerData=(ViewpagerData)basedata;
        images= new int[][]{viewpagerData.getImgs()};

    }
}
