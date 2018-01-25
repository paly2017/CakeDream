<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-1-25
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单列表</title>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
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


    <tr>
        <td><p>12</p></td>
        <td><p>299</p></td>
        <td>

        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>
                <span style="color:red;">已付款</span>
            </p>
        </td>
        <td>
            <p>
                微信
            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>
            <a class="btn btn-success" href="orderDispose.action?id=12&status=0">发货</a>
            <a class="btn btn-danger" href="orderDelete.action?id=12&status=0">删除</a>
        </td>
    </tr>
    <tr>
        <td><p>11</p></td>
        <td><p>229</p></td>
        <td>
        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>
                <span style="color:red;">已付款</span>
            </p>
        </td>
        <td>
            <p>
                微信
            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>
            <a class="btn btn-success" href="orderDispose.action?id=11&status=0">发货</a>
            <a class="btn btn-danger" href="orderDelete.action?id=11&status=0">删除</a>
        </td>
    </tr>
    <tr>
        <td><p>10</p></td>
        <td><p>229</p></td>
        <td>
        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>
                <span style="color:red;">已付款</span>
            </p>
        </td>
        <td>
            <p>
                微信
            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>
            <a class="btn btn-success" href="orderDispose.action?id=10&status=0">发货</a>
            <a class="btn btn-danger" href="orderDelete.action?id=10&status=0">删除</a>
        </td>
    </tr>
    <tr>
        <td><p>9</p></td>
        <td><p>229</p></td>
        <td>
        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>
                <span style="color:red;">已付款</span>
            </p>
        </td>
        <td>
            <p>
                微信
            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>
            <a class="btn btn-success" href="orderDispose.action?id=9&status=0">发货</a>
            <a class="btn btn-danger" href="orderDelete.action?id=9&status=0">删除</a>
        </td>
    </tr>
    <tr>
        <td><p>8</p></td>
        <td><p>299</p></td>
        <td>

        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>

                <span style="color:red;">已付款</span>


            </p>
        </td>
        <td>
            <p>
                微信


            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>

            <a class="btn btn-success" href="orderDispose.action?id=8&status=0">发货</a>


            <a class="btn btn-danger" href="orderDelete.action?id=8&status=0">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>7</p></td>
        <td><p>299</p></td>
        <td>

        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>

                <span style="color:red;">已付款</span>


            </p>
        </td>
        <td>
            <p>
                微信


            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>

            <a class="btn btn-success" href="orderDispose.action?id=7&status=0">发货</a>


            <a class="btn btn-danger" href="orderDelete.action?id=7&status=0">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>6</p></td>
        <td><p>229</p></td>
        <td>

        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>

                <span style="color:red;">已付款</span>


            </p>
        </td>
        <td>
            <p>
                微信


            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>

            <a class="btn btn-success" href="orderDispose.action?id=6&status=0">发货</a>


            <a class="btn btn-danger" href="orderDelete.action?id=6&status=0">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>5</p></td>
        <td><p>229</p></td>
        <td>

        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>

                <span style="color:red;">已付款</span>


            </p>
        </td>
        <td>
            <p>
                微信


            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>

            <a class="btn btn-success" href="orderDispose.action?id=5&status=0">发货</a>


            <a class="btn btn-danger" href="orderDelete.action?id=5&status=0">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>4</p></td>
        <td><p>229</p></td>
        <td>

        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>

                <span style="color:red;">已付款</span>


            </p>
        </td>
        <td>
            <p>
                微信


            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>

            <a class="btn btn-success" href="orderDispose.action?id=4&status=0">发货</a>


            <a class="btn btn-danger" href="orderDelete.action?id=4&status=0">删除</a>
        </td>
    </tr>

    <tr>
        <td><p>3</p></td>
        <td><p>299</p></td>
        <td>

        </td>
        <td>
            <p>lingjing</p>
            <p>12345678901</p>
            <p>123456</p>
        </td>
        <td>
            <p>

                <span style="color:red;">已付款</span>


            </p>
        </td>
        <td>
            <p>
                微信


            </p>
        </td>
        <td><p>test03</p></td>
        <td><p>2018-01-25 08:49:48</p></td>
        <td>

            <a class="btn btn-success" href="orderDispose.action?id=3&status=0">发货</a>


            <a class="btn btn-danger" href="orderDelete.action?id=3&status=0">删除</a>
        </td>
    </tr>


</table>

<br><div style='text-align:center;'>
    <a class='btn btn-info' disabled >首页</a>
    <a class='btn btn-info' disabled >上一页</a>
    <h2 style='display:inline;'>[1/2]</h2>
    <h2 style='display:inline;'>[12]</h2>
    <a class='btn btn-info' href='http://localhost:8080/ssh_cake/admin/orderList.action?page=2'>下一页</a>
    <a class='btn btn-info' href='http://localhost:8080/ssh_cake/admin/orderList.action?page=2'>尾页</a>
    <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="http://localhost:8080/ssh_cake/admin/orderList.action?page="+(this.previousSibling.value)+""'>GO</a>
</div>
<br>
</div>
</body>
</html>
