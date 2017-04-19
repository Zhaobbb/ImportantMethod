package com.example.joker.importantmethod.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.joker.importantmethod.Cards.BaseCard;
import com.example.joker.importantmethod.Cards.Community_FirstCard;
import com.example.joker.importantmethod.Cards.Community_SecondCard;
import com.example.joker.importantmethod.Cards.ContentCard;
import com.example.joker.importantmethod.Cards.GridViewCard;
import com.example.joker.importantmethod.Cards.Hot_Idea_GridViewCard;
import com.example.joker.importantmethod.Cards.LessonCard;
import com.example.joker.importantmethod.Cards.MethodCard;
import com.example.joker.importantmethod.Cards.NoDataCard;
import com.example.joker.importantmethod.Cards.ViewpagerCard;
import com.example.joker.importantmethod.Data.BaseData;
import com.example.joker.importantmethod.Data.Community_firstData;
import com.example.joker.importantmethod.Data.Community_secondData;
import com.example.joker.importantmethod.Data.ContentData;
import com.example.joker.importantmethod.Data.GridViewData;
import com.example.joker.importantmethod.Data.Hot_idea_Data;
import com.example.joker.importantmethod.Data.LessonData;
import com.example.joker.importantmethod.Data.MethodData;
import com.example.joker.importantmethod.Data.NoData;
import com.example.joker.importantmethod.Data.ViewpagerData;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/12.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<BaseData> list;
    private Context mcontext;

    public RecyclerViewAdapter(ArrayList<BaseData> list, Context mcontext) {
        this.list = list;
        this.mcontext = mcontext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType==ContentData.class.getCanonicalName().hashCode()){
            view=new ContentCard(mcontext);
        }
        else if(viewType==MethodData.class.getCanonicalName().hashCode()){
            view = new MethodCard(mcontext);
        }
        else if(viewType==Community_firstData.class.getCanonicalName().hashCode()){
            view = new Community_FirstCard(mcontext);
        }

        else if(viewType==Community_secondData.class.getCanonicalName().hashCode()){
            view = new Community_SecondCard(mcontext);
        }
        else if(viewType==LessonData.class.getCanonicalName().hashCode()){
            view = new LessonCard(mcontext);
        }
        else if(viewType==ViewpagerData.class.getCanonicalName().hashCode()){
            view = new ViewpagerCard(mcontext);
        }
        else if(viewType==Hot_idea_Data.class.getCanonicalName().hashCode()){
            view = new Hot_Idea_GridViewCard(mcontext);
        }
        else if(viewType==GridViewData.class.getCanonicalName().hashCode()){
            view=new GridViewCard(mcontext);
        }

        else if(viewType==NoData.class.getCanonicalName().hashCode()){
            view = new NoDataCard(mcontext);
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ((BaseCard)holder.itemView).BindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        int viewtype=-1;
        if(list.get(position)!=null){
            if(list.get(position)instanceof ContentData){
                viewtype=ContentData.class.getCanonicalName().hashCode();

            }
            else if(list.get(position)instanceof MethodData){
                viewtype=MethodData.class.getCanonicalName().hashCode();

            }
            else if(list.get(position)instanceof Community_firstData){
                viewtype=Community_firstData.class.getCanonicalName().hashCode();

            }
            else if(list.get(position)instanceof Community_secondData){
                viewtype=Community_secondData.class.getCanonicalName().hashCode();

            }
            else if(list.get(position)instanceof LessonData){
                viewtype=LessonData.class.getCanonicalName().hashCode();

            }
            else if(list.get(position)instanceof GridViewData){
                viewtype=GridViewData.class.getCanonicalName().hashCode();

            }
            else if(list.get(position)instanceof Hot_idea_Data){
                viewtype=Hot_idea_Data.class.getCanonicalName().hashCode();

            }
            else if(list.get(position)instanceof ViewpagerData){
                viewtype=ViewpagerData.class.getCanonicalName().hashCode();
            }
            else if(list.get(position) instanceof NoData){
                viewtype=NoData.class.getCanonicalName().hashCode();
            }
        }
        return viewtype;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }





}
