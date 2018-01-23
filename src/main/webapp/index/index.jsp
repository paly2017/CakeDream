<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/1/22
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl  EL--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
    <title>商品列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="index/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="index/css/style.css">
    <link type="text/css" rel="stylesheet" href="index/css/header.css">
    <script type="text/javascript" src="index/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="index/layer/layer.js"></script>
    <script type="text/javascript" src="index/js/cart.js"></script>
    <script src="index/js/header.js"></script>
    <script src="index/js/index.js"></script>
    <script src="index/js/jquery.fly.min.js"></script>
    <script src="index/js/goods.js"></script>
</head>
<body>
<jsp:include page="herder.jsp"/>
<!--banner，首页精选推荐，一个商品-->
<div class="banner">
    <div class="container">
        <h2 class="hdng"><a href="/detail?goodId=${jingPinList[0].good.id}">${jingPinList[0].good.name}</a><span></span></h2>
        <p>今日精选推荐</p>
        <a class="banner_a" href="cart.html" onclick="cartinto(this,${jingPinList[0].good.id})">立刻购买</a>
        <div class="banner-text">
            <a href="/detail?goodId=${jingPinList[0].good.id}">
                <img src="..//${jingPinList[0].good.cover}" alt="${jingPinList[0].good.name}" width="350" height="350">
            </a>
        </div>
    </div>
</div>


<!--第二部分，热销推荐和新品推荐部分-->
<!--//banner-->
<div class="subscribe2"></div>

<!--gallery-->
<div class="gallery">

    <div class="container">
        <div class="alert alert-danger">热销推荐</div>

        <!--热销推荐的蛋糕展示 div 开始-->
        <div class="gallery-grids">
            <!--一个蛋糕展示的div开始-->
            <c:forEach var="hot" items="${hotGoodList}">
                <div class="col-md-4 gallery-grid glry-two">
                    <a href="detail.action?goodid=14">
                        <img src="..//${hot.good.cover}" class="img-responsive" alt="${hot.good.name}" width="350" height="350"/>
                    </a>
                    <div class="gallery-info galrr-info-two">
                        <p>
                            <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                            <a href="detail.action?goodid=14">查看详情</a>
                        </p>
                        <a class="shop" href="javascript:" onclick="cartinto(this,${hot.good.id})">立刻购买</a>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="galy-info">
                        <p>${hot.goodType.name} > ${hot.good.name}</p>
                        <div class="galry">
                            <div class="prices">
                                <h5 class="item_price">¥ ${hot.good.price}</h5>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <!--一个蛋糕展示的div结束-->
        </div>
        <!--热销推荐的蛋糕展示 div 结束-->


        <div class="clearfix"></div>
        <div class="alert alert-info">新品推荐</div>

        <!--新品推荐的蛋糕展示 div 开始-->
        <div class="gallery-grids">
            <c:forEach var="newgood" items="${newGoodList}">
                <%-- 一个新品推荐的div--%>
                <div class="col-md-3 gallery-grid ">
                    <a href="detail.action?goodid=13">
                        <img src="..//${newgood.good.cover}" class="img-responsive" alt="${newgood.good.name}"/>
                    </a>
                    <div class="gallery-info">
                        <p>
                            <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                            <a href="detail.action?goodid=13">查看详情</a>
                        </p>
                        <a class="shop " href="javascript:" onclick="cartinto(this,newgood.good.id)">立刻购买</a>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="galy-info">
                        <p>${newgood.goodType.name} > ${newgood.good.name}</p>
                        <div class="galry">
                            <div class="prices">
                                <h5 class="item_price">¥ ${newgood.good.price}</h5>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <%-- 一个新品推荐的div结束--%>
        </div>
        <!--新品推荐的蛋糕展示 div 结束-->
    </div>
</div>
<!--//gallery-->

<!--subscribe-->
<div class="subscribe"></div>
<!--//subscribe-->

<!--底部页面需要引入-->
<jsp:include page="footer.jsp"/>

</body>
</html>
