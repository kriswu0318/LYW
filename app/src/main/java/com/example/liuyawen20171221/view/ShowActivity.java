package com.example.liuyawen20171221.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.liuyawen20171221.MainActivity;
import com.example.liuyawen20171221.R;
import com.example.liuyawen20171221.adapter.ShowAdapter;
import com.example.liuyawen20171221.bean.ShowBean;
import com.example.liuyawen20171221.presenter.ShowPresenter;
import com.example.liuyawen20171221.view.IView.IShowView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity implements IShowView{

    @BindView(R.id.rlv)
    public RecyclerView recyclerView;
    @BindView(R.id.bt)
    public Button button;
    ShowPresenter showPresenter;
    public ShowAdapter adapter;

    public  List<ShowBean.DataBean> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);



        GridLayoutManager manager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(manager);

        showPresenter=new ShowPresenter(this);
        showPresenter.getShow();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowActivity.this, Show2Activity.class);
                startActivity(intent);
              finish();
            }
        });

//        recyclerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ShowActivity.this, Show2Activity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

    @Override
    public void show(ShowBean showBean) {

        list=showBean.getData();

        Log.e("11111",list.toString());
      //  list.addAll(list);
        adapter=new ShowAdapter(this,list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new ShowAdapter.OnItemClickListener() {
    @Override
    public void onItemClieck(String str) {
        Intent intent=new Intent(ShowActivity.this,Show2Activity.class);
        intent.putExtra("pid",str);
        startActivity(intent);

    }
});
    }
}
