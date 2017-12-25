package com.example.liuyawen20171221.model;

import com.example.liuyawen20171221.bean.ShowBean;
import com.example.liuyawen20171221.bean.XQBean;
import com.example.liuyawen20171221.model.imodel.IXQModel;
import com.example.liuyawen20171221.net.OnNetListener;
import com.example.liuyawen20171221.net.RetrofitHelper;
import com.example.liuyawen20171221.utils.ServApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class XQModel implements IXQModel{
    @Override
    public void doGet(final OnNetListener<XQBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<XQBean> beanCall=servApi.getXQBean();
        beanCall.enqueue(new Callback<XQBean>() {
            @Override
            public void onResponse(Call<XQBean> call, Response<XQBean> response) {
                onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<XQBean> call, Throwable t) {
                onNetListener.OnError((Exception) t);
            }
        });
    }
}
