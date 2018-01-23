<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-1-23
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/header.css">
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <!--validate，注意包的引入-->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/additional-methods.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/messages_zh.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/login.js"></script>
    <script type="text/javascript" src="index/js/header.js"></script>
    <script src="js/goods.js"></script>
</head>
<body>
<jsp:include page="herder.jsp"/>
<div class="account">
    <div class="container">
        <div class="register">

            <!--登录页面-->
            <form id="lf" action="login.action" method="post">
                <div class="register-top-grid">
                    <h3>用户登录</h3>
                    <div class="input">
                        <span>用户名 <label style="color:red;">*</label></span>
                        <input type="text" id="username" name="login_username" placeholder="请输入用户名" required="required">
                        <span id="userspan"></span>
                    </div>
                    <div class="input">
                        <span>密码 <label style="color:red;">*</label></span>
                        <input type="text" id="password" name="login_password" placeholder="请输入密码" required="required">
                        <span id="passspan"></span>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <div class="register-but text-center">
                    <input type="submit" value="提交" id="submitlogin" class="">
                    <div class="clearfix"> </div>
                </div>
            </form>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!--//account-->
<jsp:include page="footer.jsp"/>
</body>
</html>
