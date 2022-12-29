package com.ljq.web;

import com.google.gson.Gson;
import com.ljq.pojo.User;
import com.ljq.service.impl.UserServiceimpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
  protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    UserServiceimpl userService = new UserServiceimpl();
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    User login = userService.login(username,password);
    if(login==null){

      req.setAttribute("msg","用户名或密码错误！");
      req.setAttribute("username",username);
      req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
    }else {
      req.getSession().setAttribute("user",login);
      req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
    }
  }



  protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    UserServiceimpl userService = new UserServiceimpl();
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String email = req.getParameter("email");
    String code = req.getParameter("code");

    User user1 = WebUtils.copyParaToBean(req.getParameterMap(), new User());

    String token =(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
    req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


    if(token!=null && token.equalsIgnoreCase(code)){

      if(!userService.existUsername(username)){
        User user = new User(0, username, password, email);
        userService.registUser(user);
        req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
      }else {
        req.setAttribute("username",username);
        req.setAttribute("email",email);
        req.setAttribute("msg","用户名已存在！");
        req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
      }
    }else {
      req.setAttribute("username",username);
      req.setAttribute("email",email);
      req.setAttribute("msg","验证码错误！");
      req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

    }

  }

  protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getSession().invalidate();

    resp.sendRedirect(req.getContextPath());
  }

  protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");

    UserServiceimpl userServiceimpl = new UserServiceimpl();
    boolean b = userServiceimpl.existUsername(username);

    HashMap<String, Object> resultMap = new HashMap<>();
    resultMap.put("existUsername",b);

    Gson gson = new Gson();
    String json = gson.toJson(resultMap);

    resp.getWriter().write(json);

  }
}
