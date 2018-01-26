<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置密码</title>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
</head>
<body>
<%--<head>--%>
<jsp:include page="header.jsp"/>
<%--</head>--%>
<br><br>

<form class="form-horizontal" action="userResetChange?userId=${user.id}" method="post">
    <input type="hidden" name="user.id" value="1">
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">用户名</label>
        <div class="col-sm-5">${user.username }</div>
    </div>
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">密码</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name" name="user_password" value="" required="required">
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
