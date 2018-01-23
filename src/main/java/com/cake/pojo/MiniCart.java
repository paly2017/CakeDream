package com.cake.pojo;

/***
 * 购物车图标实体类
 */
public class MiniCart {
    //商品
    private Good good;
    //商品数量
    private Integer count;

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
