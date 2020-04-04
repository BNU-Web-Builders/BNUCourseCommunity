package com.example.coursecommunity.controller;

import com.example.coursecommunity.entity.Authority;
import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.service.AuthorityService;
import com.example.coursecommunity.service.UserService;
import com.example.coursecommunity.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;


    /**
     * 重定向到LOGIN
     *
     * @return
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")//主页面
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")//登录界面
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/login-error")//登录出错
    public ModelAndView loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败！用户名或密码错误或账号未激活！");
        return new ModelAndView("login", "Model", model);
    }

    @GetMapping("/register")//注册页面
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @GetMapping("/checkAccount")
    public ResponseEntity<Response> checkAccount(String account) {
        try {
            if (account.length() != 12) {
                return ResponseEntity.status(200).body(new Response(false, "请输入正确格式!"));
            } else if (userService.checkAccountPresent(account)) {
                return ResponseEntity.status(200).body(new Response(false, "该账号已被注册!"));
            }
            return ResponseEntity.status(200).body(new Response(true, "恭喜您！该账号可以使用！"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Response(false, e.getMessage()));
        }

    }

    @PostMapping("/register")//注册
    public String registerUser(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(1L).get());
        user.setAuthorities(authorities);
        if (userService.registerUser(user)) {
            return "redirect:/login";
        }
        return "redirect:/register";
    }

    @GetMapping("/active")//激活账号
    public String activeUser(
            String account,//学号 @RequestParam(value = "account", required = true, defaultValue = "000000000000")
            String code//激活码
    ) {
        userService.activeUser(account, code);
        return "redirect:/login";
    }


}
