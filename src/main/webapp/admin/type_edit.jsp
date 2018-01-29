<%--
  Created by IntelliJ IDEA.
  User: Lewandowski
  Date: 2018/1/25
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类目编辑</title>
    <link rel="stylesheet" href="admin/css/bootstrap.css"/>
    <script src="admin/js/jquery.js"></script>
    <script src="admin/js/type.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<br><br>

<form class="form-horizontal" action="/changetype" method="post">
    <input type="hidden" name="type.id" value="1">
    <div class="form-group">
        <label for="input_name" class="col-sm-1 control-label">类目名称</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="input_name" name="type.name" value="冰淇淋系列" required="required">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
            <button type="submit" class="btn btn-success">提交修改</button>
        </div>
    </div>
</form>

<span style="color:red;"></span>
</body>
</html>
