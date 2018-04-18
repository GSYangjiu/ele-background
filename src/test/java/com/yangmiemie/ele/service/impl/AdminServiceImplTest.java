package com.yangmiemie.ele.service.impl;

import com.yangmiemie.ele.EleApplication;
import com.yangmiemie.ele.common.utils.Message;
import com.yangmiemie.ele.entity.Admin;
import com.yangmiemie.ele.service.IAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 16:54
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EleApplication.class)
@WebAppConfiguration
@TestPropertySource({//引用的配置文件
        "classpath:/application.yml"
})
public class AdminServiceImplTest {
    @Autowired
    private IAdminService adminService;

    @Test
    public void login() {
        Message msg;

        Admin admin1 = new Admin();
        admin1.setUsername("yang");
        admin1.setPassword("mariko2008");

        Admin admin2 = new Admin();
        admin2.setUsername("yang");
        admin2.setPassword("12345");

        Admin admin3 = new Admin();
        admin3.setUsername("wang");
        admin3.setPassword("12345");

        msg = adminService.login(admin1);
        System.out.println(msg.toString());
        msg = adminService.login(admin2);
        System.out.println(msg.toString());
        msg = adminService.login(admin3);
        System.out.println(msg.toString());
    }
}