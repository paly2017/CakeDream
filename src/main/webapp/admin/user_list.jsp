<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户列表</title>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
</head>
<body>
<%--<head>--%>
<jsp:include page="header.jsp"/>
<%--</head>--%>


<div class="text-right"><a class="btn btn-warning" href="userAdd">添加客户</a></div>

<br>

<table class="table table-bordered table-hover">

    <tr>
        <th width="5%">ID</th>
        <th width="10%">用户名</th>
        <th width="10%">电话</th>
        <th width="10%">地址</th>
        <th width="10%">操作</th>
    </tr>
    <c:forEach  items="${sessionScope.userList}" var="user">
        <tr>
            <td><p align="center">${user.id}</p></td>
            <td><p align="center">${user.username}</p></td>
            <td><p align="center">${user.phone}</p></td>
            <td><p align="center">${user.address}</p></td>
            <td>
                <!--进入重置客户密码页面-->
                <a class="btn btn-info" href="userReset?userId=${user.id}">重置密码</a>
                <!--进入客户信息（电话、地址等）修改页面-->
                <a class="btn btn-primary" href="userEdit?userId=${user.id}">修改信息</a>
                <!--删除完信息之后在页面刷新显示-->
                <a class="btn btn-danger" href="userList?userId=${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>

</table>

<br><div style='text-align:center;'>
    <a class='btn btn-info' disabled >〈首页</a>
    <a class='btn btn-info' disabled >〈上一页</a>
    <h2 style='display:inline;'>[1/1]</h2>
    <h2 style='display:inline;'>[0]</h2>
    <a class='btn btn-info' disabled >下一页〉</a>
    <a class='btn btn-info' disabled >最后一页〉</a>
    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="http://localhost:8080/ssh_cake/admin/userList.action?page="+(this.previousSibling.value)+""'>GO</a>
</div>

<br>
</body>
</html>
