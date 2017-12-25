package com.example.liuyawen20171221;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liuyawen20171221.utils.SharedUtils;
import com.example.liuyawen20171221.view.LoginActivity;
import com.example.liuyawen20171221.view.RegActivity;
import com.example.liuyawen20171221.view.ShowActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn)
    public Button button;
    @BindView(R.id.reg)
    public Button reg;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                case 1:
                    Intent intent2 = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    break;

                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //调用工具类判断保存的布尔值
 //       boolean b = SharedUtils.getBooleanData(MainActivity.this, "flag", false);

//        if (b) {    //已经进入过，现在是第二次
//            handler.sendEmptyMessageDelayed(0, 0);
//        } else {        //现在是第一次
//            SharedUtils.savaBooleanData(MainActivity.this, "flag", true);
//            handler.sendEmptyMessageDelayed(1, 0);
//        }
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(MainActivity.this,LoginActivity.class);
//                startActivity(intent2);
//                finish();
//            }
//        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
