package com.example.servlet_08;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

public class Servlet2 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("用户名："+request.getParameter("username"));
    System.out.println("密码："+request.getParameter("password"));
    System.out.println("兴趣爱好："+ Arrays.asList(request.getParameterValues("hobby")));
    System.out.println("客户端IP地址：  "+request.getRemoteHost());
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
