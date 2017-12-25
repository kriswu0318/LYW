package com.example.liuyawen20171221.bean;

/**
 * Created by 刘雅文 on 2017/12/21.
 */

public class goodBean {
    private String sellerName;
    private boolean groupCb;
    public goodBean(String sellerName, boolean groupCb) {
        this.sellerName = sellerName;
        this.groupCb = groupCb;
    }
    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public boolean isGroupCb() {
        return groupCb;
    }

    public void setGroupCb(boolean groupCb) {
        this.groupCb = groupCb;
    }

    @Override
    public String toString() {
        return "goodBean{" +
                "sellerName='" + sellerName + '\'' +
                ", groupCb=" + groupCb +
                '}';
    }
}
