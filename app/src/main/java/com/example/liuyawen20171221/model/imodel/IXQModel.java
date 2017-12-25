package com.example.liuyawen20171221.model.imodel;

import com.example.liuyawen20171221.bean.XQBean;
import com.example.liuyawen20171221.net.OnNetListener;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public interface IXQModel {
    public void doGet(OnNetListener<XQBean> onNetListener);
}
