package com.nineton.calendar.mapper;

import com.nineton.calendar.pojo.Theme;
import com.nineton.calendar.pojo.ThemeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ThemeMapper {
    int countByExample(ThemeExample example);

    int deleteByExample(ThemeExample example);

    int insert(Theme record);

    int insertSelective(Theme record);

    List<Theme> selectByExample(ThemeExample example);

    int updateByExampleSelective(@Param("record") Theme record, @Param("example") ThemeExample example);

    int updateByExample(@Param("record") Theme record, @Param("example") ThemeExample example);
}