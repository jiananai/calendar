package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: YanLong
 * @Description:
 * @Date: Created in 13:33 2018/11/15
 */
@Controller
public class UserController {

    @RequestMapping("testDemo")
    public String saveUser(){
        return "test";
    }
}
