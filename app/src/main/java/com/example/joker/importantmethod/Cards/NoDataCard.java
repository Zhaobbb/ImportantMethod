package com.example.joker.importantmethod.Cards;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joker.importantmethod.Data.BaseData;
import com.example.joker.importantmethod.Data.NoData;
import com.example.joker.importantmethod.R;

/**
 * Created by joker on 2017/4/12.
 */

public class NoDataCard extends BaseCard {
    private TextView textView;
    public NoDataCard(@NonNull Context context) {
        super(context);
    }

    public NoDataCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NoDataCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NoDataCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getCardView() {
        return R.layout.nodatacard;
    }

    @Override
    protected void Viewcreate() {
        textView= (TextView) mview.findViewById(R.id.nodata_tv);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"nodata被点击了",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void BindData(BaseData basedata) {
        if(basedata==null){
            return;
        }
        NoData noData=(NoData)basedata;
        textView.setText(noData.getNodata());
    }
}
