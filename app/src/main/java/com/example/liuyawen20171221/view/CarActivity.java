package com.example.liuyawen20171221.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuyawen20171221.R;
import com.example.liuyawen20171221.adapter.ExpandableAdapter;
import com.example.liuyawen20171221.bean.goodBean;
import com.example.liuyawen20171221.bean.goodsBean;
import com.example.liuyawen20171221.presenter.Presenter;
import com.example.liuyawen20171221.view.IView.iView;

import java.util.List;

import butterknife.BindView;

public class CarActivity extends AppCompatActivity implements iView {
    private ExpandableListView exListView;
    public CheckBox allCheckbox;
    private TextView totalPrice;
    private TextView totalnumber;
    private TextView edit;
    @BindView(R.id.back)
    ImageView imageView;
    private ExpandableAdapter expandableAdapter;
    private boolean flagedit=true;//自己定义的一个值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        //初始化控件
        initView();
        Presenter presenter = new Presenter(this, this);
        presenter.get();
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(CarActivity.this, CarActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }
    //初始化控件
    private void initView() {
        exListView = (ExpandableListView) findViewById(R.id.exListView);
        allCheckbox = (CheckBox)findViewById(R.id.all_chekbox);
        totalPrice = (TextView)findViewById(R.id.total_price);
        totalnumber = (TextView)findViewById(R.id.total_number);
        edit = (TextView) findViewById(R.id.edit);
    }

    @Override
    public void success(List<goodBean> list, List<List<goodsBean>> lists) {
        //获取二级列表适配器
        expandableAdapter = new ExpandableAdapter(CarActivity.this, list, lists);
        exListView.setAdapter(expandableAdapter);
        initDate(list,lists);
        for(int i = 0; i < expandableAdapter.getGroupCount(); i++){
            exListView.expandGroup(i);
        }
        expandableAdapter.notifyDataSetChanged();
    }

    private void initDate(final List<goodBean> list, final List<List<goodsBean>> lists) {
        //父级点击事件
        exListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
        //全选监听
        allCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = allCheckbox.isChecked();
                //改变一级item复选框
                for (goodBean i:list) {
                    i.setGroupCb(checked);
                }
                //改变二级item复选框
                for (List<goodsBean> i1:lists) {
                    for(int r=0;r<i1.size();r++) {
                        i1.get(r).setChildCb(checked);
                    }
                }
                expandableAdapter.notifyDataSetChanged();
                changesum(lists);
            }
        });
        //点击编辑事件
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (List<goodsBean> i1:lists){
                    for(int r=0;r<i1.size();r++) {
                        i1.get(r).setBtn(flagedit);
                    }
                }
                flagedit=!flagedit;
                expandableAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void failed(Exception e) {
    }
    //计算和数量总价
    public void changesum(List<List<goodsBean>> lists){
        int count=0;
        double sum=0;
        for (List<goodsBean>i1:lists){
            for(int r=0;r<i1.size();r++) {
                boolean childCb1 = i1.get(r).isChildCb();
                if(childCb1){
                    double price = i1.get(r).getPrice();
                    int num = i1.get(r).getNum();
                    sum+=price*num;
                    count++;
                }
            }
        }
        totalPrice.setText("￥"+sum);
        totalnumber.setText("共有商品:"+count+"件");
    }
}
