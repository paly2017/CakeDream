/***
 * 删除type
 * @param typeId
 */
function deteleType(typeId) {
    $.ajax({
        type:"post",
        url:"/deteleType",
        data:{deleteTypeId:typeId},
        success:function (msg) {
            if (msg==="no"){
                alert("不可以删除")
            }else {
                $("table").empty();
                $("table").append(" <tr> " +
                    "        <th width='5%'>ID</th>" +
                    "        <th width='10%'>名称</th> " +
                    "        <th width= '10% '>操作</th> " +
                    "    </tr>");
                var typelist = jQuery.parseJSON(msg);
                typelist.forEach(function (value) {
                    $("table").append("  <tr> " +
                        "        <td><p>"+value.id+"</p></td> " +
                        "        <td><p>"+value.name+"</p></td> " +
                        "        <td> " +
                        "            <a class= 'btn btn-primary ' href='/typeedit?="+value.id+"'>修改</a> " +
                        "            <a class= 'btn btn-danger ' onclick= 'deteleType("+value.id+") '>删除</a> " +
                        "        </td> " +
                        "    </tr>")
                });
                alert("删除成功")

            }

        }
    })
}
