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
import com.example.joker.importantmethod.Data.LessonData;
import com.example.joker.importantmethod.R;

/**
 * Created by joker on 2017/4/14.
 */

public class LessonCard extends BaseCard {
    public LessonCard(@NonNull Context context) {
        super(context);
    }

    public LessonCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LessonCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LessonCard(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getCardView() {
        return R.layout.lessoncard;
    }

    private ImageView lesson_img;
    private TextView lesson_title;
    private TextView lesson_date;
    private TextView lesson_price;
    private TextView lesson_provider;
    private TextView lesson_looker;
    @Override
    protected void Viewcreate() {
        lesson_img= (ImageView) mview.findViewById(R.id.lesson_img);
        lesson_title = (TextView) mview.findViewById(R.id.lesson_title);
        lesson_date = (TextView) mview.findViewById(R.id.lesson_date);
        lesson_price= (TextView) mview.findViewById(R.id.lesson_price);
        lesson_provider= (TextView) mview.findViewById(R.id.lesson_provider);
        lesson_looker= (TextView) mview.findViewById(R.id.lesson_looker);
    }

    @Override
    public void BindData(BaseData basedata) {
        if(basedata==null){
            return;
        }
        LessonData lessonData=(LessonData)basedata;

        lesson_img.setImageResource(lessonData.getLesson_img());
        lesson_title.setText(lessonData.getLesson_title());
        lesson_date.setText(lessonData.getLesson_date());
        lesson_price.setText(lessonData.getLesson_price());
        lesson_provider.setText(lessonData.getLesson_provider());
        lesson_looker.setText(lessonData.getLesson_looker()+"");
    }
}
