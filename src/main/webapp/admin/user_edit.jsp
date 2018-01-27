<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户修改</title>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<br><br>

<form class="form-horizontal" action="userEditOK?userId=${user.id}" method="post">
    <input type="hidden" name="user.id" value="1">
    <input type="hidden" name="user.username" value="1">
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">用户名</label>
        <div class="col-sm-5">${sessionScope.user.username }</div>
    </div>
    <div class="form-group">
        <label for="input_name1" class="col-sm-1 control-label">电话</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name1" name="user_phone" value="">
        </div>
    </div>
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">地址</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name" name="user_address" value="">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
            <button type="submit" class="btn btn-success">提交修改</button>
        </div>
    </div>
</form>

<span style="color:red;"></span>
</body>
</html>
