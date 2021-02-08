<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="../jspBase/commonLink.jsp"%>
    <script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>

</head>
<body>
<div id="header">
    <%@include file="../jspBase/header.jsp"%>
    <span class="wel_word">订单详情</span>

    <%--静态包含，登录 成功之后的菜单 --%>
    <div> <span class="um_span"></span>
        <%@include file="../jspBase/user_index.jsp"%>
   </div>
<div id="main">
    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>总价</td>
        </tr>

        <c:if test="${empty sessionScope.orderInf}">
            <%--如果购物车空的情况--%>
            <tr>
                <td colspan="5"><a href="../../index.jsp">尊敬的“${sessionScope.user1.getUsername()}”您好，当前您的订单为空！欢迎您前去选购商品！！！</a> </td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.orderInf}">
            <%--如果购物车非空的情况--%>
            <c:forEach items="${sessionScope.orderItemInf}" var="items">
               <tr>
                   <td>${items.getName()}</td>
                   <td>${items.getCount()}</td>
                   <td>${items.getPrice()}</td>
                   <td>${items.getTotalPrice()}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

</div>
</body>
<%--静态包含页脚内容--%>
<%@include file="/pages/jspBase/foot.jsp"%>
</html>