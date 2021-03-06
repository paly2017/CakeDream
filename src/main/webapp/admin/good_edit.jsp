<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品编辑</title>
    <meta charset="utf-8"/>
    <%-- //jq--%>
    <script src="admin/js/jquery.js"></script>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>

<br><br>
<form class="form-horizontal" action="/edite" method="post" enctype="multipart/form-data">
    <input type="hidden" name="goodId" value="${oneGood.id}"/>
    <input type="hidden" name="good.cover" value="/picture/14-1.jpg"/>
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">名称</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name" name="goodName" value="${oneGood.name}" required="required">
        </div>
    </div>
    <div class="form-group">
        <label for="input_name1" class="col-sm-1 control-label">价格</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name1" name="goodPrice" value="${oneGood.price}">
        </div>
    </div>
    <div class="form-group">
        <label for="input_name2" class="col-sm-1 control-label">介绍</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name2" name="goodIntro" value="${oneGood.intro}.">
        </div>
    </div>
    <div class="form-group">
        <label for="input_name3" class="col-sm-1 control-label">库存</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name3" name="goodStock" value="${oneGood.stock}">
        </div>
    </div>
    <div class="form-group">
        <label for="input_file1" class="col-sm-1 control-label">封面图片</label>
        <div class="col-sm-6"><img src="..//${oneGood.cover}" width="100" height="100"/>
            <input type="file" name="cover"  id="input_file1">推荐尺寸: 500 * 500
        </div>
    </div>
    <div class="form-group">
        <label for="input_file2" class="col-sm-1 control-label">详情图片1</label>
        <div class="col-sm-6"><img src="..//${oneGood.image1}" width="100" height="100"/>
            <input type="file" name="image1"  id="input_file2">推荐尺寸: 500 * 500
        </div>
    </div>
    <div class="form-group">
        <label for="input_file3" class="col-sm-1 control-label">详情图片2</label>
        <div class="col-sm-6"><img src="..//${oneGood.image2}" width="100" height="100"/>
            <input type="file" name="image2"  id="input_file3">推荐尺寸: 500 * 500
        </div>
    </div>
    <div class="form-group">
        <label for="select_topic" class="col-sm-1 control-label">类目</label>
        <div class="col-sm-6">
            <select class="form-control" id="select_topic" name="good.type.id">


                <option value="7">555</option>


                <option value="6">1</option>


                <option value="5">经典系列</option>


                <option value="4">法式系列</option>


                <option value="3">儿童系列</option>

                <option selected="selected" value="2">零食系列</option>



                <option value="1">冰淇淋系列</option>

            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
            <button type="submit" class="btn btn-success">提交修改</button>
        </div>
    </div>
</form>
</body>
</html>
