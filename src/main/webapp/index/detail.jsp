<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/1/22
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--商品详情页面--%>
<html>
<head>
    <title>商品详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/flexslider.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
    <link rel="stylesheet" href="css/header.css">
    <script>
        $(function() {
            $(".flexslider").flexslider({
                animation: "slide",
                controlNav: "thumbnails"
            });
        });
    </script>
</head>
<body>
    <%--<head>--%>
    <jsp:include page="herder.jsp"/>
    <%--</head>--%>

    <!--商品详情页面-->

    <div class="single">
        <div class="container">
            <div class="single-grids">
                <div class="col-md-4 single-grid">
                    <div class="flexslider">

                        <ul class="slides">
                            <li data-thumb="${goodDetail.cover}">
                                <div class="thumb-image"> <img src="${goodDetail.cover}" data-imagezoom="true" class="img-responsive"> </div>
                            </li>
                            <li data-thumb="${goodDetail.image1}">
                                <div class="thumb-image"> <img src="${goodDetail.image1}" data-imagezoom="true" class="img-responsive"> </div>
                            </li>
                            <li data-thumb="${goodDetail.image2}">
                                <div class="thumb-image"> <img src="${goodDetail.image2}" data-imagezoom="true" class="img-responsive"> </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4 single-grid simpleCart_shelfItem">
                    <h3>${goodDetail.name}</h3>
                    <div class="tag">
                        <p>分类 : <a href="goods.action?typeid=5">${typeDetail.name}</a></p>
                    </div>
                    <p>${goodDetail.intro}</p>
                    <div class="galry">
                        <div class="prices">
                            <h5 class="item_price">¥${goodDetail.price}</h5>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="btn_form">
                        <a href="javascript:" class="add-cart item_add" onclick="buy(6)">加入购物车</a>
                    </div>
                </div>
                <div class="col-md-4 single-grid1">
                    <!-- <h2>商品分类</h2> -->
                    <ul>
                        <li><a href="goods.html">经典系列</a></li>

                        <li><a href="goods.html">法式系列</a></li>

                        <li><a href="goods.html">儿童系列</a></li>

                        <li><a href="goods.html">零食系列</a></li>

                        <li><a href="goods.html">冰淇淋系列</a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>

    <%--<foot>--%>
    <jsp:include page="footer.jsp"/>
    <%--</foot>--%>
</body>
</html>
