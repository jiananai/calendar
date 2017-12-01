package com.nineton.calendar.service.impl;


import com.nineton.calendar.mapper.P12Mapper;
import com.nineton.calendar.pojo.*;
import com.nineton.calendar.service.P12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
public class P12ServiceImpl implements P12Service {

    @Autowired
    private P12Mapper p12Mapper;

    @Transactional
    @Override
    public P12 findByPackageName(String packageName) {
        P12Example example = new P12Example();
        P12Example.Criteria criteria = example.createCriteria();
        criteria.andPackageNameEqualTo(packageName);
        List<P12> list = p12Mapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    @Transactional
    @Override
    public PageResult getAllP12(Integer page, Integer limit) {
        Integer start = (page - 1) * limit;
        PageUtils pageUtils = new PageUtils();
        pageUtils.setStart(start);
        pageUtils.setLimit(limit);

        List<P12> list = p12Mapper.findAllP12(pageUtils);
        Integer count = p12Mapper.count(pageUtils);
        PageResult result = new PageResult();
        result.setMsg("success");
        result.setCount(count);
        result.setCode(0);
        result.setData(list);
        return result;
    }

    @Transactional
    @Override
    public void insert(P12 p12) {
        p12Mapper.insert(p12);
    }

    @Transactional
    @Override
    public void deleteP12(Integer id) {
        P12 p12 = p12Mapper.selectByPrimaryKey(id);
        File file = new File("P12/" + p12.getFileName());
        if (file.exists()) {
            file.delete();
        }
        p12Mapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public List<P12> getP12List() {
        P12Example example = new P12Example();
        return p12Mapper.selectByExample(example);
    }

}
