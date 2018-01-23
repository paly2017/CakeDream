<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/1/23
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="index/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="index/css/style.css">
    <script type="text/javascript" src="index/js/jquery.min.js"></script>
    <script type="text/javascript" src="index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="index/layer/layer.js"></script>
    <script type="text/javascript" src="index/js/cart.js"></script>
    <script src="index/js/header.js"></script>
    <link rel="stylesheet" href="index/css/header.css">
    <script src="index/js/jquery.fly.min.js"></script>
    <script src="index/js/goods.js"></script>
</head>
<body>
<%--<head>--%>
    <jsp:include page="herder.jsp"/>
<%--</head>--%>
<!--购物车页面-->
<!--cart-items-->
<div class="cart-items">
    <div class="container">
        <h2>我的购物车</h2>

<c:forEach var="cart" items="${minGoodsNum}" >
        <div class="cart-header col-md-6">
            <div class="cart-sec simpleCart_shelfItem">
                <div class="cart-item cyc">
                    <a href="/detail?goodId=${cart.good.id}">
                        <img src="..//${cart.good.cover}" class="img-responsive">
                    </a>
                </div>
                <div class="cart-item-info">
                    <h3><a href="detail?goodId=${cart.good.id}">${cart.good.name}</a></h3>
                    <h3><span>单价: ${cart.good.price}</span></h3>
                    <h3><span class="goodAmount">数量: ${cart.count}</span></h3>
                    <a class="btn btn-info" href="javascript:void(0)" onclick="add(this,${cart.good.id})">增加</a>
                    <a class="btn btn-warning" href="javascript:void(0)" onclick="dec(this,${cart.good.id})">减少</a>
                    <a class="btn btn-danger" href="javascript:void(0)" onclick="delet(${cart.good.id})">删除</a>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
</c:forEach>
        <div class="cart-header col-md-12">
            <hr>
            <h3 class="goodTotal">订单总金额: ¥ 797</h3>
            <a class="btn btn-success btn-lg" style="margin-left:74%" href="/pay?userId=1">提交订单</a>
        </div>
    </div>
</div>
<!--//cart-items-->





<%--<foot>--%>
    <jsp:include page="footer.jsp"/>
<%--</foot>--%>
</body>
</html>
