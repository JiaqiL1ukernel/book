package com.ljq.test;

import com.ljq.dao.impl.OrderDaoImpl;
import com.ljq.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

  @Test
  public void saveOrder() {
    OrderDaoImpl orderDao = new OrderDaoImpl();
    orderDao.saveOrder(new Order("1",new Date(),new BigDecimal(11.00),0,2));
  }
}
