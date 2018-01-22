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
    <script type="text/javascript" src="index/js/jquery.min.js"></script>
    <script type="text/javascript" src="index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="index/layer/layer.js"></script>
    <script type="text/javascript" src="index/js/cart.js"></script>
    <script src="index/js/header.js"></script>
</head>
<body>
<div class="header">
    <div class="container">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <h1 class="navbar-brand"><a href="index.html">甜品店</a></h1>
            </div>
            <!--navbar-header-->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="index.html" class="active">首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle " data-toggle="dropdown">商品分类<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-2">
                            <li>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <h4>商品分类</h4>
                                        <ul class="multi-column-dropdown">

                                            <li><a class="list" href="goods.html">经典系列</a></li>

                                            <li><a class="list" href="goods.html">法式系列</a></li>

                                            <li><a class="list" href="goods.html">儿童系列</a></li>

                                            <li><a class="list" href="goods.html">零食系列</a></li>

                                            <li><a class="list" href="goods.html">冰淇淋系列</a></li>

                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li><a id="hotGood" href="top.html" >热销</a></li>
                    <li><a id="newGood" href="top.html" >新品</a></li>

                    <li><a href="register.html" >注册</a></li>
                    <li><a href="login.html" >登录</a></li>


                    <li><a href="../admin/login.html" target="_blank">后台管理</a></li>
                </ul>
                <!--/.navbar-collapse-->
            </div>
            <!--//navbar-header-->
        </nav>
        <div class="header-info">
            <div class="header-right search-box">
                <a href="javascript:;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a>
                <div class="search">
                    <form class="navbar-form" action="#">
                        <input type="text" class="form-control" name="name">
                        <button type="submit" class="btn btn-default" aria-label="Left Align">搜索</button>
                    </form>
                </div>
            </div>
            <!--购物车图标-->
            <div class="header-right cart dropdown" id="cart">
                <a href="cart.html">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span class="card_num" id="card_num">0</span></span>
                </a>
                <div class="dropdown-content">
                    <form action="" method="">
                        <table class="table table-condensed">
                            <tr>
                                <td>
                                    <img src="../picture/1-2.jpg" height="80" width="80"/>
                                </td>
                                <td>
                                    <div>晚礼服</div>
                                    <div>价钱：<span class="spice">4000</span></div>
                                    <div>数量：<span id="cake1">20</span></div>
                                    <div>
                                        <button class="btn-success" type="button" >加</button>
                                        <button class="btn-success" type="button">减</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="../picture/1-2.jpg" height="80" width="80"/>
                                </td>
                                <td>
                                    <div>晚礼服</div>
                                    <div>价钱：<span class="spice">1200</span></div>
                                    <div>数量：<span>20</span></div>
                                    <div>
                                        <button class="btn-success" type="button" >加</button>
                                        <button class="btn-success" type="button">减</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="../picture/1-2.jpg" height="80" width="80"/>
                                </td>
                                <td>
                                    <div>晚礼服</div>
                                    <div>价钱：<span class="spice">1200</span></div>
                                    <div>数量：<span>20</span></div>
                                    <div>
                                        <button class="btn-success" type="button" >加</button>
                                        <button class="btn-success" type="button">减</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="../picture/1-2.jpg" height="80" width="80"/>
                                </td>
                                <td>
                                    <div>晚礼服</div>
                                    <div>价钱：<span class="spice">1200</span></div>
                                    <div>数量：<span>20</span></div>
                                    <div>
                                        <button class="btn-success" type="button" >加</button>
                                        <button class="btn-success" type="button">减</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                            </tr>
                        </table>
                        <div class="btn-group btn-success">
                            <div class="btn btn-success" style="float: left">总价：<span id="mypay"></span> </div>
                            <div style="float: right">
                                <button type="submit" class="btn btn-success"><span>去结算</span></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="header-right login">
                <a href="my.html">
                    <span class="glyphicon" aria-hidden="true">
                    </span>
                </a>
            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix" style="float: right"></div>
    </div>
</div>
</div>

<!--banner，首页精选推荐，一个商品-->
<div class="banner">
    <div class="container">
        <h2 class="hdng"><a href="detail.html">${jingPinList[0].good.name}</a><span></span></h2>
        <p>今日精选推荐</p>
        <a class="banner_a" href="cart.html" onclick="buy(14)">立刻购买</a>
        <div class="banner-text">
            <a href="detail.html">
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
                        <a class="shop" href="javascript:;" onclick="buy(14)">立刻购买</a>
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
                        <a class="shop" href="javascript:;" onclick="buy(13)">立刻购买</a>
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
<!--footer-->
<div class="footer">
    <div class="container">
        <div class="text-center">
            <p>Compant Name © All rights Reseverd</p>
        </div>
    </div>
</div>
<!--//footer-->

</body>
</html>
