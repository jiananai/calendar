package com.nineton.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

    @RequestMapping("/page/login")
    public String login(String username, String password, HttpServletRequest request){
        if("admin".equals(username)&&"nineton.com".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("user",username);
            session.setMaxInactiveInterval(60*10);
            return "index";
        }
        return "login";
    }

    @RequestMapping("/page/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("user",null);
        return "login";
    }
}
