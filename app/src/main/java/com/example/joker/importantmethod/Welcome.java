package com.example.joker.importantmethod;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

public class Welcome extends Activity {

    private SharedPreferences sp;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==100){
//                sp=getSharedPreferences("newsNAME", Context.MODE_APPEND+Context.MODE_PRIVATE);
//
//
//                String is=sp.getString("isfirst","1");

                Intent intent = new Intent();

                intent.setClass(Welcome.this,MainActivity.class);

                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);


            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        handler.sendEmptyMessageDelayed(100,3000);
    }
}
