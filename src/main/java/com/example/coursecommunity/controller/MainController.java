package com.example.coursecommunity.controller;

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
        return new ModelAndView("login","Model",model);
    }
}
