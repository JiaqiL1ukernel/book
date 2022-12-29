package com.ljq.web;

import com.google.gson.Gson;
import com.ljq.pojo.Book;
import com.ljq.pojo.Cart;
import com.ljq.pojo.CartItem;
import com.ljq.service.BookService;
import com.ljq.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet{
  private BookService bookService = new BookServiceImpl();

  protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
    Book book = bookService.queryBookById(id);
    CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());
    Cart cart = (Cart)req.getSession().getAttribute("cart");
    if (cart==null){
      cart = new Cart();
      req.getSession().setAttribute("cart",cart);
    }
    cart.addItem(cartItem);
    req.getSession().setAttribute("lastItem",cartItem.getName());
    resp.sendRedirect(req.getHeader("Referer"));
  }



  protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cart cart = (Cart) req.getSession().getAttribute("cart");
    Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
    Book book = bookService.queryBookById(id);
    CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());

    if(cart!=null) {
      cart.deleteItem(id);
    }
    resp.sendRedirect(req.getHeader("Referer"));


  }



  protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cart cart = (Cart) req.getSession().getAttribute("cart");
    if(cart!=null){
      cart.clear();
    }
    resp.sendRedirect(req.getHeader("Referer"));
  }

  protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cart cart = (Cart) req.getSession().getAttribute("cart");
    Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
    Integer count = WebUtils.parseInt(req.getParameter("count"), 0);
    if(cart!=null){
      cart.updateItemCount(id,count);
    }
    resp.sendRedirect(req.getHeader("Referer"));
  }


  protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
    Book book = bookService.queryBookById(id);
    CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());
    Cart cart = (Cart)req.getSession().getAttribute("cart");
    if (cart==null){
      cart = new Cart();
      req.getSession().setAttribute("cart",cart);
    }
    cart.addItem(cartItem);

    Map<String,Object> resultMap = new HashMap<>();
    resultMap.put("totalCount",cart.getTotalCount());
    resultMap.put("lastItem",cartItem.getName());

    Gson gson = new Gson();
    String json = gson.toJson(resultMap);
    resp.getWriter().write(json);


  }

}
