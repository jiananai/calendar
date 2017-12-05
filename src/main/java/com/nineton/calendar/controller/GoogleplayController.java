package com.nineton.calendar.controller;

import com.nineton.calendar.extend.RequestDecryptBody;
import com.nineton.calendar.extend.ResponseEncryptBody;
import com.nineton.calendar.pojo.GoogleplayExt;
import com.nineton.calendar.pojo.Result;
import com.nineton.calendar.service.GoogleplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoogleplayController {
    @Autowired
    private GoogleplayService googleplayService;

    @RequestMapping("/checkPay")
    @ResponseEncryptBody
    public Result checkPay(@RequestDecryptBody GoogleplayExt googleplayExt) {
        String s = googleplayService.checkPay(googleplayExt);

        if (s != null) {
            if (s.equals("success")) {
                return Result.build(200, "The pay success !", null);
            } else if (s.equals("fail")) {
                return Result.build(300, "The pay fail !", "null");
            } else if (s.equals("fault")) {
                return Result.build(300, "The pay have already success ,not repeat !", "null");
            } else {
                return Result.build(300, "Parameter is wrong !", null);
            }
        } else {
            return Result.build(300, "The connect fail !", null);
        }

    }
}
