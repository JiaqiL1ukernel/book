package com.ljq.dao.impl;

import com.ljq.pojo.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoimplTest {

  @Test
  void queryUserByusername() {
    UserDaoimpl userDaoimpl = new UserDaoimpl();
    User admin = userDaoimpl.queryUserByusername("46512");
    System.out.println(admin);

  }

  @Test
  void queryUserByusernameAndPassword() {

    UserDaoimpl userDaoimpl = new UserDaoimpl();
    User user = userDaoimpl.queryUserByusernameAndPassword("admin", "admin");
    System.out.println(user);
  }

  @Test
  void registerUser() {
    UserDaoimpl userDaoimpl = new UserDaoimpl();
    User user = new User(0, "46512", "dqasdlka", "dadsa@qq.com");
    System.out.println(userDaoimpl.registerUser(user));
  }
}
