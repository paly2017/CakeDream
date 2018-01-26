<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-1-25
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单列表</title>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
    <script src="admin/js/jquery.js"></script>
    <script src="admin/js/orderlist.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<br>
<ul role="tablist" class="nav nav-tabs">
    <li class="active" role="presentation"><a href="orderList.action">全部订单</a></li>
    <li  role="presentation"><a href="orderList.action?status=1">未付款</a></li>
    <li  role="presentation"><a href="orderList.action?status=2">已付款</a></li>
    <li  role="presentation"><a href="orderList.action?status=3">配送中</a></li>
    <li  role="presentation"><a href="orderList.action?status=4">已完成</a></li>
</ul>
<br>
<table class="table table-bordered table-hover">
    <tr>
        <th width="5%">ID</th>
        <th width="5%">总价</th>
        <th width="15%">商品详情</th>
        <th width="20%">收货信息</th>
        <th width="10%">订单状态</th>
        <th width="10%">支付方式</th>
        <th width="10%">下单用户</th>
        <th width="10%">下单时间</th>
        <th width="10%">操作</th>
    </tr>
    <c:forEach var="model" items="${requestScope.adminorder}" varStatus="count">
    <tr>
        <td><p>${count.count}</p></td>
        <td><p>${model.order.total}</p></td>
        <td>${model.good.name} (${model.good.price})x${model.order.amount}</td>
        <td>
            <p>${model.user.name}</p>
            <p>${model.user.phone}</p>
            <p>${model.user.address}</p>
        </td>
        <td>
            <p>
                <c:if test="${model.order.status==1}"><span style="color:red;">未付款</span></c:if>
                <c:if test="${model.order.status==2}"><span style="color:green;">已付款</span></c:if>
                <c:if test="${model.order.status==3}"><span style="color:green;">已发货</span></c:if>
                <c:if test="${model.order.status==4}"><span style="color:green;">已完成</span></c:if>
            </p>
        </td>
        <td>
            <p>
                <c:if test="${model.order.paytype==1}"><span style="color:green;">微信支付</span></c:if>
                <c:if test="${model.order.paytype==2}"><span style="color:green;">支付宝支付</span></c:if>
                <c:if test="${model.order.paytype==3}"><span style="color:green;">货到付款</span></c:if>
            </p>
        </td>
        <td><p>${model.user.username}</p></td>
        <td><p>${model.order.systime}</p></td>
        <td>
            <input type="hidden" value="${model.order.id}">
            <a class="btn btn-success" onclick="goOrder(${model.good.id})">发货</a>
            <a class="btn btn-danger" onclick="deleteOrder(${model.good.id})">删除</a>
        </td>
    </tr>
    </c:forEach>

</table>

<br><div style='text-align:center;'>
    <a class='btn btn-info' onclick="pagenext(1)">首页</a>
    <a class='btn btn-info' id="page2" onclick="pagenext(1)">上一页</a>
    <h2 style='display:inline;' id="page1">[<span id="page4" >${requestScope.pageindex}</span>/<span id="page5">${requestScope.pagecount}</span>]</h2>
    <h2 style='display:inline;'>[${requestScope.pagecount}]</h2>
    <a class='btn btn-info' id="page3" onclick="pagenext(2)">下一页</a>
    <a class='btn btn-info' onclick="pagenext(${requestScope.pagecount})">尾页</a>
    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info'onclick="pagenext(this.previousSibling.value )">GO</a>
</div>
<br>
</div>
</body>
</html>
