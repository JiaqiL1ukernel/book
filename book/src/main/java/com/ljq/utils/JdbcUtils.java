package com.ljq.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;


import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class JdbcUtils {
  private static DataSource dataSource = null;
  private static ThreadLocal<Connection> conn = new ThreadLocal<>();

  static {
    try {
      Properties prop = new Properties();
      InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
      prop.load(is);
      dataSource = DruidDataSourceFactory.createDataSource(prop);
      System.out.println(dataSource);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static Connection getConnection() {
    Connection connection = conn.get();
    if(connection==null){
      try {
        connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        conn.set(connection);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
    return connection;

  }


  public static void commitAndClose(){
    Connection connection = conn.get();
    if(connection!=null){
      try {
        connection.commit();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }finally {
        try {
          connection.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      conn.remove();
    }
  }


  public static void rollbackAndClose(){
    Connection connection = conn.get();
    if(connection!=null){
      try {
        connection.rollback();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }finally {
        try {
          connection.close();
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
      conn.remove();
    }
  }


}
