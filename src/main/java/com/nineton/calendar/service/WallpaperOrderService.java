package com.nineton.calendar.service;

import com.nineton.calendar.pojo.User;
import com.nineton.calendar.pojo.WallpaperOrder;

import java.util.List;

public interface WallpaperOrderService {
    public List<WallpaperOrder> findOrder(User user);

    String insertOrder(WallpaperOrder wallpaperOrder);
}
