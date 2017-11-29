package com.nineton.calendar.mapper;

import com.nineton.calendar.pojo.PageUtils;
import com.nineton.calendar.pojo.RechargeOrder;
import com.nineton.calendar.pojo.RechargeOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RechargeOrderMapper {
    int countByExample(RechargeOrderExample example);

    int deleteByExample(RechargeOrderExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(RechargeOrder record);

    int insertSelective(RechargeOrder record);

    List<RechargeOrder> selectByExample(RechargeOrderExample example);

    RechargeOrder selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") RechargeOrder record, @Param("example") RechargeOrderExample example);

    int updateByExample(@Param("record") RechargeOrder record, @Param("example") RechargeOrderExample example);

    int updateByPrimaryKeySelective(RechargeOrder record);

    int updateByPrimaryKey(RechargeOrder record);

    List<RechargeOrder> findAllOrder(PageUtils pageUtils);

    Integer count(PageUtils pageUtils);
}