package com.cake.uilt;

public enum PayType {
    //支付宝,微信,货到付款
    ORDER_ALIPY("支付宝"), ORDER_WECHAT("微信支付"),ORDER_ARRIVED("货到付款");

    private String key;
    private PayType(String key) {
        this.key=key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
