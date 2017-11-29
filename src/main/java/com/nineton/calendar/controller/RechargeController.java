package com.nineton.calendar.controller;

import com.nineton.calendar.extend.RequestDecryptBody;
import com.nineton.calendar.extend.ResponseEncryptBody;
import com.nineton.calendar.pojo.PageResult;
import com.nineton.calendar.pojo.Recharge;
import com.nineton.calendar.pojo.Result;
import com.nineton.calendar.pojo.User;
import com.nineton.calendar.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RechargeController {
    @Autowired
    private RechargeService rechargeService;

    @RequestMapping("/rechargeList")
    @ResponseEncryptBody
    public Result getRechargeList(@RequestDecryptBody Recharge recharge){
        List<Recharge> rechargeList=rechargeService.getRechargeList(recharge);
        return Result.build(200,"ok",rechargeList);
    }

    @RequestMapping("/recharge/rechargePage")
    @ResponseBody
    public PageResult rechargePage(Integer page, Integer limit, Recharge recharge){
        PageResult result =rechargeService.findAllRecharge(page,limit,recharge);
        //System.out.println(user);
        return result;
    }

    @RequestMapping("/recharge/delete/{id}")
    @ResponseBody
    public Result deleteRecharge(@PathVariable Integer id){
        rechargeService.deleteRecharge(id);
        return Result.ok();
    }

    @RequestMapping("/recharge/edit")
    @ResponseBody
    public Result editRecharge(@RequestBody Recharge recharge){
        rechargeService.editRecharge(recharge);
        return Result.ok();
    }

    @RequestMapping("/recharge/add")
    public String insertRecharge(Recharge recharge){
        rechargeService.insertRecharge(recharge);
        return "redirect:/recharge-list";
    }
}
