package com.nineton.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class PageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page, HttpServletRequest httpServletRequest) throws IOException {
        String str = (String) httpServletRequest.getAttribute("page");
        if(str!=null){

            return "relogin";
        }
        return page;
    }

    @RequestMapping("/page/login")
    public String login(String username, String password, HttpServletRequest request){
        if("admin".equals(username)&&"nineton.com".equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("user",username);
            session.setMaxInactiveInterval(30*60);
            return "redirect:/index";
        }
        return "login";
    }

    @RequestMapping("/page/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("user",null);
        return "login";
    }
}
