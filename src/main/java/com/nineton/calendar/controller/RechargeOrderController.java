package com.nineton.calendar.controller;

import com.nineton.calendar.extend.RequestDecryptBody;
import com.nineton.calendar.extend.ResponseEncryptBody;
import com.nineton.calendar.pojo.PageResult;
import com.nineton.calendar.pojo.RechargeOrder;
import com.nineton.calendar.pojo.Result;
import com.nineton.calendar.service.RechargeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RechargeOrderController {
    @Autowired
    private RechargeOrderService rechargeOrderService;

    @RequestMapping("/getOrder")
    @ResponseEncryptBody
    public Result getOrder(@RequestDecryptBody RechargeOrder order){
        RechargeOrder rechargeOrder=rechargeOrderService.insertOrder(order);
        return Result.build(200,"ok",rechargeOrder);
    }

    @RequestMapping("/rechargeOrder/rechargeOrderPage")
    @ResponseBody
    public PageResult getRechargeOrderPage(Integer page, Integer limit, RechargeOrder rechargeOrder){
        PageResult result=rechargeOrderService.findAllOrder(page,limit,rechargeOrder);
        return  result;
    }

}
