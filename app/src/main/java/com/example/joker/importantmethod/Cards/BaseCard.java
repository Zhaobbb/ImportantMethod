package com.example.joker.importantmethod.Cards;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.joker.importantmethod.Data.BaseData;

/**
 * Created by joker on 2017/4/12.
 */

public abstract class BaseCard extends FrameLayout{
    protected View mview;
    private Context mcontext;


    public BaseCard(@NonNull Context context) {
        super(context);
        init(context);
    }



    public BaseCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public BaseCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mview=inflate(context,getCardView(),this);
//        mcontext=context;
        Viewcreate();
    }
    //返回子View的布局
    protected abstract int getCardView();
    //对子View的功能构建
    protected abstract void Viewcreate();
    //绑定数据
    public abstract void BindData(BaseData basedata);
}
