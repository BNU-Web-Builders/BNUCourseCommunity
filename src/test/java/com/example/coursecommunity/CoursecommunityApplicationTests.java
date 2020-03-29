package com.example.coursecommunity;

import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.service.EmailService;
import com.example.coursecommunity.service.UserService;
import com.example.coursecommunity.util.CodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoursecommunityApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;


    @Test
    void addUser(){
        System.out.println(userService.saveOrUpdateUser(new User("Jess","201711260105","12345","",1L,false,"123456")));
    }


    @Test
    void testEmail(){
        String code= CodeUtil.generateUniqueCode();
        System.out.println(emailService.sendRegisterCode("201711260105",code));
    }

    @Test
    void testActive(){

        System.out.println(userService.activeUser("201711260105","68a4243161bd46ecace094b971848029"));
    }


    @Test
    void contextLoads() {
    }

    @Test
    void testRegisterPost(){
        

    }

}
