<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-1-24
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="">蛋糕店后台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/orderlist?index=0">订单管理</a></li>
                <li ><a href="userList.action">客户管理</a></li>
                <li ><a href="/allGood">商品管理</a></li>
                <li ><a href="typeList.action">类目管理</a></li>
                <li ><a href="adminRe.action">修改密码</a></li>
                <li><a href="logout.action">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
