package com.cake.pojo;

import java.util.List;

public class Good {
    private Integer id;

    private String name;

    private String cover;

    private String image1;

    private String image2;

    private Integer price;

    private String intro;

    private Integer stock;

    private Integer typeId;

   //根据商品id，查出它是什么推荐时用,一商品可以对应多个推荐类型，三个对应一个推荐类型
    //给每个商品增加三个属性，是否为条幅，是否为热销、是否为新品
    private boolean topScroll;
    private boolean topHotSale;
    private boolean topNewgood;

    private Type type;//根据用户type_id查询商品类型

    public Good(Integer id, String name, String cover, String image1, String image2, Integer price, String intro, Integer stock, Integer typeId) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.image1 = image1;
        this.image2 = image2;
        this.price = price;
        this.intro = intro;
        this.stock = stock;
        this.typeId = typeId;
    }

    public Good() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1 == null ? null : image1.trim();
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2 == null ? null : image2.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    public Type getType() {
        return type;
    }
    public boolean isTopScroll() {
        return topScroll;
    }

    public void setTopScroll(boolean topScroll) {
        this.topScroll = topScroll;
    }

    public boolean isTopHotSale() {
        return topHotSale;
    }

    public void setTopHotSale(boolean topHotSale) {
        this.topHotSale = topHotSale;
    }

    public boolean isTopNewgood() {
        return topNewgood;
    }

    public void setTopNewgood(boolean topNewgood) {
        this.topNewgood = topNewgood;
    }
    public void setType(Type type) {
        this.type = type;
    }

}