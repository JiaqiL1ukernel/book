<%--
  Created by IntelliJ IDEA.
  User: 86191
  Date: 2022/12/25
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <base href="http://localhost:8080/book/">
</head>
<body>
<div>
  <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
  <a href="pages/order/order.jsp">我的订单</a>
  <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
  <a href="">返回</a>
</div>
</body>
</html>
