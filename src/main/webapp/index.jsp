<%--
  Created by IntelliJ IDEA.
  User: 张小帅
  Date: 2020/2/12
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">查询所有账户信息</a><br/>
    <form action="account/save" method="post">
        姓名:<input type="text" name="name"/><br/>
        金额:<input type="text" name="money"/><br/>
        <input type="submit" value="保存"/><br/>
    </form><br/>

    <form action="account/delete" method="post">
        要删除的账户ID:<input type="number" name="id"/>
        <input type="submit" value="删除"/><br/>
    </form><br/>

    <form action="account/update" method="post">
        ID: <input type="number" name="id"/><br/>
        姓名:<input type="text" name="name"/><br/>
        金额:<input type="text" name="money"/><br/>
        <input type="submit" value="保存"/><br/>
    </form><br/>
</body>
</html>
