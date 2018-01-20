package com.cake.pojo;

public class Item {
    private Integer id;

    private Integer price;

    private Integer amount;

    private Integer orderId;

    private Integer goodId;

    public Item(Integer id, Integer price, Integer amount, Integer orderId, Integer goodId) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.orderId = orderId;
        this.goodId = goodId;
    }

    public Item() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}