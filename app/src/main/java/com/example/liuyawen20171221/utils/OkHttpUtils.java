package com.example.liuyawen20171221.utils;

import okhttp3.OkHttpClient;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class OkHttpUtils {
    public static OkHttpClient okHttpClient;
    public static OkHttpClient getOkHttpClient(){
        if (okHttpClient==null){
            synchronized (OkHttpClient.class){
                if (okHttpClient==null){
                    okHttpClient=new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
}
