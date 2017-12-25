package com.example.liuyawen20171221.utils;

import com.example.liuyawen20171221.bean.LoginBean;
import com.example.liuyawen20171221.bean.RegBean;
import com.example.liuyawen20171221.bean.ShowBean;
import com.example.liuyawen20171221.bean.XQBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public interface ServApi {
    //注册的接口
    //https://www.zhaoapi.cn/user/reg?mobile=18631090582&password=888888
    @FormUrlEncoded
    @POST("/user/reg")
    Observable<RegBean> reg(@FieldMap Map<String,String> map);

    //登录的接口
    //https://www.zhaoapi.cn/user/login?mobile=18631090582&password=888888
    @FormUrlEncoded
    @POST("/user/login")
    Observable<LoginBean> login(@FieldMap Map<String,String> map);

    @GET(Api.SHOW)
    Call<ShowBean> getShowBean();
    @GET(Api.SHOW)
    Call<XQBean> getXQBean();
}
