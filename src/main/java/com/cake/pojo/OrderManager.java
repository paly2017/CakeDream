package com.cake.pojo;

public class OrderManager {
    private Good good;
    private Item item;
    private User user;
    private Order order;

    public OrderManager() {
    }

    public OrderManager(Good good, Item item, User user, Order order) {
        this.good = good;
        this.item = item;
        this.user = user;
        this.order = order;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
