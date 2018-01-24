<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <meta charset="UTF-8">
        <title>商品列表</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
                    <li><a href="/index" class="active">首页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle " data-toggle="dropdown" id="itemclass">商品分类<b class="caret"></b></a>
                        <ul class="dropdown-menu multi-column columns-2">
                            <li>

                                <div class="row">
                                    <div class="col-sm-12">
                                        <h4>商品分类</h4>
                                        <ul class="multi-column-dropdown">
                                            <li id="typeli"><a class="list" href=""></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li><a id="hotGood" href="/tops?type=2" >热销</a></li>
                    <li><a id="newGood" href="/tops?type=3" >新品</a></li>

                    <li><a href="index/register.jsp" >注册</a></li>
                    <li><a href="index/login.jsp" >登录</a></li>


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
                <a href="/cart">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span class="card_num" id="card_num">0</span></span>
                </a>
                <div class="dropdown-content">
                    <form action="" method="">
                        <table class="table table-condensed" id="mincart">

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
            <div class="clearfix">${sessionScope.loginUser.username}</div>
        </div>
        <div class="clearfix" style="float: right"></div>
    </div>
</div>
</body>
</html>
