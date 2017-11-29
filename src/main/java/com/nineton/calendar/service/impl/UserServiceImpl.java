package com.nineton.calendar.service.impl;


import com.nineton.calendar.mapper.UserMapper;
import com.nineton.calendar.pojo.*;
import com.nineton.calendar.service.UserService;
import com.nineton.calendar.service.WallpaperOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WallpaperOrderService wallpaperOrderService;

    @Override
    public UserExt insertOrFindUser(User user) {
        UserExt u=new UserExt();
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdentificationCodeEqualTo(user.getIdentificationCode());
        List<User> users = userMapper.selectByExample(example);
        if(users==null||users.size()==0){
            user.setCreateTime(new Date());
            user.setHaveCoin(0);
            user.setConsumeCoin(0);
            user.setConsumeMoney(0d);
            userMapper.insert(user);
            u.setUser(user);
            u.setWallpaperOrders(null);
            return u;
        }


        List<WallpaperOrder> calendarOrders=wallpaperOrderService.findOrder(user);
        if(calendarOrders==null||calendarOrders.size()==0){
            calendarOrders=null;
        }
        u.setUser(users.get(0));
        u.setWallpaperOrders(calendarOrders);
        return u;
    }

    @Override
    public User selectByPrimaryKey(String identificationCode) {
        User user = userMapper.selectByPrimaryKey(identificationCode);
        return user;
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public PageResult findAllUser(Integer page, Integer limit, User user) {
        Integer start = (page - 1) * limit;
        PageUtils pageUtils = new PageUtils();
        pageUtils.setStart(start);
        pageUtils.setLimit(limit);

        if ("".equals(user.getIdentificationCode())) {
            user.setIdentificationCode(null);
        }
        if ("".equals(user.getPackageName())) {
            user.setPackageName(null);
        }

        pageUtils.setUser(user);
        List<User> list = userMapper.findAllUser(pageUtils);
        Integer count = userMapper.count(pageUtils);
        PageResult result = new PageResult();
        result.setMsg("success");
        result.setCount(count);
        result.setCode(0);
        result.setData(list);
        return result;
    }

    @Override
    public void deleteUser(String identificationCode) {
        userMapper.deleteByPrimaryKey(identificationCode);
    }
}
