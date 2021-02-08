<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<	<%@ include file="../jspBase/commonLink.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body class="by2">
	
	<div id="header">
			<%@include file="../jspBase/header.jsp"%>
			<span class="wel_word">后台管理系统</span>
			<div>
				<%@include file="../jspBase/manage.jsp"%>
			</div>
	</div>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<%@include file="../jspBase/foot.jsp"%>
</body>
</html>