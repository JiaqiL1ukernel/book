package com.example.servlet;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet implements Servlet {
  @Override
  public void init(ServletConfig servletConfig) throws ServletException {
    String servletName = servletConfig.getServletName();
    System.out.println("servletName是"+servletName);
    String username = servletConfig.getInitParameter("username");
    System.out.println("初始化参数username是"+username);

  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    System.out.println("响应成功！");
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {

  }
}
