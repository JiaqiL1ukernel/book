package com.ljq.dao.impl;

import com.ljq.dao.BaseDao;
import com.ljq.dao.OrderItemDao;
import com.ljq.pojo.OrderItem;

public class OrderItemImpl extends BaseDao implements OrderItemDao {
  @Override
  public int saveOrderItem(OrderItem orderItem) {
    String sql = "insert into t_order_item (id,name,count,price,total_price,order_id) values (?,?,?,?,?,?)";
    return update(sql,null,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
  }
}
