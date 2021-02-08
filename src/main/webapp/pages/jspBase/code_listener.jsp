<%@ page contentType="text/html;charset=UTF-8" language="java" %>
$(function () {
$("#code_listener").click(function () {
this.src="${basePath}http://localhost:8080/kaptcha.jpg?d="+new Date();
});
})