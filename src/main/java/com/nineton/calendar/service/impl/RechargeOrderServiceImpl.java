package com.nineton.calendar.service.impl;

import com.nineton.calendar.mapper.RechargeOrderMapper;
import com.nineton.calendar.pojo.*;
import com.nineton.calendar.service.*;
import com.nineton.calendar.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RechargeOrderServiceImpl implements RechargeOrderService{
    @Autowired
    private RechargeOrderMapper rechargeOrderMapper;
    @Autowired
    private UserService userService;;
    @Autowired
    private RechargeService rechargeService;
    @Autowired
    private GoogleplayService googleplaySrvice;

    @Autowired
    private P12Service p12Service;
    @Transactional
    @Override
    public RechargeOrder insertOrder(RechargeOrder order) {
        synchronized (RechargeOrderServiceImpl.class) {
            RechargeOrderExample example=new RechargeOrderExample();
            example.setOrderByClause("create_time desc");
            RechargeOrderExample.Criteria criteria = example.createCriteria();
            criteria.andIdentificationCodeEqualTo(order.getIdentificationCode());
            criteria.andRechargeIdEqualTo(order.getRechargeId());
            criteria.andStatusEqualTo(2);
            List<RechargeOrder> list = rechargeOrderMapper.selectByExample(example);
            if(list!=null&&list.size()!=0){
                RechargeOrder rechargeOrder=list.get(0);
                if(System.currentTimeMillis()-rechargeOrder.getCreateTime().getTime()<5*60*1000){
                    rechargeOrder.setCreateTime(new Date());
                    rechargeOrderMapper.updateByPrimaryKey(rechargeOrder);
                    return rechargeOrder;
                }
            }
        }
        order.setOrderid(IDUtils.genItemId()+"");
        order.setCreateTime(new Date());
        order.setStatus(2);
        rechargeOrderMapper.insert(order);
        return order;
    }
    @Transactional
    @Override
    public RechargeOrder selectByPrimaryKey(String orderId) {
        RechargeOrder rechargeOrder = rechargeOrderMapper.selectByPrimaryKey(orderId);
        return rechargeOrder;
    }
    @Transactional
    @Override
    public List<RechargeOrder> selectByUR(GoogleplayExt googleplayExt) {
        RechargeOrderExample example=new RechargeOrderExample();
        RechargeOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdentificationCodeEqualTo(googleplayExt.getIdentificationCode());
        criteria.andRechargeIdEqualTo(googleplayExt.getRechargeId());
        criteria.andStatusNotEqualTo(1);
        List<RechargeOrder> list = rechargeOrderMapper.selectByExample(example);
        return list;
    }
    @Transactional
    @Override
    public void updateByPrimaryKey(RechargeOrder rechargeOrder) {
        rechargeOrderMapper.updateByPrimaryKey(rechargeOrder);
    }
    @Transactional
    @Override
    public PageResult findAllOrder(Integer page, Integer limit, RechargeOrder rechargeOrder) {
        Integer start = (page - 1) * limit;
        PageUtils pageUtils = new PageUtils();
        pageUtils.setStart(start);
        pageUtils.setLimit(limit);

        if ("".equals(rechargeOrder.getPlatform())) {
            rechargeOrder.setIdentificationCode(null);
        }
        if ("".equals(rechargeOrder.getPackageName())) {
            rechargeOrder.setPackageName(null);
        }

        pageUtils.setRechargeOrder(rechargeOrder);
        List<RechargeOrder> list = rechargeOrderMapper.findAllOrder(pageUtils);
        List<RechargeOrderExt> exts=new ArrayList<>();
        if(list.size()!=0){
            for (RechargeOrder order : list) {
                //System.out.println(order.getRechargeId());
                Recharge recharge = rechargeService.selectByPrimaryKey(order.getRechargeId());
                //System.out.println(recharge);
                RechargeOrderExt ext=new RechargeOrderExt();
                ext.setCoin(recharge.getCoin());
                ext.setPrice(recharge.getPrice());
                ext.setStatus(order.getStatus());
                ext.setCreateTime(order.getCreateTime());
                ext.setOrderid(order.getOrderid());
                ext.setIdentificationCode(order.getIdentificationCode());
                ext.setPackageName(order.getPackageName());
                ext.setPlatform(order.getPlatform());
                ext.setRechargeId(order.getRechargeId());
                exts.add(ext);
            }
        }
        Integer count = rechargeOrderMapper.count(pageUtils);
        PageResult result = new PageResult();
        result.setMsg("success");
        result.setCount(count);
        result.setCode(0);
        result.setData(exts);
        return result;
    }

}
