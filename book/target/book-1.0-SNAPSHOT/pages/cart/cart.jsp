<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
  <%@include file="/pages/common/head.jsp"%>
  <script type="text/javascript">
    $(function () {
      $("a.deleteItem").click(function () {
        return confirm("你确定要删除《"+$(this).parent().parent().find("td:first").text()+"》吗?")
      })

      $("a.clearAll").click(function () {
        return confirm("你确定要清空购物车吗?")
      })

      $("input.updateItem").change(function () {
        var bookId = $(this).attr("bookId");
        var count = $(this).val();
        if(confirm("你确定将《"+$(this).parent().parent().find("td:first").text()+"》的数量修改为"+$(this).val()+"吗?")){
          location.href = "http://localhost:8080/book/cartServlet?action=updateCount&id="+bookId+"&count="+count;

        }else {
          this.value = this.defaultValue;
        }


      })
    })
  </script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
    <%@ include file="/pages/common/login_success_menu.jsp"%>
	</div>

	<div id="main">

		<table>
      <tr>
        <td>商品名称</td>
        <td>数量</td>
        <td>单价</td>
        <td>金额</td>
        <td>操作</td>
      </tr>

      <c:if test="${empty sessionScope.cart.items}">
        <tr>
          <td colspan="5"><a href="index.jsp">当前购物车为空，快给老子去买</a> </td>

        </tr>


      </c:if>

      <c:if test="${not empty sessionScope.cart.items}">


      <c:forEach items="${sessionScope.cart.items}" var="entry">

        <tr>
          <td>${entry.value.name}</td>
          <td><input class="updateItem" bookId="${entry.value.id}" style="width: 80px" type="text" value="${entry.value.count}"></td>
          <td>${entry.value.price}</td>
          <td>${entry.value.totalPrice}</td>
          <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
        </tr>



      </c:forEach>

		</table>


      <div class="cart_info">
        <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
        <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
        <span class="cart_span"><a class="clearAll" href="cartServlet?action=clear">清空购物车</a></span>
        <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
      </div>
    </c:if>

	</div>

	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>
