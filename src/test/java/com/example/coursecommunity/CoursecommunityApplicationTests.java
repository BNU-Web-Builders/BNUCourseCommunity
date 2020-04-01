package com.example.coursecommunity;

import com.example.coursecommunity.entity.Authority;
import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.service.AuthorityService;
import com.example.coursecommunity.service.EmailService;
import com.example.coursecommunity.service.UserService;
import com.example.coursecommunity.util.CodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class CoursecommunityApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private EmailService emailService;


    @Test
    void addUser() {
        User user = new User(
                "Jess",//昵称
                "201711260130",//学号
                "12345",//密码
                "",
                1L,//学院编号，必须是Organization表里的ID值
                true,//是否激活账号;没激活的无法登录
                CodeUtil.generateUniqueCode()//激活码
        );
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(1L).get());//添加用户权限
        //authorities.add(authorityService.getAuthorityById(2L).get());//添加管理员权限
        user.setAuthorities(authorities);
        System.out.println(userService.saveOrUpdateUser(user));
    }


    @Test
    void testEmail() {
        String code = CodeUtil.generateUniqueCode();
        System.out.println(emailService.sendRegisterCode("201711260105", code));
    }

    @Test
    void testActive() {

        System.out.println(userService.activeUser("201711260105", "68a4243161bd46ecace094b971848029"));
    }


    @Test
    void contextLoads() {
    }

    @Test
    void testRegisterPost() {
        Optional<User> user = userService.getUserById(13L);
        System.out.println(user.get().toString());
        String userPwd = user.get().getPassword();
        System.out.println(userPwd.equals(new BCryptPasswordEncoder().encode("12345")));
        System.out.println(userPwd.equals(new BCryptPasswordEncoder().encode("123456")));
    }

}
