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
import com.example.joker.importantmethod.Data.Community_secondData;
import com.example.joker.importantmethod.R;

/**
 * Created by joker on 2017/4/14.
 */

public class Community_SecondCard extends BaseCard {
    public Community_SecondCard(@NonNull Context context) {
        super(context);
    }

    public Community_SecondCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Community_SecondCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Community_SecondCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getCardView() {
        return R.layout.community_card_huodong;
    }

    private ImageView community_second_img;
    private TextView community_second_title;
    private TextView community_second_date;
    private TextView community_second_address;
    private TextView community_second_price;
    private TextView community_second_taker;
    @Override
    protected void Viewcreate() {
         community_second_img= (ImageView) mview.findViewById(R.id.huodongcard_img);
        community_second_title= (TextView) mview.findViewById(R.id.huodongcard_title);
         community_second_date= (TextView) mview.findViewById(R.id.huodongcard_date);
         community_second_address= (TextView) mview.findViewById(R.id.huodongcard_address);
         community_second_price= (TextView) mview.findViewById(R.id.huodongcard_price);
        community_second_taker= (TextView) mview.findViewById(R.id.huodongcard_taker);
    }

    @Override
    public void BindData(BaseData basedata) {
        if(basedata==null){
            return;
        }
        Community_secondData community_secondData=(Community_secondData)basedata;

        community_second_img.setImageResource(community_secondData.getCommunity_second_img());
        community_second_title.setText(community_secondData.getCommunity_second_title());
        community_second_date.setText(community_secondData.getCommunity_second_date());
        community_second_address.setText(community_secondData.getCommunity_second_address());
        community_second_price.setText(community_secondData.getCommunity_second_price());
        community_second_taker.setText(community_secondData.getCommunity_second_taker()+"");
    }
}
