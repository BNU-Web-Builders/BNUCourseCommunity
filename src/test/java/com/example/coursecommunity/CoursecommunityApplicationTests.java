package com.example.coursecommunity;

import com.example.coursecommunity.entity.Organization;
import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.repository.OrganizationRepository;
import com.example.coursecommunity.service.UserService;
import com.example.coursecommunity.util.CodeUtil;
import com.example.coursecommunity.util.SendMail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class CoursecommunityApplicationTests {
    @Autowired
    private UserService userService;



    @Test
    void testRegister(){
        User user=new User("Jess","201711260105","123456","",1L,false,"");
        System.out.println(userService.registerUser(user));

    }

    @Test
    void testEmail() throws MessagingException {
        String code= CodeUtil.generateUniqueCode();
        System.out.println(code);
        SendMail sendMail=new SendMail();
        sendMail.send("201711260105@mail.bnu.edu.cn",code);
    }



    @Test
    void contextLoads() {
    }

}
