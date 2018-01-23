<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/23
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>支付成功</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="index/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="index/css/style.css">
    <script type="text/javascript" src="index/js/jquery.min.js"></script>
    <script type="text/javascript" src="index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="index/layer/layer.js"></script>
    <script type="text/javascript" src="index/js/cart.js"></script>
    <script src="index/js/jquery.fly.min.js"></script>
    <script src="index/js/goods.js"></script>
</head>
<body>
<!--引入头部-->
<jsp:include page="herder.jsp"/>

<div class="cart-items">
    <div class="container">
        <!--跳转至订单页面  -->
        <p><a class="btn btn-success" href="order.jsp">查看我的订单</a></p>
    </div>
</div>


<!--引入尾部-->
<jsp:include page="footer.jsp"/>
</body>
</html>
