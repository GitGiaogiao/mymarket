<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="welc">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span class="um_span">${sessionScope.user1.getUsername()}</span>
    <a href="http://localhost:8080/orderServlet?action=infOrder">我的订单</a>
    <a href="http://localhost:8080/user1Servlet?action=logout">注销</a>
    <a href="index.jsp">返回</a>
</div>
