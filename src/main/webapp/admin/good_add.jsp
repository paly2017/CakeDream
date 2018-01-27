<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品添加</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
    <%-- //jq--%>
    <script src="admin/js/jquery.js"></script>
    <script src="admin/js/good_add.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<br><br>
<form class="form-horizontal" action="/goosSave" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">名称</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name" name="goodName"  required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="input_name1" class="col-sm-1 control-label">价格</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name1" name="goodPrice" >
        </div>
    </div>
    <div class="form-group">
        <label for="input_name2" class="col-sm-1 control-label">介绍</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name2" name="goodIntro" >
        </div>
    </div>
    <div class="form-group">
        <label for="input_name3" class="col-sm-1 control-label">库存</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name3" name="goodStock" >
        </div>
    </div>
    <div class="form-group">
        <label for="input_file1" class="col-sm-1 control-label">封面图片</label>
        <div class="col-sm-6">
            <input type="file" name="cover"  id="input_file1" required="required">推荐尺寸: 500 * 500
        </div>
    </div>
    <div class="form-group">
        <label for="input_file2" class="col-sm-1 control-label">详情图片1</label>
        <div class="col-sm-6">
            <input type="file" name="image1"  id="input_file2" required="required">推荐尺寸: 500 * 500
        </div>
    </div>
    <div class="form-group">
        <label for="input_file3" class="col-sm-1 control-label">详情图片2</label>
        <div class="col-sm-6">
            <input type="file" name="image2"  id="input_file3" required="required">推荐尺寸: 500 * 500
        </div>
    </div>
    <div class="form-group">
        <label for="select_topic" class="col-sm-1 control-label">类目</label>
        <div class="col-sm-6">
            <select class="form-control" id="select_topic" onclick="getType()" name="goodTypeId">

            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
            <button type="submit" class="btn btn-success">提交保存</button>
        </div>
    </div>
</form>
</body>
</html>
