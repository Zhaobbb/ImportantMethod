package com.example.joker.importantmethod.Fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.joker.importantmethod.R;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/13.
 */

public class MainPage_Fragment extends Fragment {
    private View view;
    private RadioGroup main_rg;
    private FragmentManager fm;
    private ImageView main_firstpage_imgbtn_write;
    private RadioButton[] rbarr;
    private int num=0;
    private ArrayList<BaseFragment> flist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.mainpage_fragment,null);
        init();
        return view;
    }

    private void init() {
        main_firstpage_imgbtn_write= (ImageView) view.findViewById(R.id.main_firstpage_imgbtn_write);

        fm=getActivity().getSupportFragmentManager();
        main_rg= (RadioGroup) view.findViewById(R.id.radiogroup_miaozhao);
        flist=new ArrayList<>();
        rbarr=new RadioButton[main_rg.getChildCount()];
        for(int i=0;i<main_rg.getChildCount();i++){
            rbarr[i]= (RadioButton) main_rg.getChildAt(i);
        }

        flist.add(new FirstFragment());
        flist.add(new SecondFragment());

        rbarr[0].setChecked(true);
        fm.beginTransaction().add(R.id.mainpage_fragment_framelayout, flist.get(0)).commit();

        main_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.miaozhao:
                        showfragment(i);
                        main_firstpage_imgbtn_write.setVisibility(View.VISIBLE);
                        break;
                    case R.id.gonglue:
                        main_firstpage_imgbtn_write.setVisibility(View.INVISIBLE);
                        showfragment(i);
                        break;
                }
            }
        });

    }

    private void showfragment(int i) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        for (int i1 = 0; i1 < main_rg.getChildCount(); i1++) {
            if (i == rbarr[i1].getId()) {
                if (flist.get(i1).isAdded()) {
                    fragmentTransaction.show(flist.get(i1)).hide(flist.get(num)).commit();
                } else {
                    fragmentTransaction.add(R.id.mainpage_fragment_framelayout, flist.get(i1)).hide(flist.get(num)).commit();
                }
                num = i1;
            }
        }
    }
}
