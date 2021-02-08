<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br />
<label>验证码：&nbsp;</label>
<input class="itxt" type="text" style="width: 120px;" id="code" name="code" value="${requestScope.code}"/>
<img id="code_listener" alt="" src="http://localhost:8080/kaptcha.jpg" style="float: right; margin-right: 40px;width: 100px;height: 35px">
<br/>
