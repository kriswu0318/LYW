package com.example.liuyawen20171221.presenter;

import com.example.liuyawen20171221.bean.ShowBean;
import com.example.liuyawen20171221.model.ShowModel;
import com.example.liuyawen20171221.model.imodel.IShowModel;
import com.example.liuyawen20171221.net.OnNetListener;
import com.example.liuyawen20171221.view.IView.IShowView;

import java.util.List;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class ShowPresenter {
    IShowModel iShowModel;
    IShowView iShowView;

    public ShowPresenter(IShowView iShowView) {
        this.iShowView = iShowView;
        iShowModel=new ShowModel();
    }
    public void getShow(){
        iShowModel.doGet(new OnNetListener<ShowBean>() {
            @Override
            public void OnSuccess(ShowBean showBean) {

                iShowView.show(showBean);
            }

            @Override
            public void OnError(Exception e) {

            }
        });
    }
}
