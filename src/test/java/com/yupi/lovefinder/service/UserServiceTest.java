package com.yupi.lovefinder.service;

import com.yupi.lovefinder.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * 用户服务测试
 *
 * @author yupi
 */
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void assaencrypt() {
        // 2. 加密
        String encryptPassword = DigestUtils.md5DigestAsHex(("yupi" + 123).getBytes());
        System.out.println(encryptPassword);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUserName("dogYupi");
        user.setUserAccount("123");
        user.setUserAvatar("");
        user.setGender(0);
        user.setUserPassword("xxx");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("dogYupi");
        user.setUserAccount("123");
        user.setUserAvatar("");
        user.setGender(0);
        user.setUserPassword("xxx");
        boolean result = userService.updateById(user);
        Assertions.assertTrue(result);
    }

    @Test
    public void testDeleteUser() {
        boolean result = userService.removeById(1L);
        Assertions.assertTrue(result);
    }

    @Test
    public void testGetUser() {
        User user = userService.getById(1L);
        Assertions.assertNotNull(user);
    }

    @Test
    void userRegister() {
        String userAccount = "yupi";
        String userPassword = "12345";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
    }
}