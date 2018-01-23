<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/1/22
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付</title>
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
<%--<head>--%>
<jsp:include page="herder.jsp"/>
<%--</head>--%>

<div class="cart-items">
    <div class="container">
        <h2>确认收货信息</h2>
        <form class="form-horizontal" action="#" method="post" id="payform">
            <input type="hidden" name="order.id" value="1">
            <input type="hidden" name="order.paytype" id="paytype">
            <div class="row">
                <label class="control-label col-md-1">收货人</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="order.name" value="${sessionScope.user.name}" style="height:auto;padding:10px;" placeholder="输入收货人" required="required"><br>
                </div>
            </div>
            <div class="row">
                <label class="control-label col-md-1">收货电话</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="order.phone" value="${sessionScope.user.phone }" style="height:auto;padding:10px;" placeholder="输入收货电话" required="required"><br>
                </div>
            </div>
            <div class="row">
                <label class="control-label col-md-1">收货地址</label>
                <div class="col-md-6">
                    <input type="text" class="form-control" name="order.address" value="${sessionScope.user.address }" style="height:auto;padding:10px;" placeholder="输入收货地址" required="required"><br>
                </div>
            </div>
        </form>

        <br><hr><br>

        <h2>选择支付方式</h2>
        <h3>订单编号:${sessionScope.orderNumber }  支付金额: ${sessionScope.allAmount} </h3><br><br>
        <div class="col-sm-6 col-md-4 col-lg-3 ">
            <div class="thumbnail">
                <a href="payOk?payType=1">
                    <img src="images/wechat.jpg" alt="微信支付">
                </a>
            </div>
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3 ">
            <div class="thumbnail">
                <a href="payOk?payType=2">
                    <img src="images/alipay.jpg" alt="支付宝支付">
                </a>
            </div>
        </div>
        <div class="col-sm-6 col-md-4 col-lg-3 ">
            <div class="thumbnail">
                <a href="payOk?payType=3">
                    <img src="images/offline.jpg" alt="货到付款">
                </a>
            </div>
        </div>
    </div>
</div>
<script>
    function dopay(paytype) {
        function dopay(paytype){
            $("#paytype").val(paytype);
            $("#payform").submit();
        }
    }
</script>




<%--<foot>--%>
<jsp:include page="footer.jsp"/>
<%--</foot>--%>
</body>
</html>
