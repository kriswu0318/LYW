package com.example.liuyawen20171221.presenter;

import com.example.liuyawen20171221.bean.XQBean;
import com.example.liuyawen20171221.model.imodel.IXQModel;
import com.example.liuyawen20171221.net.OnNetListener;
import com.example.liuyawen20171221.view.IView.IXQView;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class XQPresnter {
    IXQModel ixqModel;
    IXQView ixqView;

    public XQPresnter(IXQView ixqView) {
        this.ixqView = ixqView;
    }
    public void XQ(){
        ixqModel.doGet(new OnNetListener<XQBean>() {
            @Override
            public void OnSuccess(XQBean xqBean) {
                ixqView.show(xqBean);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }
}
