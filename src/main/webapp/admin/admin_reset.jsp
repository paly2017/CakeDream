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
</head>
<body>
<jsp:include page="header.jsp"/>
<br><br>

<form class="form-horizontal" action="adminReset.action" method="post">
    <input type="hidden" name="admin.id" value="1">
    <input type="hidden" name="admin.username" value="1">
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">用户名</label>
        <input id="input_name">
        <div class="col-sm-5">1</div>
    </div>
    <div class="form-group">
        <label for="input_pass1" class="col-sm-1 control-label">原密码</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="input_pass1" name="admin.password" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="input_pass2" class="col-sm-1 control-label">新密码</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="input_pass2" name="admin.passwordNew" required="required">
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
