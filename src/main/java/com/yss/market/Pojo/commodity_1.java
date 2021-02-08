package com.yss.market.Pojo;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class commodity_1 {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer sales;
    private Integer stock;
    ///给图片一个默认地址
    private  String img_path="static/img/bg1.jpg";

    public commodity_1() {
    }

    public commodity_1(Integer id, String name, BigDecimal price, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.img_path = img_path;
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
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "commodity_1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
