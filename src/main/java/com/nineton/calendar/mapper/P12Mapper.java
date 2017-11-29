package com.nineton.calendar.mapper;

import com.nineton.calendar.pojo.P12;
import com.nineton.calendar.pojo.P12Example;
import java.util.List;

import com.nineton.calendar.pojo.PageUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface P12Mapper {
    int countByExample(P12Example example);

    int deleteByExample(P12Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(P12 record);

    int insertSelective(P12 record);

    List<P12> selectByExample(P12Example example);

    P12 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") P12 record, @Param("example") P12Example example);

    int updateByExample(@Param("record") P12 record, @Param("example") P12Example example);

    int updateByPrimaryKeySelective(P12 record);

    int updateByPrimaryKey(P12 record);

    List<P12> findAllP12(PageUtils pageUtils);

    Integer count(PageUtils pageUtils);
}