<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类目列表</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<br>

<div>
    <form class="form-inline" method="post" action="typeSave.action">
        <input type="text" class="form-control" id="input_name" name="type.name" placeholder="输入类目名称" required="required" style="width: 500px">
        <input type="submit" class="btn btn-warning" value="添加类目"/>
    </form>
</div>

<br>

<table class="table table-bordered table-hover">

    <tr>
        <th width="5%">ID</th>
        <th width="10%">名称</th>
        <th width="10%">操作</th>
    </tr>


    <tr>
        <td><p>5</p></td>
        <td><p>经典系列</p></td>
        <td>
            <a class="btn btn-primary" href="typeEdit.action?id=5">修改</a>
            <a class="btn btn-danger" href="typeDelete.action?type.id=5">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>4</p></td>
        <td><p>法式系列</p></td>
        <td>
            <a class="btn btn-primary" href="typeEdit.action?id=4">修改</a>
            <a class="btn btn-danger" href="typeDelete.action?type.id=4">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>3</p></td>
        <td><p>儿童系列</p></td>
        <td>
            <a class="btn btn-primary" href="typeEdit.action?id=3">修改</a>
            <a class="btn btn-danger" href="typeDelete.action?type.id=3">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>2</p></td>
        <td><p>零食系列</p></td>
        <td>
            <a class="btn btn-primary" href="typeEdit.action?id=2">修改</a>
            <a class="btn btn-danger" href="typeDelete.action?type.id=2">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>1</p></td>
        <td><p>冰淇淋系列</p></td>
        <td>
            <a class="btn btn-primary" href="typeEdit.action?id=1">修改</a>
            <a class="btn btn-danger" href="typeDelete.action?type.id=1">删除</a>
        </td>
    </tr>


</table>
</body>
</html>
