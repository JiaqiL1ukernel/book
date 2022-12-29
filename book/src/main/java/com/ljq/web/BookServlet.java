package com.ljq.web;

import com.ljq.pojo.Book;
import com.ljq.pojo.Page;
import com.ljq.service.BookService;
import com.ljq.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BookServlet extends BaseServlet{

  private BookService bookService = new BookServiceImpl();
  protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String pageNo = req.getParameter("pageNo");
    int page = WebUtils.parseInt(pageNo, 1) + 1;
    Book book = WebUtils.copyParaToBean(req.getParameterMap(), new Book());
    bookService.addBook(book);
    resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+page);

  }

  protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String id = req.getParameter("id");

    bookService.deleteBookById(Integer.parseInt(id));

    resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

  }

  protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      Book book = WebUtils.copyParaToBean(req.getParameterMap(), new Book());
      bookService.updateBook(book);
      resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Book> books = bookService.queryBooks();
    req.setAttribute("books",books);
    req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
  }


  protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String id = req.getParameter("id");

    Book book = bookService.queryBookById(Integer.parseInt(id));

    req.setAttribute("book",book);

    req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);


  }


  protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
    Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

    Page<Book> page = bookService.page(pageNo, pageSize);

    page.setUrl("manager/bookServlet?action=page");

    req.setAttribute("page",page);

    req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

  }
}
