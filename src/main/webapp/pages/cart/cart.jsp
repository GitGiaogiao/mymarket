<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="../jspBase/commonLink.jsp"%>
	<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>

</head>
<body>
	<div id="header">
			<%@include file="../jspBase/header.jsp"%>
			<span class="wel_word">购物车</span>

		<%--静态包含，登录 成功之后的菜单 --%>
        <div> <span class="um_span">${sessionScope.user1.getUsername()}</span>
			<a href="../order/order.jsp">我的订单</a>
			<a href="../manager/manager.jsp">后台管理</a>
			<a href="http://localhost:8080/user1Servlet?action=logout">注销</a></div>

		<script type="text/javascript">
			$(function () {
				// 给 【删除】绑定单击事件
				$("a.deleteItem").click(function () {
					return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() +"】吗?")
				});
				// 给清空购物车绑定单击事件
				$("#clearCart").click(function () {
					return confirm("你确定要清空购物车吗?");
				})
				// 给输入框绑定 onchange内容发生改变事件
				$(".updateCount").change(function () {
					// 获取商品名称
					var name = $(this).parent().parent().find("td:first").text();
					// 将商品的commoditId转换为jQuery对象
					var id = $(this).attr('commodityId');
					// 获取商品数量
					var count = this.value;
					if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) {
						//发起请求。给服务器保存修改
						location.href = "http://localhost:8080/cartServlet?action=updateCount&count="+count+"&id="+id;
					} else {
						// defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
						this.value = this.defaultValue;
					}
				});

			});
		</script>
	</div>
	<span class="errorMsg">${ empty requestScope.msg ? "":requestScope.msg }</span>
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
				<%--如果购物车空的情况--%>
				<tr>
					<td colspan="5"><a href="../../index.jsp">尊敬的“${sessionScope.user1.getUsername()}”您好，当前购物车为空！欢迎您前去选购商品！！！</a> </td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<%--如果购物车非空的情况--%>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.getName()}</td>
						<td>
							<input class="updateCount" style="width: 80px;"
								   <%--获取商品id--%>
								   commodityId="${entry.value.getId()}"
								   type="text" value="${entry.value.getCount()}">
						</td>
						<td>${entry.value.getPrice()}</td>
						<td>${entry.value.getTotalPrice()}</td>
						<td><a class="deleteItem" href="http://localhost:8080/cartServlet?action=deleteItem&id=${entry.value.getId()}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<%--如果购物车非空才输出页面的内容--%>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.getTotalCount()}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.getTotalPrice()}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="http://localhost:8080/cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="http://localhost:8080/orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	
	</div>
</body>
<%--静态包含页脚内容--%>
<%@include file="/pages/jspBase/foot.jsp"%>
</html>