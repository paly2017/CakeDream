<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link type="text/css" rel="stylesheet" href="index/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="index/css/style.css">
    <script type="text/javascript" src="index/js/jquery.min.js"></script>
    <script type="text/javascript" src="index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="index/layer/layer.js"></script>
    <script type="text/javascript" src="index/js/cart.js"></script>
    <link rel="stylesheet" href="index/css/header.css">
    <script src="index/js/header.js"></script>
    <script src="index/js/jquery.fly.min.js"></script>
    <script src="index/js/goods.js"></script>

</head>
<body>
<!--引入头部-->
<jsp:include page="herder.jsp"/>
<%--</header>--%>

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
            <%--循环遍历输出客户不同订单的信息--%>

            <c:forEach  items="${sessionScope.orderList}" var="order" varStatus="outer">
                    <tr>
                        <%--判断两次循环的下标是否相等，相等的时候执行本次循环--%>
                        <%--<c:if test="${outer.index==inner.index&&inner.index==center.index}">--%>
                        <td><p align="cerent">${order.order.orderNo}</p></td>
                        <td><p align="cerent">${order.order.total}</p></td>
                        <td>
                            <p align="cerent">商品名称：${order.good.name}<br>单价:${order.good.price} <br>数量" ${order.item.amount}</p>
                        </td>
                        <td>
                            <p align="cerent">${order.order.name}</p>
                            <p align="cerent">${order.order.phone}</p>
                            <p align="cerent">${order.order.address}</p>
                        </td>
                        <td>
                            <p>
                                <c:if test="${order.order.status==1}"><span style="color:red;" align="cerent">未付款</span></c:if>
                                <c:if test="${order.order.status==2}"><span style="color:red;" align="cerent">已付款</span></c:if>
                                <c:if test="${order.order.status==3}"><span style="color:red;" align="cerent">已发货</span></c:if>
                                <c:if test="${order.order.status==4}"><span style="color:red;" align="cerent">已完成</span></c:if>
                            </p>
                        </td>
                        <td>
                            <c:if test="${order.order.paytype==1}"><p align="cerent">微信支付</p></c:if>
                            <c:if test="${order.order.paytype==2}"><p align="cerent">支付宝支付</p></c:if>
                            <c:if test="${order.order.paytype==3}"><p align="cerent">货到付款</p></c:if>
                        </td>
                        <td><p align="cerent">${order.order.systime}</p></td>
                        <td>
                        </td>
                        <%--</c:if>--%>
                    </tr>
                    </c:forEach>
        </table>
    </div>
</div>
<!--//cart-items-->

<!--引入尾部-->
<jsp:include page="footer.jsp"/>
<%--</foot>--%>
</body>
</html>
