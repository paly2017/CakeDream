
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="index/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="index/css/style.css">
    <script type="text/javascript" src="index/js/jquery.min.js"></script>
    <script src="index/js/bootstrap.min.js"></script>
    <script src="index/js/jquery.min.js"></script>
    <!-- validate插件-->

    <script src="index/js/jquery.validate.js"></script>
    <script src="index/js/additional-methods.js"></script>
    <script src="index/js/jquery.validate.min.js"></script>
    <script src="index/js/messages_zh.js"></script>
    <script src="index/js/Register.js"></script>
    <!-- //结束-->
    <!--css样式，，，错误提示显示红色-->
    <style>
        .error{
            color: red;
        }
    </style>
    <link rel="stylesheet" href="index/css/header.css">
    <script src="index/js/header.js"></script>
</head>
<body>
<%--引入头部--%>
    <jsp:include page="herder.jsp"/>

    <%--注册页面--%>
<div class="account">
    <div class="container">
        <div class="register">

            <!-- 用户注册表单-->
            <form  id="rf" action="/register" method="post">
                <div class="register-top-grid">
                    <h3>注册新用户</h3>
                    <div class="input">
                        <span>用户名 <label style="color:red;">*</label></span>
                        <input id="user" type="text"  name="username"  placeholder="请输入用户名" required>
                        <span id="uspan" style="color: red"></span>
                    </div>
                    <div class="input">
                        <span>密码 <label style="color:red;">*</label></span>
                        <input type="text"  name="password" placeholder="请输入密码">
                    </div>
                    <div class="input">
                        <span>收货人<label></label></span>
                        <input type="text"  name="name" placeholder="请输入收货">
                    </div>
                    <div class="input">
                        <span>收货电话<label></label></span>
                        <input type="text" name="phone" placeholder="请输入收货电话">
                    </div>
                    <div class="input">
                        <span>收货地址<label></label></span>
                        <input type="text"  name="address" placeholder="请输入收货地址">
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="register-but text-center">
                    <input type="submit" value="提交">
                    <div class="clearfix"> </div>
                </div>
            </form>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--//account-->
<!--底部页面需要引入-->
<jsp:include page="footer.jsp"/>
</body>
</html>