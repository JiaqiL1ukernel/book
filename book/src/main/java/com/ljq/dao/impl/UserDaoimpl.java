package com.ljq.dao.impl;

import com.ljq.dao.BaseDao;
import com.ljq.dao.UserDao;
import com.ljq.pojo.User;

public class UserDaoimpl extends BaseDao implements UserDao {
  public UserDaoimpl() {
  }

  @Override
  public User queryUserByusername(String userName) {
    String sql = "select id,username,password,email from t_user where username = ? ";
    return  QueryForOne(sql,User.class,userName);
  }

  @Override
  public User queryUserByusernameAndPassword(String userName, String password) {
    String sql = "select id,username,password,email from t_user where username=?and password = ?";
    return QueryForOne(sql,User.class,userName,password);
  }

  @Override
  public int registerUser(User user) {
    String sql = "insert into t_user (username,password,email) values(?,?,?)";
    return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
  }
}
