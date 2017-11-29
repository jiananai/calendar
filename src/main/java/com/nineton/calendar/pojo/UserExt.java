package com.nineton.calendar.pojo;

import java.util.List;

public class UserExt {
    private User user;
    private List<WallpaperOrder> wallpaperOrders;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WallpaperOrder> getWallpaperOrders() {
        return wallpaperOrders;
    }

    public void setWallpaperOrders(List<WallpaperOrder> wallpaperOrders) {
        this.wallpaperOrders = wallpaperOrders;
    }
}
