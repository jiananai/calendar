package com.nineton.calendar.service;

import com.nineton.calendar.pojo.PageResult;
import com.nineton.calendar.pojo.Recharge;

import java.util.List;

public interface RechargeService {
    List<Recharge> getRechargeList(Recharge recharge);

    Recharge selectByPrimaryKey(Integer rechargeId);

    PageResult findAllRecharge(Integer page, Integer limit, Recharge recharge);

    void deleteRecharge(Integer id);

    void editRecharge(Recharge recharge);

    void insertRecharge(Recharge recharge);
}
