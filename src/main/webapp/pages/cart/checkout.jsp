<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
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
		<%@ include file="../jspBase/header.jsp"%>
			<span class="wel_word">结算</span>
			<div>
				<span class="um_span">${sessionScope.user1.getUsername()}</span>
				<a href="../order/order.jsp">我的订单</a>
				<a href="http://localhost:8080/user1Servlet?action=logout">注销</a>
				<a href="../../index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为${sessionScope.orderId}</h1>
		
	
	</div>
	
	<%@include file="../jspBase/foot.jsp"%>
</body>
</html>