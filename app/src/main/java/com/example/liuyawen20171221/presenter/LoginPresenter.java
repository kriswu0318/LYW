package com.example.liuyawen20171221.presenter;

import com.example.liuyawen20171221.bean.LoginBean;
import com.example.liuyawen20171221.model.LoginModel;
import com.example.liuyawen20171221.model.imodel.ModelCallBack;
import com.example.liuyawen20171221.view.MyView;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class LoginPresenter {
    LoginModel loginModel = new LoginModel();
    MyView.LoginView loginView;
    public LoginPresenter(MyView.LoginView loginView) {
        this.loginView = loginView;
    }

    public void getData(String tel, String pwd) {
        loginModel.getLoginData(tel,pwd, new ModelCallBack.LoginCallBack() {
            @Override
            public void success(LoginBean dengluBean) {
                loginView.success(dengluBean);
                System.out.println("登录p数据："+dengluBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("登录p错误："+code);
            }
        });
    }
}
