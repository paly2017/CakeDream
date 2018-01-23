<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-1-20
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl  EL--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="index/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="index/css/style.css">
    <script type="text/javascript" src="index/js/jquery.min.js"></script>
    <script type="text/javascript" src="index/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="index/js/simpleCart.min.js"></script>
    <script type="text/javascript" src="index/layer/layer.js"></script>
    <script type="text/javascript" src="index/js/cart.js"></script>
    <link rel="stylesheet" href="index/css/header.css">
    <script src="index/js/header.js"></script>
    <script src="index/js/tops.js"></script>
    <script src="index/js/jquery.fly.min.js"></script>
    <script src="index/js/goods.js"></script>

</head>
<body>
<!--头部页面;导航栏-->
<!--header-->
<jsp:include page="herder.jsp"/>

<!--products-->
<div class="products">
    <div class="container">
        <h2></h2>
        <h2>热销推荐</h2>
        <div class="col-md-12 product-model-sec">
            <c:forEach var="top" items="${limitList}">
                <div class="product-grid">
                    <a href="/detail?goodId=${top.good.id}">
                        <div class="more-product"><span> </span></div>
                        <div class="product-img b-link-stripe b-animate-go  thickbox">
                            <img src="..//${top.good.cover}" class="img-responsive" alt="${top.good.name}" width="240" height="240">
                            <div class="b-wrapper">
                                <h4 class="b-animate b-from-left  b-delay03">
                                    <button>查看详情</button>
                                </h4>
                            </div>
                        </div>
                    </a>
                    <div class="product-info simpleCart_shelfItem">
                        <div class="product-info-cust prt_name">
                            <h4>${top.good.name}</h4>
                            <span class="item_price">¥ ${top.good.price}</span>
                            <input type="button" class="item_add items" value="加入购物车" onclick="cartinto(this,${top.good.id})">
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
            </c:forEach>


            <div class="clearfix"> </div>
        </div>
        <div><div style='text-align:center;'>
            <a class='btn btn-info' href="/tops?type=${limitList[0].type}&pageNum=1">首页</a>
            <a class='btn btn-info' href="/tops?type=${limitList[0].type}&pageNum=${pageNum-1}">上一页</a>
            <h2 style='display:inline;'>[${pageNum}/${pageCount}]</h2>
            <h2 style='display:inline;'>[${pageCount}]</h2>
            <a class='btn btn-info' href="/tops?type=${limitList[0].type}&pageNum=${pageNum+1}">下一页</a>
            <a class='btn btn-info' href="/tops?type=${limitList[0].type}&pageNum=${pageCount}">尾页</a>
            <input id="hotgo" type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info'  onclick="go(${limitList[0].type},this)">GO</a>
        </div>
        </div>
    </div>
</div>
<!--//products-->
<!--底部页面需要引入-->
<!--footer-->
<jsp:include page="footer.jsp"/>
<!--//footer-->
</body>
</html>