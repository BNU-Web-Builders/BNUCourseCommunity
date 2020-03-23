package com.example.coursecommunity;

import com.example.coursecommunity.entity.Organization;
import com.example.coursecommunity.repository.OrganizationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoursecommunityApplicationTests {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    void testOrg(){
        System.out.println(organizationRepository.save(new Organization("政府管理学院","http://www.sg.bnu.edu.cn/",true)).toString());
    }

    @Test
    void contextLoads() {
    }

}
