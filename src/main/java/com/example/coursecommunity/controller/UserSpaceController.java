package com.example.coursecommunity.controller;

import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.service.UserService;
import com.example.coursecommunity.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userSp")
public class UserSpaceController {
    @Autowired
    private UserService userService;
    @Qualifier("userServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;
    @Value("${file.server.url}")
    private String fileServerUrl;

    //一、页面

    //个人空间主页面

    //编辑个人资料页面
    @GetMapping("/{account}/profile")
    @PreAuthorize("authentication.principal.account.equals(#account)")
    public ModelAndView profile(
            @PathVariable("account")String account,
            Model model
    ){
        User user=(User)userDetailsService.loadUserByUsername(account);
        model.addAttribute("user",user);
        model.addAttribute("fileServerUrl",fileServerUrl);
        return new ModelAndView("profile","Model",model);
    }

    //查看关注课程信息页面

    //查看/回复评论消息页面

    //二、操作
    @PostMapping("/{account}/profile")
    @PreAuthorize("authentication.principal.account.equals(#account)")//只允许改昵称、学院、密码,头像修改见下一个Controller
    public String saveProfile(
            @PathVariable("account")String account,
            User user
    ){
        User originalUser=userService.getUserById(user.getId()).get();
        originalUser.setUsername(user.getUsername());
        originalUser.setOrgId(user.getOrgId());
        //判断密码是否做了变更
        String rawPassword=originalUser.getPassword();
        String encodePassword=new BCryptPasswordEncoder().encode(user.getPassword());
        boolean isMatch=rawPassword.equals(encodePassword);
        if(!isMatch){
            originalUser.setPassword(encodePassword);
        }
        userService.saveOrUpdateUser(originalUser);
        return "redirect:/userSp/"+account+"/profile";
    }

    /**
     * 保存头像
     * @param account
     * @param user
     * @return
     */
    @PostMapping("/{account}/avatar")
    @PreAuthorize("authentication.principal.account.equals(#account)")
    public ResponseEntity<Response> saveAvatar(
            @PathVariable("account") String account,
            @RequestBody User user
    ){
        String avatarUrl=user.getAvatar();
        User originalUser=userService.getUserById(user.getId()).get();
        originalUser.setAvatar(avatarUrl);
        userService.saveOrUpdateUser(originalUser);
        return ResponseEntity.ok().body(new Response(true,"处理成功",avatarUrl));
    }


}
