package com.test;

import com.antiy.SrcApplication;
import com.antiy.service.user.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program antiy-src-parent
 * @description 
 * @author wangqian
 * created on 2020-03-05
 * @version  1.0.0
 */
@SpringBootTest(classes = SrcApplication.class)
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void updateUser() throws Exception {
        userService.passwordEncode();
    }
}
