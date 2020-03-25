package com.example.coursecommunity.controller;

import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private UserService userService;


    /**
     * 重定向到LOGIN
     * @return
     */
    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")//主页面
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/login")//登录界面
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @GetMapping("/register")//注册页面
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @PostMapping("/register")//注册检测
    public String registerUser(User user){
        userService.registerUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")//登录检测
    public String loginUser(User user){
        User user1=userService.login(user);
        if(user1!=null) {
            return "redirect:/index";
        }else return "redirect:/login";
    }



}
