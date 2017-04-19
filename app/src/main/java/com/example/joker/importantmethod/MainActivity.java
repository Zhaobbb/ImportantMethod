package com.example.joker.importantmethod;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.joker.importantmethod.Fragments.Community_Fragment;
import com.example.joker.importantmethod.Fragments.Lesson_Fragment;
import com.example.joker.importantmethod.Fragments.MainPage_Fragment;
import com.example.joker.importantmethod.Fragments.Mine_Fragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rg;

    private FragmentManager fm;
    private ArrayList<Fragment> mlist;
    private RadioButton[] rbarr;
    private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlist=new ArrayList<>();
        fm=getSupportFragmentManager();
        rg= (RadioGroup) findViewById(R.id.main_rg);
        rbarr=new RadioButton[rg.getChildCount()];
        for(int i=0;i<rg.getChildCount();i++){
            rbarr[i]= (RadioButton) rg.getChildAt(i);
        }



        rbarr[0].setChecked(true);

        mlist.add(new MainPage_Fragment());
        mlist.add(new Community_Fragment());
        mlist.add(new Lesson_Fragment());
        mlist.add(new Mine_Fragment());
            fm.beginTransaction().add(R.id.framlayout,mlist.get(0)).commit();

        rg.setOnCheckedChangeListener(this);
    }

    private void showfragment(int i) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        for (int i1 = 0; i1 < rg.getChildCount(); i1++) {
            if (i == rbarr[i1].getId()) {
                if (mlist.get(i1).isAdded()) {
                    fragmentTransaction.show(mlist.get(i1)).hide(mlist.get(num)).commit();
                } else {
                    fragmentTransaction.add(R.id.framlayout, mlist.get(i1)).hide(mlist.get(num)).commit();
                }
                num = i1;
            }
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            case R.id.main_rb1:
                showfragment(i);
                break;
            case R.id.main_rb2:
                showfragment(i);
                break;
            case R.id.main_rb3:
                showfragment(i);
                break;
            case R.id.main_rb4:
                showfragment(i);
                break;
        }
    }
}
