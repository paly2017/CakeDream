<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>类目列表</title>
    <meta http-equiv="Content-Type" content="text/jsp; charset=utf-8">
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
    <script src="admin/js/jquery.js"></script>
    <script src="admin/js/type.js"></script>



</head>
<body>
<jsp:include page="header.jsp"/>
<br>
<div>
    <form class="form-inline" method="post" action="/addtype">
        <input type="text" class="form-control" id="input_name" name="type.name" placeholder="输入类目名称" required="required" style="width: 500px">
        <input type="submit" id="but" class="btn btn-warning" value="添加类目"/>
    </form>
</div>

<br>

<table class="table table-bordered table-hover" width="60%">
    <div id="table">
    <tr>
        <th width="5%">ID</th>
        <th width="10%">名称</th>
        <th width="10%">操作</th>
    </tr>

    <c:forEach var="type" items="${requestScope.typegood}">
    <tr>
        <td><p>${type.id}</p></td>
        <td><p>${type.name}</p></td>
        <td>
            <a class="btn btn-primary" onclick="changeType(${type.id})" >修改</a>
            <a class="btn btn-danger" onclick="deteleType(${type.id})">删除</a>
        </td>
    </tr>
    </c:forEach>
    </div>
</table>
</body>
</html>
