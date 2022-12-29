package com.example.servlet_08;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet3 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    System.out.println("username = "+username);
    request.setAttribute("value1",username);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet4");
    requestDispatcher.forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
