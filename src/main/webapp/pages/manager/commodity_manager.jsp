<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
	<%@ include file="../jspBase/commonLink.jsp"%>
	<script type="text/javascript">
        $(function () {
            // 给删除的a标签绑定单击事件，用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                // 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个确认，一个是取消。
                 * 返回true表示点击了，确认，返回false表示点击取消。
                 */
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
                // return false// 阻止元素的默认行为===不提交请求
            });
        });
	</script>
</head>
<body class="by2">

<div id="login_header">
	<%@include file="../jspBase/header.jsp"%>
	<span class="wel_word">商品管理系统</span>
	<%@include file="../jspBase/manage.jsp"%>
</div>


			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>销量</td>
				<td>库存</td>
			</tr>
			<c:forEach items="${requestScope.lists}" var="list">
				<tr>
					<td>${list.getName()}</td>
					<td>${list.getPrice()}</td>
					<td>${list.getSales()}</td>
					<td>${list.getStock()}</td>
                    <td><a href="http://localhost:8080/commodity1Servlet?action=getInformation&id=${list.getId()}">修改</a></td>
					<td><a href="http://localhost:8080/commodity1Servlet?action=delete&id=${list.getId()}">删除</a></td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/commodity_add.jsp">添加商品</a></td>
			</tr>	
		</table>
	</div>

	<%@include file="../jspBase/foot.jsp"%>
</body>
</html>