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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.joker.importantmethod.R;

import java.util.ArrayList;

/**
 * Created by joker on 2017/4/14.
 */

public class Community_Fragment extends Fragment {
    private View view;
    private RadioGroup community_radiogroup_miaozhao;
    private FragmentManager fm;

    private RadioButton[] rbarr;
    private int num=0;
    private ArrayList<BaseFragment> cflist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.community_fragment,null);
        init();
        return view;
    }

    private void init() {


        fm=getActivity().getSupportFragmentManager();
        community_radiogroup_miaozhao= (RadioGroup) view.findViewById(R.id.community_radiogroup_miaozhao);
        cflist=new ArrayList<>();
        rbarr=new RadioButton[community_radiogroup_miaozhao.getChildCount()];
        for(int i=0;i<community_radiogroup_miaozhao.getChildCount();i++){
            rbarr[i]= (RadioButton) community_radiogroup_miaozhao.getChildAt(i);
        }

        cflist.add(new Community_First());
        cflist.add(new Community_Second());

        rbarr[0].setChecked(true);
        fm.beginTransaction().add(R.id.community_fragment_framelayout, cflist.get(0)).commit();

        community_radiogroup_miaozhao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.quanzi:
                        showfragment(i);

                        break;
                    case R.id.huodong:

                        showfragment(i);
                        break;
                }
            }
        });

    }

    private void showfragment(int i) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        for (int i1 = 0; i1 < community_radiogroup_miaozhao.getChildCount(); i1++) {
            if (i == rbarr[i1].getId()) {
                if (cflist.get(i1).isAdded()) {
                    fragmentTransaction.show(cflist.get(i1)).hide(cflist.get(num)).commit();
                } else {
                    fragmentTransaction.add(R.id.community_fragment_framelayout, cflist.get(i1)).hide(cflist.get(num)).commit();
                }
                num = i1;
            }
        }
    }
}
