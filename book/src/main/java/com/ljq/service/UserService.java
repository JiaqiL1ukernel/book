package com.ljq.service;

import com.ljq.pojo.User;

public interface UserService {
  void registUser(User user);

  User login(String userName,String password);

  boolean existUsername(String username);
}
