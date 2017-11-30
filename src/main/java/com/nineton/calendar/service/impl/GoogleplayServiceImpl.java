package com.nineton.calendar.service.impl;

import com.google.api.services.androidpublisher.model.ProductPurchase;
import com.nineton.calendar.mapper.GoogleplayMapper;
import com.nineton.calendar.pojo.*;
import com.nineton.calendar.service.*;
import com.nineton.calendar.utils.CheckGoogPlayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoogleplayServiceImpl implements GoogleplayService {
    @Autowired
    private RechargeOrderService rechargeOrderService;
    @Autowired
    private UserService userService;
    @Autowired
    private RechargeService rechargeService;
    @Autowired
    private P12Service p12Service;
    @Autowired
    private GoogleplayMapper googleplayMapper;

    @Override
    public String checkPay(GoogleplayExt googleplayExt) {

        if (googleplayExt.getToken() == null) {
            return "param";
        }
        if (googleplayExt.getOrderId() != null) {
            RechargeOrder rechargeOrder = rechargeOrderService.selectByPrimaryKey(googleplayExt.getOrderId());
            if (rechargeOrder.getStatus() == 1) {
                return "fault";
            }
        } else {
            GoogleplayExample example=new GoogleplayExample();
            GoogleplayExample.Criteria criteria = example.createCriteria();
            criteria.andTokenEqualTo(googleplayExt.getToken());
            List<Googleplay> googles = googleplayMapper.selectByExample(example);
            if (googles != null && googles.size() != 0) {
                for (Googleplay googleplay : googles) {
                    RechargeOrder rechargeOrder = rechargeOrderService.selectByPrimaryKey(googleplay.getOrderId());
                    if (rechargeOrder.getStatus() == 1) {
                        return "fault";
                    }
                }
            }
        }

        User user = userService.selectByPrimaryKey(googleplayExt.getIdentificationCode());
        Recharge recharge = rechargeService.selectByPrimaryKey((googleplayExt.getRechargeId()));
        P12 p12 = p12Service.findByPackageName(googleplayExt.getPackageName());

        if (user == null || recharge == null || p12 == null) {
            return "param";
        }

        RechargeOrder rechargeOrder = new RechargeOrder();
        if (googleplayExt.getOrderId() != null) {
            rechargeOrder = rechargeOrderService.selectByPrimaryKey(googleplayExt.getOrderId());
        } else {
            List<RechargeOrder> list=rechargeOrderService.selectByUR(googleplayExt);
            if (list != null && list.size() != 0) {
                rechargeOrder = list.get(0);
            }
        }

        // 插入一条googplay信息
        Googleplay googleplay = new Googleplay();
        googleplay.setOrderId(rechargeOrder.getOrderid());
        googleplay.setPackageName(googleplayExt.getPackageName());
        googleplay.setProductId(googleplayExt.getProductId());
        googleplay.setToken(googleplayExt.getToken());
        googleplayMapper.insert(googleplay);


        ProductPurchase purchase = CheckGoogPlayUtils.checkPayOrder(googleplay, p12);
        if (purchase != null) {
            if (purchase.getPurchaseState() == 0) {
                rechargeOrder.setStatus(1);
                rechargeOrderService.updateByPrimaryKey(rechargeOrder);
                user.setConsumeMoney(user.getConsumeMoney() + recharge.getPrice());
                user.setHaveCoin(user.getHaveCoin() + recharge.getCoin());
                userService.update(user);
                return "success";
            } else {
                // payOrder.setCreateTime(new Date());
                rechargeOrder.setStatus(0);
                rechargeOrderService.updateByPrimaryKey(rechargeOrder);
                return "fail";
            }
        }
        return null;
    }

}
