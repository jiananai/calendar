package com.nineton.calendar.service.impl;

import com.nineton.calendar.mapper.WallpaperOrderMapper;
import com.nineton.calendar.pojo.User;
import com.nineton.calendar.pojo.WallpaperOrder;
import com.nineton.calendar.pojo.WallpaperOrderExample;
import com.nineton.calendar.service.UserService;
import com.nineton.calendar.service.WallpaperOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class WallpaperOrderServiceImpl implements WallpaperOrderService {
    @Autowired
    private WallpaperOrderMapper wallpaperOrderMapper;
    @Autowired
    private UserService userService;
    @Override
    public List<WallpaperOrder> findOrder(User user) {
        WallpaperOrderExample example=new WallpaperOrderExample();
        WallpaperOrderExample.Criteria criteria = example.createCriteria();
        criteria.andIdentificationCodeEqualTo(user.getIdentificationCode());
        List<WallpaperOrder> wallpaperOrders = wallpaperOrderMapper.selectByExample(example);
        return wallpaperOrders;
    }

    @Override
    public String insertOrder(WallpaperOrder wallpaperOrder) {

        User user = userService.selectByPrimaryKey(wallpaperOrder.getIdentificationCode());
        if(user.getHaveCoin()<1){
            return null;
        }
        user.setConsumeMoney(user.getConsumeMoney()+1);
        user.setHaveCoin(user.getHaveCoin()-1);
        userService.update(user);

        wallpaperOrder.setCreateTime(new Date());
        wallpaperOrderMapper.insert(wallpaperOrder);
        return "success";
    }
}
