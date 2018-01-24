<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/23
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--个人中心，支持修改密码、收件人信息等-->
<html>
<head>
    <title>个人中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="index/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="index/css/style.css">
    <script type="text/javascript" src="index/js/jquery.min.js"></script>
    <script type="text/javascript" src="index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="index/js/simpleCart.min.js"></script>
    <link rel="stylesheet" href="index/css/header.css">
    <script src="index/js/header.js"></script>
    <script src="index/js/goods.js"></script>
</head>
<body>
<%--引入头部--%>
<jsp:include page="herder.jsp"/>
<!--account-->
<div class="account">
    <div class="container">
        <div class="register">

            <form action="my.action" method="post">
                <input type="hidden" name="user.id" value="1">
                <div class="register-top-grid">
                    <h3>个人中心</h3>

                    <h4>收货信息</h4>
                    <div class="input">
                        <span>收货人<label></label></span>
                        <input type="text" name="user.name" value="Philip" placeholder="请输入收货">
                    </div>
                    <div class="input">
                        <span>收货电话</span>
                        <input type="text" name="user.phone" value="12345678999" placeholder="请输入收货电话">
                    </div>
                    <div class="input">
                        <span>收货地址</span>
                        <input type="text" name="user.address" value="陕西西安" placeholder="请输入收货地址">
                    </div>
                    <div class="register-but text-center">
                        <input type="submit" value="提交">
                    </div>
                    <hr>
                    <h4>安全信息</h4>
                    <div class="input">
                        <span>原密码</span>
                        <input type="text" name="user.password" placeholder="请输入原密码">
                    </div>
                    <div class="input">
                        <span>新密码</span>
                        <input type="text" name="user.passwordNew" placeholder="请输入新密码">
                    </div>
                    <div class="clearfix"> </div>
                    <div class="register-but text-center">
                        <input type="submit" value="提交">
                    </div>
                </div>
            </form>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>

<!--底部页面需要引入-->
<jsp:include page="footer.jsp"/>
<!--//account-->
</body>
</html>
