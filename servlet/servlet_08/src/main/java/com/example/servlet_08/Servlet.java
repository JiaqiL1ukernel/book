package com.example.servlet_08;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("URL = "+request.getRequestURL());
    System.out.println("URI = "+request.getRequestURI());
    System.out.println("客户端ip地址 = "+request.getRemoteHost());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
