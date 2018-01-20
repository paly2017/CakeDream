package com.cake.pojo;

public class Top {
    private Integer id;

    private Byte type;

    private Integer goodId;

    public Top(Integer id, Byte type, Integer goodId) {
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}