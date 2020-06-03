<%--
  Created by IntelliJ IDEA.
  User: 张小帅
  Date: 2020/2/4
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--查询所有账户的链接--%>
    <a href="account/findAll">点我查看所有账户信息</a><br/>
    <%--保存账户信息的表单--%>
    <h3 style="color: darkblue">新增账户</h3><br/>
    <form  action="account/save" method="post">
        姓名：<input type="text" name="name"/><br/>
        金额：<input type="text" name="money"/><br/>
        <input type="submit" value="保存"/><br/>
    </form><br/>

    <%--根据id删除账户--%>
    <h3 style="color: darkblue">删除账户</h3><br/>
    <form action="account/delete" method="post">
        输入需要删除的账户id：<input type="text" name="id"/>
        <input type="submit" value="删除"><br/>
    </form><br/>

    <%--更新账户信息--%>
    <h3 style="color: darkblue">更新账户</h3><br/>
    <form action="account/update" method="post">
        id ：<input type="number" name="id"/><br/>
        姓名：<input type="text" name="name"/><br/>
        金额：<input type="number" name="money"/><br/>
        <input type="submit" value="更新"/><br/>
    </form><br/>
</body>
</html>
