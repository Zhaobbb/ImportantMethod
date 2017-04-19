package com.example.joker.importantmethod.Cards;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.joker.importantmethod.Data.BaseData;
import com.example.joker.importantmethod.Data.ContentData;
import com.example.joker.importantmethod.R;

/**
 * Created by joker on 2017/4/12.
 */

public class ContentCard extends BaseCard {
    private ImageView head_picture;
    private TextView super_describe;
    private TextView super_name;
    private Button button;
    public ContentCard(@NonNull Context context) {
        super(context);
    }

    public ContentCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ContentCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ContentCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getCardView() {
        return R.layout.superman;
    }

    @Override
    protected void Viewcreate() {
        mview.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        super_name= (TextView) mview.findViewById(R.id.superman_name);
        head_picture= (ImageView) mview.findViewById(R.id.head_picture);
        super_describe= (TextView) mview.findViewById(R.id.superman_describe);

    }

    @Override
    public void BindData(BaseData basedata) {
        if(basedata==null){
            return;
        }
        ContentData contentData=(ContentData)basedata;
        head_picture.setImageResource(contentData.getHead_img());
        super_describe.setText(contentData.getSuper_describe());
        super_name.setText(contentData.getSuper_name());
    }
}
