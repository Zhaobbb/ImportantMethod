package com.example.joker.importantmethod.Cards;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.joker.importantmethod.Data.BaseData;
import com.example.joker.importantmethod.Data.MethodData;
import com.example.joker.importantmethod.R;

/**
 * Created by joker on 2017/4/14.
 */

public class MethodCard extends BaseCard {
    public MethodCard(@NonNull Context context) {
        super(context);
    }

    public MethodCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MethodCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MethodCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getCardView() {
        return R.layout.methodcard;
    }

    @Override
    protected void Viewcreate() {
        mview.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
    }

    @Override
    public void BindData(BaseData basedata) {
        if(basedata==null){
            return;
        }
        MethodData methodData=(MethodData)basedata;

        TextView method_title= (TextView) mview.findViewById(R.id.methodcard_title);
        TextView method_sawnum= (TextView) mview.findViewById(R.id.method_card_sawnum);
        TextView method_likenum= (TextView) mview.findViewById(R.id.method_card_likenum);
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.methodcard,null);

        mview.setBackgroundResource(methodData.getMethodcard_background());
        method_title.setText(methodData.getMethodcard_title());
        method_sawnum.setText(methodData.getMethodcard_sawnum()+"");
        method_likenum.setText(methodData.getMethodcard_likenum()+"");
    }
}
