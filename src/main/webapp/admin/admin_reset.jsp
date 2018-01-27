<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-1-24
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <meta charset="utf-8"/>
    <%-- //jq--%>
    <script src="admin/js/jquery.js"></script>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>

    <%--//validate--%>
    <script src="index/js/jquery.validate.js"></script>
    <script src="index/js/additional-methods.js"></script>
    <script src="index/js/jquery.validate.min.js"></script>
    <script src="index/js/messages_zh.js"></script>
    <script src="admin/js/admin_reset.js"></script>
<style>
    .error{
        color: red;
    }
</style>


</head>
<body>
<jsp:include page="header.jsp"/>
<br><br>

<form  id="adminForm" class="form-horizontal" action="/reAdmin" method="post">
    <input type="hidden" name="admin.id" value="1">
    <input type="hidden" name="admin.username" value="1">
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">用户名</label>
        <input type="hidden" id="input_name">
        <div id="username" class="col-sm-5">${admin.username}</div>
    </div>
    <div class="form-group">
        <label for="input_pass1"  class="col-sm-1 control-label">原密码</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="input_pass1" name="password" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="input_pass2" class="col-sm-1 control-label">新密码</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="input_pass2" name="passwordNew" required="required">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
            <button id="adminSub" type="submit" class="btn btn-success">提交修改</button>
        </div>
    </div>
</form>

<span style="color:red;"></span>


</body>
</html>
