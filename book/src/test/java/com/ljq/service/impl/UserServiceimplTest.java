package com.ljq.service.impl;

import com.ljq.pojo.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceimplTest {

  @Test
  void registUser() {
    User user = new User(4, "2155231", "jwqklqodj", "uwqda@qq.com");
    UserServiceimpl userServiceimpl = new UserServiceimpl();
    userServiceimpl.registUser(user);

  }

  @Test
  void login() {
    User user = new User(4, "2155231", "jwqklqodj", "uwqda@qq.com");
    UserServiceimpl userServiceimpl = new UserServiceimpl();



  }

  @Test
  void existUsername() {
    UserServiceimpl userServiceimpl = new UserServiceimpl();
    String username="lk";
    System.out.println(userServiceimpl.existUsername(username));
  }
}
