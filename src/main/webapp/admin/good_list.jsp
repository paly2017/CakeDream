<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2018/1/25
  Time: 12:12
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
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
   <%-- //jq--%>
    <script src="admin/js/jquery.js"></script>
    <script src="admin/js/good_list.js"></script>
</head>
<body>
<div class="container-fluid">

<%--头--%>
    <jsp:include page="header.jsp"/>


    <div class="text-right"><a class="btn btn-warning" href="/goodAdd">添加商品</a></div>

    <br>

    <ul role="tablist" class="nav nav-tabs">
        <li class="active" role="presentation"><a href="/allGood">全部商品</a></li>
        <li  role="presentation"><a href="/tops?type=1&admin=2">条幅推荐</a></li>
        <li  role="presentation"><a href="/tops?type=2&admin=2">热销推荐</a></li>
        <li  role="presentation"><a href="/tops?type=3&admin=2">新品推荐</a></li>
    </ul>


    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">ID</th>
            <th width="10%">图片</th>
            <th width="10%">名称</th>
            <th width="20%">介绍</th>
            <th width="10%">价格</th>
            <th width="10%">类目</th>
            <th width="25%">操作</th>
        </tr>

     <%--个商品展示的tr--%>
        <c:if test="${good==1}">
            <c:forEach var="good" items="${goodList}">
                <tr>
                    <td><p>${good.id}</p></td>
                    <td><p><a href="../index/detail.action?goodid=14" target="_blank"><img src="..//${good.cover}" width="100px" height="100px"></a></p></td>
                    <td><p><a href="../index/detail.action?goodid=14" target="_blank">${good.name}</a></p></td>
                    <td><p>${good.intro}</p></td>
                    <td><p>${good.price}</p></td>
                    <td><p>${good.type.name}</p></td>
                    <td>
                        <p>
                            <c:if test="${good.topScroll}"><a class="btn btn-info remove" onclick="remove(1,${good.id})">移出条幅</a></c:if>
                            <c:if test="${!good.topScroll}"><a class="btn btn-primary" onclick="addTop(1,${good.id})">加入条幅</a></c:if>
                            <c:if test="${good.topHotSale}"><a class="btn btn-info remove" onclick="remove(2,${good.id})">移出热销</a></c:if>
                            <c:if test="${!good.topHotSale}"><a class="btn btn-primary" onclick="addTop(2,${good.id})">加入热销</a></c:if>
                            <c:if test="${good.topNewgood}"><a class="btn btn-info remove" onclick="remove(3,${good.id})">移出新品</a></c:if>
                            <c:if test="${!good.topNewgood}"><a class="btn btn-primary" onclick="addTop(3,${good.id})">加入新品</a></c:if>
                        </p>
                        <a class="btn btn-success" href="goodEdit.action?id=14">修改</a>
                        <a class="btn btn-danger" href="goodDelete.action?good.id=14">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${good==2}">
        <c:forEach var="top" items="${limitList}">
            <tr>
                <td><p>${top.good.id}</p></td>
                <td><p><a href="../index/detail.action?goodid=14" target="_blank"><img src="..//${top.good.cover}" width="100px" height="100px"></a></p></td>
                <td><p><a href="../index/detail.action?goodid=14" target="_blank">${top.good.name}</a></p></td>
                <td><p>${top.good.intro}</p></td>
                <td><p>${top.good.price}</p></td>
                <td><p>${top.goodType.name}</p></td>
                <td>
                    <p>
                        <c:if test="${top.good.topScroll}"><a class="btn btn-info remove" onclick="remove(${top.good.id})">移出条幅</a></c:if>
                        <c:if test="${!top.good.topScroll}"><a class="btn btn-primary" href="/add?type=1&good.id=${top.good.id}">加入条幅</a></c:if>
                        <c:if test="${top.good.topHotSale}"><a class="btn btn-info remove" href="/remove?good.id=${top.good.id}">移出热销</a></c:if>
                        <c:if test="${!top.good.topHotSale}"><a class="btn btn-primary" href="/add?type=2&good.id=${top.good.id}}">加入热销</a></c:if>
                        <c:if test="${top.good.topNewgood}"><a class="btn btn-info remove" href="/remove?good.id=${top.good.id}">移出新品</a></c:if>
                        <c:if test="${!top.good.topNewgood}"><a class="btn btn-primary" href="/add?type=3&good.id=${top.good.id}">加入新品</a></c:if>
                    </p>
                    <a class="btn btn-success" href="goodEdit.action?id=14">修改</a>
                    <a class="btn btn-danger" href="goodDelete.action?good.id=14">删除</a>
                </td>
            </tr>
        </c:forEach>
        </c:if>
    </table>

    <br>
    <c:if test="${good==1}">
        <div style='text-align:center;'>
            <a class='btn btn-info' href="/allGood?pageNum=1" >〈首页</a>
            <a class='btn btn-info' href="/allGood?pageNum=${pageNum-1}" >〈上一页</a>
            <h2 style='display:inline;'>[${pageNum}/${pageCount}]</h2>
            <h2 style='display:inline;'>[${pageCount}]</h2>
            <a class='btn btn-info' href="/allGood?pageNum=${pageNum+1}">下一页〉</a>
            <a class='btn btn-info' href="/allGood?pageNum=${pageCount}">最后一页〉</a>
            <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' onclick="goGood(this)">GO</a>
        </div>
    </c:if>
    <c:if test="${good==2}">
    <div style='text-align:center;'>
        <a class='btn btn-info' href="/tops?type=${limitList[0].type}&pageNum=1&admin=2" >〈首页</a>
        <a class='btn btn-info' href="/tops?type=${limitList[0].type}&pageNum=${pageNum-1}&admin=2" >〈上一页</a>
        <h2 style='display:inline;'>[${pageNum}/${pageCount}]</h2>
        <h2 style='display:inline;'>[${pageCount}]</h2>
        <a class='btn btn-info' href="/tops?type=${limitList[0].type}&pageNum=${pageNum+1}&admin=2">下一页〉</a>
        <a class='btn btn-info' href="/tops?type=${limitList[0].type}&pageNum=${pageCount}&admin=2">最后一页〉</a>
        <input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info'  onclick="goTop(${limitList[0].type},this)">GO</a>
    </div>
    </c:if>
    <br>
</div>
</body>
</html>
</body>
</html>
