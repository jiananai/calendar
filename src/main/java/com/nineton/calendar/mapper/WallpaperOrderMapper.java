package com.nineton.calendar.mapper;

import com.nineton.calendar.pojo.WallpaperOrder;
import com.nineton.calendar.pojo.WallpaperOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface WallpaperOrderMapper {
    int countByExample(WallpaperOrderExample example);

    int deleteByExample(WallpaperOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(WallpaperOrder record);

    int insertSelective(WallpaperOrder record);

    List<WallpaperOrder> selectByExample(WallpaperOrderExample example);

    WallpaperOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") WallpaperOrder record, @Param("example") WallpaperOrderExample example);

    int updateByExample(@Param("record") WallpaperOrder record, @Param("example") WallpaperOrderExample example);

    int updateByPrimaryKeySelective(WallpaperOrder record);

    int updateByPrimaryKey(WallpaperOrder record);
}