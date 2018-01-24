<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-1-24
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="admin/css/bootstrap.css">
</head>

<!-- 设置背景图片 -->
<body style="background-image:url(admin/img/bg.jpg);background-size:100%;">

<div class="container">

    <div class="alert alert-danger text-center"></div>

    <form class="form-horizontal" style="margin-top:15%;" action="/adminlogin" method="post">
        <h2 class="text-center">登录后台</h2>
        <div class="form-group">
            <div class="col-md-4 col-md-offset-4">
                <input type="text" class="form-control" style="height:auto;padding:10px;" placeholder="输入用户名" name="admin.username" value="1">
            </div>
        </div>
        <div class="form-group">
            <div class="col-md-4 col-md-offset-4">
                <input type="password" class="form-control" style="height:auto;padding:10px;" placeholder="输入密码" name="admin.password" value="1">
            </div>
        </div>
        <div class="col-md-4 col-md-offset-4">
            <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        </div>
    </form>

</div>

</body>
</html>
