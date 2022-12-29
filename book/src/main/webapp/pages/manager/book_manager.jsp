<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
  <%@include file="/pages/common/head.jsp"%>
  <script type="text/javascript">
    $(function () {
      $("a.deleteClass").click(function () {
         return confirm("你确定要删除"+$(this).parent().parent().find("td:first").text()+"吗？");
      })
    })

  </script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<div>
				<a href="book_manager.jsp">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="../../index.jsp">返回商城</a>
			</div>
	</div>

	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
    <c:forEach items="${requestScope.page.items}" var="book">
      <tr>
        <td>${book.name}</td>
        <td>${book.price}</td>
        <td>${book.author}</td>
        <td>${book.sales}</td>
        <td>${book.stock}</td>
        <td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update&pageNo=${requestScope.page.pageNo}">修改</a></td>
        <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
      </tr>
    </c:forEach>



			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>
		</table>
    <%@include file="/pages/common/page_nav.jsp"%>
	</div>

	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>
