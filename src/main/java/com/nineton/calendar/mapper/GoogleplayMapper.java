package com.nineton.calendar.mapper;

import com.nineton.calendar.pojo.Googleplay;
import com.nineton.calendar.pojo.GoogleplayExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GoogleplayMapper {
    int countByExample(GoogleplayExample example);

    int deleteByExample(GoogleplayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Googleplay record);

    int insertSelective(Googleplay record);

    List<Googleplay> selectByExample(GoogleplayExample example);

    Googleplay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Googleplay record, @Param("example") GoogleplayExample example);

    int updateByExample(@Param("record") Googleplay record, @Param("example") GoogleplayExample example);

    int updateByPrimaryKeySelective(Googleplay record);

    int updateByPrimaryKey(Googleplay record);
}