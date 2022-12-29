package com.ljq.service.impl;

import com.ljq.dao.BookDao;
import com.ljq.dao.OrderDao;
import com.ljq.dao.OrderItemDao;
import com.ljq.dao.impl.BookDaoimpl;
import com.ljq.dao.impl.OrderDaoImpl;
import com.ljq.dao.impl.OrderItemImpl;
import com.ljq.pojo.*;
import com.ljq.service.OrderService;

import java.util.Collection;
import java.util.Date;

public class OrderServiceImpl implements OrderService {
  private OrderDao orderDao = new OrderDaoImpl();
  private OrderItemDao orderItemDao = new OrderItemImpl();
  private BookDao bookDao = new BookDaoimpl();
  @Override
  public String createOrder(Cart cart, Integer id) {
    String orderId = System.currentTimeMillis()+id+"";
    Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,id);
    orderDao.saveOrder(order);
    Collection<CartItem> items = cart.getItems().values();
    for (CartItem item : items) {
      Book book = bookDao.queryById(item.getId());
      book.setSales(item.getCount()+book.getSales());
      book.setStock(book.getStock()-item.getCount());
      bookDao.updateBook(book);
      OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
      orderItemDao.saveOrderItem(orderItem);
    }
    cart.clear();
    return orderId;
  }
}
