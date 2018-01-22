package com.cake.pojo;

public class Top {
    private Integer id;

    private Integer type;

    private Integer goodId;

    //首页展示需要商品，还有商品类型，需要两个表--tops和types,点故意两个属性,引入两个类
    //商品
    private Good good;
    //商品类型
    private Type goodType;


    public Top(Integer id, Integer type, Integer goodId) {
        this.id = id;

        this.type = type;
        this.goodId = goodId;
    }

    public Top() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
    //good---goodType的setter/getter
    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Type getGoodType() {
        return goodType;
    }

    public void setGoodType(Type goodType) {
        this.goodType = goodType;
    }
    //结束
}