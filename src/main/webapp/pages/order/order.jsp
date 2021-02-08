<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@ include file="../jspBase/commonLink.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
		<%@include file="../jspBase/header.jsp"%>
		<span class="wel_word">我的订单</span>
		<div>
			<%@include file="../jspBase/user_index.jsp"%>
		</div>
	</div>


	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:if test="${not empty sessionScope.orderInf}">
				<%--如果购物车非空的情况--%>

					<tr>
						<td>${sessionScope.orderInf.getCreateTime()}</td>
						<td>
							<c:if test="${sessionScope.orderInf.getStatus()==0}">
								未发货
							</c:if>
							<c:if test="${sessionScope.orderInf.getStatus()==1}">
								已发货
							</c:if>
							<c:if test="${sessionScope.orderInf.getStatus()==-1}">
								已签收
							</c:if>
						</td>
						<td><a href="../../pages/order/orderInf.jsp">查看详情</a></td>
					</tr>

			</c:if>
		</table>
		
	
	</div>
	
	<%@include file="../jspBase/foot.jsp"%>
</body>
</html>