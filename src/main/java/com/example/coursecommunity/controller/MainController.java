package com.example.coursecommunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    /**
     * 重定向到LOGIN
     * @return
     */
    @GetMapping("/")
    public String root(){
        return "redirect:/login";
    }

    @GetMapping("/login")//登录界面
    public ModelAndView testlogin(Model model){
        model.addAttribute("hello","HelloWorld!");
        model.addAttribute("hello2","123");
        return new ModelAndView("login","Model",model);
    }

    @GetMapping("/loginCheck")
    public String checkLogin(String username,String password){
        if(username.equals("张三") && password.equals("123")){
            return "redirect:/index";
        }else
        return "redirect:/login";
    }

    @GetMapping("/index")//登录界面
    public ModelAndView testlogin(){
        return new ModelAndView("index");
    }

}
