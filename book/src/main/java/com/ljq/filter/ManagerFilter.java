package com.ljq.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManagerFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse resp = (HttpServletResponse) servletResponse;
    Object user = req.getSession().getAttribute("user");
    if(user == null){
      req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
      return;
    }else {
      filterChain.doFilter(req,resp);
    }

  }

  @Override
  public void destroy() {

  }
}
