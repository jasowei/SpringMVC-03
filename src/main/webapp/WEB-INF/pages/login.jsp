<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/10
  Time: 上午9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>登录</h1>
<form action="/login" method="post">
    user:
    <input type="text" name="uname" placeholder="请输入用户名">${uerror.defaultMessage}
    <br>
    pwd:
    <input type="password" name="pwd" placeholder="请输入密码">${perror.defaultMessage}
    <br>
    <br>
    <input type="submit" value="login">

</form>
<h5>${msg}</h5>
<h3>信息提示</h3>
<c:if test="${errors != null and errors.size()>0}">
    <c:forEach items="${errors}" var="error">
        ${error.defaultMessage}
    </c:forEach>
</c:if>
</body>
</html>
