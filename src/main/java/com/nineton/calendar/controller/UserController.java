package com.nineton.calendar.controller;


import com.nineton.calendar.extend.RequestDecryptBody;
import com.nineton.calendar.extend.ResponseEncryptBody;
import com.nineton.calendar.pojo.PageResult;
import com.nineton.calendar.pojo.Result;
import com.nineton.calendar.pojo.User;
import com.nineton.calendar.pojo.UserExt;
import com.nineton.calendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userMessage")
    @ResponseEncryptBody
    public Result findUserMessage(@RequestDecryptBody User user){
        UserExt u=userService.insertOrFindUser(user);
        return Result.build(200,"ok",u);
    }

    @RequestMapping("/user/userPage")
    @ResponseBody
    public PageResult userPage(Integer page, Integer limit, User user){
        PageResult result =userService.findAllUser(page,limit,user);
        //System.out.println(user);
        return result;
    }

    @RequestMapping("/user/delete/{identificationCode}")
    @ResponseBody
    public Result deleteUser(@PathVariable String identificationCode){
        userService.deleteUser(identificationCode);
        return Result.ok();
    }

}
