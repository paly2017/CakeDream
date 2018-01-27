<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户添加</title>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>

</head>
<body>
<%--<head>--%>
<jsp:include page="header.jsp"/>
<%--</head>--%>

<br><br>
<form class="form-horizontal" action="userSave" method="post">
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">用户名</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name" name="user_username" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="input_name1" class="col-sm-1 control-label">密码</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name1" name="user_password" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="input_name2" class="col-sm-1 control-label">收货人姓名</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name2" name="user_name" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="input_name3" class="col-sm-1 control-label">电话</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name3" name="user_phone" >
        </div>
    </div>
    <div class="form-group">
        <label for="input_name4" class="col-sm-1 control-label">地址</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name4" name="user_address" >
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
            <button type="submit" class="btn btn-success">提交保存</button>
        </div>
    </div>
</form>

<span style="color:red;"></span>
</body>
</html>
