package com.nineton.calendar.controller;

import com.nineton.calendar.extend.RequestDecryptBody;
import com.nineton.calendar.extend.ResponseEncryptBody;
import com.nineton.calendar.pojo.Result;
import com.nineton.calendar.pojo.WallpaperOrder;
import com.nineton.calendar.service.WallpaperOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WallpaperOrderController {
    @Autowired
    private WallpaperOrderService wallpaperOrderService;

    @RequestMapping("/serve")
    @ResponseEncryptBody
    public Result serve(@RequestDecryptBody WallpaperOrder wallpaperOrder){
        String s=wallpaperOrderService.insertOrder(wallpaperOrder);
        if(s!=null){
            return Result.ok();
        }else{
            return Result.build(300,"Your coin is not enough !");
        }

    }

}
