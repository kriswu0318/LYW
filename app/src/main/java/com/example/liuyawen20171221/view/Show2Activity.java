package com.example.liuyawen20171221.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuyawen20171221.R;
import com.example.liuyawen20171221.bean.XQBean;
import com.example.liuyawen20171221.presenter.XQPresnter;
import com.example.liuyawen20171221.view.IView.IXQView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Show2Activity extends AppCompatActivity implements IXQView{
    @BindView(R.id.iv_2)
    ImageView imageView;
    TextView t,t1;
    SimpleDraweeView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show2);
        ButterKnife.bind(this);


//         t= (TextView) findViewById(R.id.tv);
//        t1= (TextView) findViewById(R.id.price);
//        i= (SimpleDraweeView) findViewById(R.id.iv);
//
//        XQPresnter x=new XQPresnter(this);
//        x.XQ();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Show2Activity.this,"加购成功",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Show2Activity.this, CarActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void show(XQBean xqBean) {
//        t1.setText(xqBean.getData().getPrice()+"");
//        t.setText(xqBean.getData().getTitle());
//        i.setImageURI(xqBean.getData().getImages());
    }
}
