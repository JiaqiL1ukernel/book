package com.ljq.service;

import com.ljq.pojo.Cart;

public interface OrderService {
  String createOrder(Cart cart ,Integer id);
}
