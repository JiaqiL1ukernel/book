package com.ljq.test;

import com.ljq.pojo.Cart;
import com.ljq.pojo.CartItem;
import com.ljq.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

  @Test
  public void createOrder() {
    OrderServiceImpl orderService = new OrderServiceImpl();
    Cart cart = new Cart();
    cart.addItem(new CartItem(1,"钢铁是怎样练成的",1,new BigDecimal(11),new BigDecimal(11)));
    cart.addItem(new CartItem(1,"钢铁是怎样练成的",1,new BigDecimal(11),new BigDecimal(11)));
    cart.addItem(new CartItem(2,"活着",1,new BigDecimal(20),new BigDecimal(20)));
    System.out.println(orderService.createOrder(cart, 1));;
  }
}
