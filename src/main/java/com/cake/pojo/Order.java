package com.cake.pojo;
/**
 * 订单信息实体类
 */

import java.util.Date;

public class Order {
    private Integer id;

    private Integer total;//总价

    private Integer amount;//商品总数

    private Integer status;//订单状态(1未付款/2已付款/3已发货/4已完成)

    private Integer paytype;//支付方式 (1微信/2支付宝/3货到付款)

    private String name;//收货人

    private String phone;//收货电话'

    private String address;//收获地址

    private Date systime;//下单时间

    private Integer userId;//下单用户

    private String orderNo;//订单号



    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Order(Integer id, Integer total, Integer amount, Integer status, Integer paytype, String name, String phone, String address, Date systime, Integer userId, String orderNo) {
            this.id = id;
            this.total = total;
            this.amount = amount;
            this.status = status;
            this.paytype = paytype;
            this.name = name;
            this.phone = phone;
            this.address = address;
            this.systime = systime;
            this.userId = userId;
            this.orderNo = orderNo;

        }

    public Order() {
            super();
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getPaytype() {
            return paytype;
        }

        public void setPaytype(Integer paytype) {
            this.paytype = paytype;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name == null ? null : name.trim();
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone == null ? null : phone.trim();
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address == null ? null : address.trim();
        }

        public Date getSystime() {
            return systime;
        }

        public void setSystime(Date systime) {
            this.systime = systime;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "id=" + id +
                    ", total=" + total +
                    ", amount=" + amount +
                    ", status=" + status +
                    ", paytype=" + paytype +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' +
                    ", systime=" + systime +
                    ", userId=" + userId +
                    '}';
        }
    }