package com.ljq.web;

import com.ljq.pojo.Book;
import com.ljq.pojo.Page;
import com.ljq.service.BookService;
import com.ljq.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
  private BookService bookService = new BookServiceImpl();
  protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
    Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

    Page<Book> page = bookService.page(pageNo, pageSize);

    page.setUrl("client/clientBookServlet?action=page");

    req.setAttribute("page",page);

    req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

  }






  protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
    Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
    Integer min = WebUtils.parseInt(req.getParameter("min"), 0);
    Integer max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

    Page<Book> page = bookService.page(pageNo, pageSize,min,max);

    StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");
    if(req.getParameter("min")!=null){
      sb.append("&min=").append(req.getParameter("min"));
    }
    if(req.getParameter("max")!=null){
      sb.append("&max=").append(req.getParameter("max"));
    }

    page.setUrl(sb.toString());

    req.setAttribute("page",page);

    req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

  }







}
