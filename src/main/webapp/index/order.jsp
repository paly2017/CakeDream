<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/1/22
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<!--付款后的订单详情页面-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <link rel="stylesheet" href="css/header.css">
    <script src="js/header.js"></script>
    <script src="index/js/jquery.fly.min.js"></script>
    <script src="index/js/goods.js"></script>
</head>
<body>
<!--引入头部-->
<jsp:include page="herder.jsp"/>

<!--cart-items-->
<div class="cart-items">
    <div class="container">
        <h2>我的订单</h2>

        <table class="table table-bordered table-hover">

            <tr>
                <th width="10%">ID</th>
                <th width="10%">总价</th>
                <th width="20%">商品详情</th>
                <th width="20%">收货信息</th>
                <th width="10%">订单状态</th>
                <th width="10%">支付方式</th>
                <th width="10%">下单时间</th>
                <th width="10%">操作</th>
            </tr>

            <tr>
                <td><p>${requestScope.order.id}</p></td>
                <td><p>${requestScope.order.total}</p></td>
                <td>
                    <p></p>
                </td>
                <td>
                    <p>${requestScope.order.name}</p>
                    <p>${requestScope.order.phone}</p>
                    <p>${requestScope.order.address}</p>
                </td>
                <td>
                    <p>
                        <span style="color:red;">${requestScope.order.status}</span>
                    </p>
                </td>
                <td>
                    <p>
                        ${requestScope.order.paytype}
                    </p>
                </td>
                <td><p>${requestScope.order.systime }</p></td>
                <td>
                </td>
            </tr>
        </table>
    </div>
</div>
<!--//cart-items-->

<!--引入尾部-->
<jsp:include page="footer.jsp"/>
</body>
</html>
