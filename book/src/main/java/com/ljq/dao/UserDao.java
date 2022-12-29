package com.ljq.dao;

import com.ljq.pojo.User;

public interface UserDao {

  User queryUserByusername(String userName);

  User queryUserByusernameAndPassword(String userName,String password);

  int registerUser(User user);

}
