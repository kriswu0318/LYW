package com.example.liuyawen20171221.view.IView;

import com.example.liuyawen20171221.bean.goodBean;
import com.example.liuyawen20171221.bean.goodsBean;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public interface iView {
    void success(List<goodBean> list, List<List<goodsBean>> lists);
    void failed(Exception e);
}
