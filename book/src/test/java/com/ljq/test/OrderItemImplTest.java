package com.ljq.test;

import com.ljq.dao.impl.OrderItemImpl;
import com.ljq.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemImplTest {

  @Test
  public void saveOrderItem() {
    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.saveOrderItem(new OrderItem(1,"钢铁是怎样炼成的",2,new BigDecimal(12),new BigDecimal(24),"1"));
  }
}
