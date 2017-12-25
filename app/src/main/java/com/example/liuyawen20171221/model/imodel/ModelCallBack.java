package com.example.liuyawen20171221.model.imodel;

import com.example.liuyawen20171221.bean.LoginBean;
import com.example.liuyawen20171221.bean.RegBean;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public interface ModelCallBack {
    public interface LoginCallBack{
        //登录时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(LoginBean loginBean);
        //登录时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface RegCallBack {
        //注册时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(RegBean regBean);
        //注册时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }


}
