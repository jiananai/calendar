package com.nineton.calendar.pojo;

public class RechargeOrderExt extends RechargeOrder {
    private Integer coin;
    private Double price;

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
