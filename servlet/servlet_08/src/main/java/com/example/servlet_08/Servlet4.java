package com.example.servlet_08;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet4 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    Object value1 = request.getAttribute("value1");
    System.out.println("value1 = "+value1);
    System.out.println("sevlet4处理完毕！");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
