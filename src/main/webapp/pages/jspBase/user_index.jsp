<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <span class="um_span">${sessionScope.user1.getUsername()}</span>
    <a href="../../pages/cart/cart.jsp">购物车</a>
    <a href="http://localhost:8080/orderServlet?action=infOrder">我的订单</a>
    <a href="../../pages/manager/manager.jsp">后台管理</a>
    <a href="http://localhost:8080/user1Servlet?action=logout">注销</a>
