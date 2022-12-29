package com.example.servlet_08;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet5 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("经过servlet程序处理");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/a/b/c.html");
    requestDispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
