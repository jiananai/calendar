package com.nineton.calendar.service.impl;

import com.nineton.calendar.mapper.RechargeMapper;
import com.nineton.calendar.pojo.*;
import com.nineton.calendar.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {
    @Autowired
    private RechargeMapper rechargeMapper;
    @Override
    public List<Recharge> getRechargeList(Recharge recharge) {
        RechargeExample example=new RechargeExample();
        RechargeExample.Criteria criteria = example.createCriteria();
        if(recharge!=null&&recharge.getPackageName()!=null){
            criteria.andPackageNameEqualTo(recharge.getPackageName());
        }
        if(recharge!=null&&recharge.getPlatform()!=null){
            criteria.andPlatformEqualTo(recharge.getPlatform());
        }
        List<Recharge> recharges = rechargeMapper.selectByExample(example);
        return recharges;
    }

    @Override
    public Recharge selectByPrimaryKey(Integer rechargeId) {
        Recharge recharge = rechargeMapper.selectByPrimaryKey(rechargeId);
        return recharge;
    }

    @Override
    public PageResult findAllRecharge(Integer page, Integer limit, Recharge recharge) {
        Integer start = (page - 1) * limit;
        PageUtils pageUtils = new PageUtils();
        pageUtils.setStart(start);
        pageUtils.setLimit(limit);

        if ("".equals(recharge.getPackageName())) {
            recharge.setPackageName(null);
        }
        if ("".equals(recharge.getPlatform())) {
            recharge.setPlatform(null);
        }

        pageUtils.setRecharge(recharge);
        List<Recharge> list = rechargeMapper.findAllRecharge(pageUtils);
        Integer count = rechargeMapper.count(pageUtils);
        PageResult result = new PageResult();
        result.setMsg("success");
        result.setCount(count);
        result.setCode(0);
        result.setData(list);
        return result;
    }

    @Override
    public void deleteRecharge(Integer id) {
        rechargeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void editRecharge(Recharge recharge) {
        rechargeMapper.updateByPrimaryKey(recharge);
    }

    @Override
    public void insertRecharge(Recharge recharge) {
        rechargeMapper.insert(recharge);
    }
}
