<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>YS百货商城</title>
	<%@include file="../jspBase/indexLink.jsp"%>
	<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
	<Script type="text/javascript">
        $(function () {
            // 给加入购物车按钮绑定单击事件
            $("button.addToCart").click(function () {
               //href映射到cartServlet的addItem功能上面
                alert("添加成功！！");
                var commodityId = $(this).attr("commodityId");
                location.href = "http://localhost:8080/cartServlet?action=addItem&id=" + commodityId;
            });
        });
	</Script>
</head>
<body>
<div id="header">
	<%@ include file="../jspBase/header.jsp"%>
	<div>
		<%--如果session域中没有用户信息，那么现实注册页面--%>
		<c:if test="${empty sessionScope.user1.getUsername()}">
			<a href="pages/user/login.jsp">登录</a> |
			<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
			<a href="pages/manager/manager.jsp">后台管理</a>
		</c:if>

		<c:if test="${not empty sessionScope.user1.getUsername()}">
			<%@ include file="../jspBase/user_index.jsp"%>
		</c:if>

	</div>

</div>
<div id="main">
	<%int count=0;%>
		<c:forEach items="${requestScope.page}" var="commodity">
			<% count++;%>
			<%request.setAttribute("count",count);%>
			<div class="b_list">
				<div class="img_div">
					<img class="commodity_img" alt="" src="${commodity.getImg_path()}" />
				</div>
				<div class="commodity_info">
					<div class="commodity_name">
						<span class="sp1">商品名:</span>
						<span class="sp2">${commodity.getName()}</span>
					</div>
					<div class="commodity_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${commodity.getPrice()}</span>
					</div>
					<div class="commodity_sales">
						<span class="sp1">销量:</span>
						<span class="sp2">${commodity.getSales()}</span>
					</div>
					<div class="commodity_amount">
						<span class="sp1">库存:</span>
						<span class="sp2">${commodity.getStock()}</span>
					</div>
					<div class="commodity_add">
						<button commodityId="${commodity.getId()}" class="addToCart">加入购物车</button>
					</div>
				</div>
			</div>
			<c:if test="${requestScope.count%3==0}">
				</br>
				</br>
				<div>&nbsp;</div>
			</c:if>
		</c:forEach>
	</div>
</div>

</body>
</div>
<footer><%@include file="../jspBase/foot.jsp"%></footer>
</div>
</html>