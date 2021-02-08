<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>潍柴会员登录页面</title>
	<%@ include file="../jspBase/commonLink.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body class="by3">
<div id="login_header">
	<%@include file="../jspBase/header.jsp"%>
</div>
<%@ include file="../jspBase/userWelc.jsp"%>
		
		<div id="main">
			<h1>登录成功！</font> <a href="../../index.jsp">转到主页</a></h1>
		</div>

<%@include file="../jspBase/foot.jsp"%>
</body>
</html>