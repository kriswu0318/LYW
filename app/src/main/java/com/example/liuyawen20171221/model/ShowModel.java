package com.example.liuyawen20171221.model;

import com.example.liuyawen20171221.bean.ShowBean;
import com.example.liuyawen20171221.model.imodel.IShowModel;
import com.example.liuyawen20171221.net.OnNetListener;
import com.example.liuyawen20171221.net.RetrofitHelper;
import com.example.liuyawen20171221.utils.ServApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class ShowModel implements IShowModel{

    @Override
    public void doGet(final OnNetListener<ShowBean> onNetListener) {
        ServApi servApi= RetrofitHelper.getServApi();
        Call<ShowBean> beanCall=servApi.getShowBean();
        beanCall.enqueue(new Callback<ShowBean>() {
            @Override
            public void onResponse(Call<ShowBean> call, Response<ShowBean> response) {
                    onNetListener.OnSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ShowBean> call, Throwable t) {
                    onNetListener.OnError((Exception) t);
            }
        });
    }
}
