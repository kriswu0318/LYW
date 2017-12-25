package com.example.liuyawen20171221.net;

import com.example.liuyawen20171221.utils.Api;
import com.example.liuyawen20171221.utils.OkHttpUtils;
import com.example.liuyawen20171221.utils.ServApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    public static ServApi servApi;
    static {
        okHttpClient= OkHttpUtils.getOkHttpClient();
    }
    public static ServApi getServApi(){
        if (servApi==null){
            synchronized (ServApi.class){
                if (servApi==null){
                    servApi=creteApi(ServApi.class, Api.HOST);
                }
            }
        }
        return servApi;
    }
    public static <T> T creteApi(Class<T> tClass,String url){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
