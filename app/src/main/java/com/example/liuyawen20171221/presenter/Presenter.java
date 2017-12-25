package com.example.liuyawen20171221.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.liuyawen20171221.bean.goodBean;
import com.example.liuyawen20171221.bean.goodsBean;
import com.example.liuyawen20171221.bean.listBean;
import com.example.liuyawen20171221.model.HttpUtils;
import com.example.liuyawen20171221.net.CallBack;
import com.example.liuyawen20171221.view.IView.iView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class Presenter {
    private Context context;
    private iView iv;
    private List<goodBean> list=new ArrayList<>();
    private List<List<goodsBean>> lists=new ArrayList<>();
    public Presenter(Context context, iView iv) {
        this.context=context;
        this.iv=iv;
    }
    public void get(){
        Map<String, String> map = new HashMap<>();
        map.put("uid","100");
        HttpUtils.getInstance().get("http://120.27.23.105/product/getCarts", map, new CallBack() {
            @Override
            public void onSuccess(Object o) {
                listBean bean = (listBean) o;
                List<listBean.DataBean> data = bean.getData();
                for (int i = 0; i < data.size(); i++) {
                    list.add(new goodBean(data.get(i).getSellerName(),false));
                    List<listBean.DataBean.ListBean> beanList = data.get(i).getList();
                    List<goodsBean> ls=new ArrayList<>();
                    for (int j = 0; j < beanList.size(); j++) {
                        String images = beanList.get(j).getImages();
                        String[] split = images.split("!");
                        ls.add(new goodsBean(beanList.get(j).getPrice(),beanList.get(j).getTitle(),split[0],1,false,false));
                    }
                    lists.add(ls);
                }
                iv.success(list,lists);
            }
            @Override
            public void onFailed(Exception e) {
                Toast.makeText(context,e.getMessage()+"",Toast.LENGTH_SHORT).show();
            }
        },listBean.class);
    }
}
