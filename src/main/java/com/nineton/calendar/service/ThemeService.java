package com.nineton.calendar.service;

import com.nineton.calendar.pojo.Theme;

import java.util.List;

public interface ThemeService {
    List<Theme> findAllTheme();

    void insertTheme(Theme theme);
}
