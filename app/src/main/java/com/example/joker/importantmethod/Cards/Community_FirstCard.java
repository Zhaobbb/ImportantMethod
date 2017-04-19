package com.example.joker.importantmethod.Cards;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joker.importantmethod.Data.BaseData;
import com.example.joker.importantmethod.Data.Community_firstData;
import com.example.joker.importantmethod.R;

/**
 * Created by joker on 2017/4/14.
 */

public class Community_FirstCard extends BaseCard {
    public Community_FirstCard(@NonNull Context context) {
        super(context);
    }

    public Community_FirstCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Community_FirstCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Community_FirstCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getCardView() {
        return R.layout.community_card;
    }

    private ImageView community_first_head;
    private TextView community_first_title;
    private TextView community_first_num;
    private TextView community_first_text;

    @Override
    protected void Viewcreate() {

        community_first_head= (ImageView) mview.findViewById(R.id.quanzi_head);
        community_first_title= (TextView) mview.findViewById(R.id.quanzi_title);
        community_first_num= (TextView) mview.findViewById(R.id.quanzi_num);
        community_first_text= (TextView) mview.findViewById(R.id.quanzi_describe);
    }

    @Override
    public void BindData(BaseData basedata) {
        if(basedata==null){
            return;
        }
        Community_firstData community_firstData=(Community_firstData)basedata;
        community_first_head.setImageResource(community_firstData.getCommunity_first_head());
        community_first_title.setText(community_firstData.getCommunity_first_title());
        community_first_num.setText(community_firstData.getCommunity_first_num()+"");
        community_first_text.setText(community_firstData.getCommunity_first_text());
    }
}
