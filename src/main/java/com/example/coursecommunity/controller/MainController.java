package com.example.coursecommunity.controller;

import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.service.UserService;
import com.example.coursecommunity.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response> registerUser(User user){
        if(userService.registerUser(user)){
            return ResponseEntity.ok().body(new Response(true,"注册成功！等待激活",user));
        }
        return ResponseEntity.ok().body(new Response(false,"注册失败！账号可能已被注册！"));
    }

    @PostMapping("/active")//激活账号
    public String activeUser(User user){
        userService.activeUser(user);
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
