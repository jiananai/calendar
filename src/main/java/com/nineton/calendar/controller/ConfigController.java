package com.nineton.calendar.controller;

import com.nineton.calendar.extend.ResponseEncryptBody;
import com.nineton.calendar.pojo.Config;
import com.nineton.calendar.pojo.PageResult;
import com.nineton.calendar.pojo.Result;
import com.nineton.calendar.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @RequestMapping("/configList")
    @ResponseEncryptBody
    public Result getConfigList(){
       List<Config> configList= configService.getConfigList();
       return Result.build(200,"ok",configList);
    }

    @RequestMapping("/config/configPage")
    @ResponseBody
    public PageResult getConfigPage(Integer page, Integer limit){
        PageResult result=configService.findAllConfig(page,limit);
        return result;
    }
    @RequestMapping("/config/delete/{id}")
    @ResponseBody
    public Result deleteConfig(@PathVariable Integer id){
        configService.deleteConfig(id);
        return Result.ok();
    }
    @RequestMapping("/config/edit")
    @ResponseBody
    public Result editConfig(@RequestBody Config config){
        configService.editConfig(config);
        return Result.ok();
    }

    @RequestMapping("/config/add")
    public String addConfig(Config config){
        configService.insertConfig(config) ;
        return "redirect:/config-list";
    }
}
