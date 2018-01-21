<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-1-21
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="index/css/bootstrap.css">
    <!-- 飞入购物车-->
    <script src="index/js/jquery.fly.min.js"></script>
    <script src="index/js/goods.js"></script>
    <link rel="stylesheet" href="css/header.css">
    <script type="text/javascript" src="js/header.js"></script>

</head>
<body>
<jsp:include page="herder.jsp"/>

<div class="products">
    <div class="container">
        <h2>${requestScope.type }</h2>

        <div class="col-md-12 product-model-sec" id="goods">
            <c:forEach items="${requestScope.goods}" var="good" varStatus="count">
                <c:if test="${count.count<5}">
                  <div class="product-grid">
                     <a href="detail.action?${good.id}">
                         <div class="more-product"><span> </span></div>
                            <div class="product-img b-link-stripe b-animate-go  thickbox">
                                <img src="..//${good.cover}" class="img-responsive" alt="${good.name}" width="240" height="240">
                                  <div class="b-wrapper">
                                     <h4 class="b-animate b-from-left  b-delay03">
                                         <button>查看详情</button>
                                     </h4>
                                  </div>
                             </div>
                     </a>
                      <div class="product-info simpleCart_shelfItem">
                          <div class="product-info-cust prt_name">
                                 <h4>${good.name}</h4>
                                 <span class="item_price">¥${good.price}</span>
                                 <input type="button" class="item_add items" value="加入购物车">
                                <div class="clearfix"></div>
                          </div>
                      </div>
            </div>
                </c:if>
            </c:forEach>

            <div class="clearfix"> </div>
        </div>
        <div>
            <div style='text-align:center;'>
                <a class='btn btn-info' onclick="pageSize(1,this)" >〈首页</a>
                <a class='btn btn-info' onclick="pageSize(${requestScope.index-1},this)"  >〈上一页</a>
                <h2 style='display:inline;'>[${requestScope.index}/${requestScope.size}]</h2>
                <h2 style='display:inline;'>[${requestScope.size}]</h2>
                <a class='btn btn-info' onclick="pageSize(${requestScope.index+1},this)" >下一页〉</a>
                <a class='btn btn-info' onclick="pageSize(${requestScope.size},this)" >最后一页〉</a>
            <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="http://localhost:7070/ssh_cake/index/goods.action?page="+(this.previousSibling.value)+"&typeid=5"'>GO</a>
            </div>
        </div>
    </div>
</div>
<!--//products-->
<jsp:include page="footer.jsp"/>
</body>
</html>
