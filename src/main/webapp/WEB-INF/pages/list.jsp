<%--
  Created by IntelliJ IDEA.
  User: 张小帅
  Date: 2020/2/4
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3 style="color: aqua">所有账户信息</h3>
    <c:forEach items="${accounts}" var="account">
        ${account.toString()}<br/>
    </c:forEach>

    <a href="/ssm/">返回主页</a>
</body>
</html>
