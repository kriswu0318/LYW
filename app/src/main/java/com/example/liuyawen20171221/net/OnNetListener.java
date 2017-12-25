package com.example.liuyawen20171221.net;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public interface OnNetListener <T> {
     void OnSuccess(T t);
     void OnError(Exception e);


}
