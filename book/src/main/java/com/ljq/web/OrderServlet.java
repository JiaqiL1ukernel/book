package com.ljq.web;

import com.ljq.pojo.Cart;
import com.ljq.pojo.User;
import com.ljq.service.OrderService;
import com.ljq.service.impl.OrderServiceImpl;
import com.ljq.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{

  private OrderService orderService = new OrderServiceImpl();
  protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cart cart = (Cart) req.getSession().getAttribute("cart");

    User loginUser = (User) req.getSession().getAttribute("user");

    if(loginUser==null){
      req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
      return;
    }

    Integer id = loginUser.getId();

    String orderId = orderService.createOrder(cart, id);

    req.getSession().setAttribute("orderId",orderId);
    resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
  }
}
