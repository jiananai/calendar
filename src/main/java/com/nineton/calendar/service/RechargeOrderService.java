package com.nineton.calendar.service;

import com.nineton.calendar.pojo.GoogleplayExt;
import com.nineton.calendar.pojo.PageResult;
import com.nineton.calendar.pojo.RechargeOrder;

import java.util.List;

public interface RechargeOrderService {
    RechargeOrder insertOrder(RechargeOrder order);

    RechargeOrder selectByPrimaryKey(String orderId);

    List<RechargeOrder> selectByUR(GoogleplayExt googleplayExt);

    void updateByPrimaryKey(RechargeOrder rechargeOrder);

    PageResult findAllOrder(Integer page, Integer limit, RechargeOrder rechargeOrder);
}
