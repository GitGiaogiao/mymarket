<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑</title>
	<%@ include file="../jspBase/commonLink.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body class="by2">
		<div id="header">
			<%@ include file="../jspBase/header.jsp"%>
			<span class="wel_word">编辑</span>
			<div>
				<%@include file="../jspBase/manage.jsp"%>
			</div>
		</div>
		
		<div id="main">
			<form action="http://localhost:8080/commodity1Servlet" method="get">
				<input type="hidden" name="action" value="update"/>
				<input type="hidden" name="id" value="${ requestScope.commodity.getId() }" />
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>销量</td>
						<td>库存</td>
						<td>图片</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.commodity.getName()}"/></td>
						<td><input name="price" type="text" value="${requestScope.commodity.getPrice()}"/></td>
						<td><input name="sales" type="text" value="${requestScope.commodity.getSales()}"/></td>
						<td><input name="stock" type="text" value="${requestScope.commodity.getStock()}"/></td>
						<td><input name="img_path" type="text" value="${requestScope.commodity.getImg_path()}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>

		<%@include file="../jspBase/foot.jsp"%>
</body>
</html>