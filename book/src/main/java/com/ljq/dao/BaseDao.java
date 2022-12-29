package com.ljq.dao;

import com.ljq.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

  private QueryRunner runner = new QueryRunner();

  public int update(String sql,Object...args) {
    Connection conn = JdbcUtils.getConnection();

    try {
      return runner.update(conn,sql,args);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      throw new RuntimeException(throwables);
    }
  }


  public <T> T QueryForOne(String sql,Class<T> clazz,Object...args){
    Connection conn = JdbcUtils.getConnection();
    BeanHandler<T> handler = new BeanHandler<>(clazz);
    try {
      return runner.query(conn,sql,handler,args);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      throw new RuntimeException(throwables);
    }
  }




  public <T> List<T> QueryForList(String sql, Class<T> clazz, Object...args){
    Connection conn = JdbcUtils.getConnection();
    BeanListHandler<T> handler = new BeanListHandler<>(clazz);
    try {
      return runner.query(conn,sql,handler,args);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      throw new RuntimeException(throwables);
    }
  }


  public Object QueryForSingelValue(String sql,Object...args){
    Connection conn = JdbcUtils.getConnection();
    ScalarHandler handler = new ScalarHandler();

    try {
      return runner.query(conn,sql,handler,args);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      throw new RuntimeException(throwables);
    }

  }





}
