package com.example.liuyawen20171221.presenter;

import com.example.liuyawen20171221.bean.RegBean;
import com.example.liuyawen20171221.model.RegModel;
import com.example.liuyawen20171221.model.imodel.ModelCallBack;
import com.example.liuyawen20171221.view.MyView;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class RegPresenter {
    RegModel regModel = new RegModel();
    MyView.RegView regView;
    public RegPresenter(MyView.RegView regView) {
        this.regView = regView;
    }

    public void getData(String tel, String pwd) {
        regModel.getRegData(tel,pwd, new ModelCallBack.RegCallBack() {

            @Override
            public void success(RegBean regBean) {
                regView.sucess(regBean);
                System.out.println("注册p数据："+regBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("注册p错误："+code);
            }
        });
    }
}
