package com.nineton.calendar.service;

import com.nineton.calendar.pojo.Config;
import com.nineton.calendar.pojo.PageResult;

import java.util.List;

public interface ConfigService {
    List<Config> getConfigList();

    PageResult findAllConfig(Integer page, Integer limit);

    void deleteConfig(Integer id);

    void editConfig(Config config);

    void insertConfig(Config config);
}
