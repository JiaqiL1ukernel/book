package com.ljq.service.impl;

import com.ljq.dao.UserDao;
import com.ljq.dao.impl.UserDaoimpl;
import com.ljq.pojo.User;
import com.ljq.service.UserService;

public class UserServiceimpl implements UserService {
  public UserServiceimpl() {
  }

  private  UserDao UserDao = new UserDaoimpl();
  @Override
  public void registUser(User user) {
    UserDao.registerUser(user);
  }

  @Override
  public User login(String userName,String password) {
    return UserDao.queryUserByusernameAndPassword(userName,password);
  }

  @Override
  public boolean existUsername(String username) {
    return UserDao.queryUserByusername(username)==null?false:true;
  }
}
