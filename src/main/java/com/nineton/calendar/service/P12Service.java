package com.nineton.calendar.service;



import com.nineton.calendar.pojo.P12;
import com.nineton.calendar.pojo.PageResult;

import java.util.List;

public interface P12Service {

    P12 findByPackageName(String packageName);

    PageResult getAllP12(Integer page, Integer limit);

    void insert(P12 p12);

    void deleteP12(Integer id);

    List<P12> getP12List();
}
