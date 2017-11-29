package com.nineton.calendar.pojo;

import java.util.Date;

public class PageUtils {
    private Integer start;
    private Integer limit;
    private Date date;
    private User user;
    private Recharge recharge;
    private RechargeOrder rechargeOrder;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recharge getRecharge() {
        return recharge;
    }

    public void setRecharge(Recharge recharge) {
        this.recharge = recharge;
    }

    public RechargeOrder getRechargeOrder() {
        return rechargeOrder;
    }

    public void setRechargeOrder(RechargeOrder rechargeOrder) {
        this.rechargeOrder = rechargeOrder;
    }
}
