package com.nineton.calendar.service.impl;

import com.nineton.calendar.mapper.ConfigMapper;
import com.nineton.calendar.pojo.*;
import com.nineton.calendar.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigMapper configMapper;
    @Override
    public List<Config> getConfigList() {
        ConfigExample example=new ConfigExample();
        List<Config> configs = configMapper.selectByExampleWithBLOBs(example);
        return configs;
    }

    @Override
    public PageResult findAllConfig(Integer page, Integer limit) {
        Integer start = (page - 1) * limit;
        PageUtils pageUtils = new PageUtils();
        pageUtils.setStart(start);
        pageUtils.setLimit(limit);

        List<Config> list = configMapper.findAllConfig(pageUtils);
        Integer count = configMapper.count(pageUtils);
        PageResult result = new PageResult();
        result.setMsg("success");
        result.setCount(count);
        result.setCode(0);
        result.setData(list);
        return result;
    }

    @Override
    public void deleteConfig(Integer id) {
        configMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void editConfig(Config config) {
        configMapper.updateByPrimaryKeyWithBLOBs(config);
    }

    @Override
    public void insertConfig(Config config) {
        configMapper.insert(config);
    }
}
